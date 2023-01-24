package org.jeffrey.week2.calculator;

import net.objecthunter.exp4j.ValidationResult;

import java.util.Scanner;

public class CalculatorController {
  private CalculatorModel calculatorModel;
  private CalculatorView calculatorView;
  private boolean isOpen = false;

  public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView) {
    this.calculatorModel = calculatorModel;
    this.calculatorView = calculatorView;
  }

  public void open() {
    isOpen = true;
    Scanner scanner = new Scanner(System.in);

    while (isOpen) {
      System.out.print("> ");
      String input = scanner.nextLine();

      if (!input.equalsIgnoreCase("exit")) {
        calculatorModel.setExpressionBuilder(input);
        ValidationResult validationResult = calculatorModel.validate();

        if (validationResult.isValid()) {
          calculatorView.printResult(calculatorModel.evaluate());
        } else {
          calculatorView.printErrors(validationResult.getErrors());
        }

      } else {
        close();
      }
    }
  }

  private void close() {
    isOpen = false;
  }
}
