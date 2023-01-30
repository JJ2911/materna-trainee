package org.jeffrey.week2.guava;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import org.apache.poi.ss.usermodel.*;
import org.jeffrey.week2.calculator.CalculatorModel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Excel3000 {
  private final int MAX_COLS = 16_384;
  private final int MAX_ROWS = 1_048_576;
  private final int MAX_CELL_CHARS = 32_767;
  private final Map<Character, Integer> characterIntegerMap = new HashMap<>();
  private final Table<Integer, Integer, String> table = TreeBasedTable.create();

  public Excel3000() {
    String codes = "A1 B2 C3 D4 E5 F6 G7 H8 I9 J10 K11 L12 M13 " +
            "N14 O15 P16 Q17 R18 S19 T20 U21 V22 W23 X24 Y25 Z26";

    for (String code : codes.split(" ")) {
      characterIntegerMap.put(code.charAt(0), Integer.valueOf(code.substring(1)));
    }
  }

  public String getCellAt(String cell) {
    int[] decodedCell = decodeCellReference(cell);

    return table.get(decodedCell[0], decodedCell[1]);
  }

  public String getCellAt(int row, int col) {
    if (row <= 0 || col <= 0) {
      throw new IllegalArgumentException();
    }

    return table.get(row, col);
  }

  public void setCell(String cell, String content) {
    if (content.length() > MAX_CELL_CHARS) {
      throw new IllegalArgumentException();
    }

    int[] decodedCell = decodeCellReference(cell);

    table.put(decodedCell[0], decodedCell[1], content);
  }

  public void setCell(int row, int col, String content) {
    if (row <= 0 || col <= 0 || content.length() > MAX_CELL_CHARS) {
      throw new IllegalArgumentException();
    }

    table.put(row, col, content);
  }

  private int[] decodeCellReference(String cell) {
    int row = Integer.parseInt(cell.replaceAll("[A-Z]+", ""));

    if (row > MAX_ROWS) {
      throw new IllegalArgumentException();
    }

    String letters = cell.replaceAll("[0-9]+", "");
    int col = 0;

    for (int i = letters.length() - 1, j = 0; i >= 0; i--, j++) {
      col += Math.pow(26, i) * characterIntegerMap.get(letters.charAt(j));
    }

    if (col > MAX_COLS) {
      throw new IllegalArgumentException();
    }

    return new int[]{row, col};
  }

  public Excel3000 evaluate() {
    CalculatorModel calculatorModel = new CalculatorModel();
    Excel3000 excel3000 = new Excel3000();

    for (Table.Cell<Integer, Integer, String> cell : this.table.cellSet()) {
      if (cell.getValue().trim().charAt(0) == '=') {
        calculatorModel.setExpressionBuilder(cell.getValue());
        excel3000.setCell(cell.getRowKey(), cell.getColumnKey(), String.valueOf(calculatorModel.evaluate()));
      } else {
        excel3000.setCell(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
      }
    }

    return excel3000;
  }

  public void writeToXLSX(String fileName) throws IOException {
    Workbook workbook = WorkbookFactory.create(true);
    Sheet sheet = workbook.createSheet("Excel3000");

    for (Map.Entry<Integer, Map<Integer, String>> entry : table.rowMap().entrySet()) {
      Row row = sheet.createRow(entry.getKey() - 1);

      for (Map.Entry<Integer, String> col : entry.getValue().entrySet()) {
        Cell cell = row.createCell(col.getKey() - 1);
        cell.setCellValue(col.getValue());
      }
    }

    String fileLocation = Paths.get("").toAbsolutePath().toString() + "\\" + fileName + ".xlsx";

    FileOutputStream outputStream = new FileOutputStream(fileLocation);
    workbook.write(outputStream);
    workbook.close();
  }
}
