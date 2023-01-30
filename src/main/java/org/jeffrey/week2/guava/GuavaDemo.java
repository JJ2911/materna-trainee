package org.jeffrey.week2.guava;

import com.google.common.collect.*;

import java.io.IOException;
import java.util.Iterator;

public class GuavaDemo {
  public static void main(String[] args) {
    Multiset<String> hashMultiset = HashMultiset.create();
    hashMultiset.add("A");
    hashMultiset.add("B");
    hashMultiset.add("C");
    hashMultiset.add("A", 5);
    hashMultiset.remove("A");
    hashMultiset.remove("A", 2);
    System.out.println(hashMultiset.count("A"));
    System.out.println(hashMultiset.size());
    System.out.println(hashMultiset.elementSet());

    for (Multiset.Entry<String> entry : hashMultiset.entrySet()) {
      System.out.printf("%s: %d%n", entry.getElement(), entry.getCount());
    }

    Iterator<Multiset.Entry<String>> iterator = hashMultiset.entrySet().iterator();
    while (iterator.hasNext()) {
      Multiset.Entry<String> entry = iterator.next();
      System.out.printf("%s: %d%n", entry.getElement(), entry.getCount());
    }


    Multimap<String, Integer> multimap = MultimapBuilder.hashKeys().arrayListValues().build();
    multimap.put("A", 1);
    multimap.put("B", 1);
    multimap.put("A", 1);
    multimap.put("A", 3);
    multimap.remove("A", 1);
    System.out.println(multimap.isEmpty());
    System.out.println(multimap.get("A"));
    System.out.println(multimap.size());
    System.out.println(multimap.keySet());


    Table<Integer, String, Double> table = TreeBasedTable.create();
    table.put(1, "A", 1.23);
    table.put(1, "B", 12.3);
    table.put(2, "A", 123.);
    table.remove(1, "A");
    System.out.println(table.isEmpty());
    System.out.println(table.get(1, "B"));
    System.out.println(table.contains(1, "B"));
    System.out.println(table.cellSet());
    System.out.println(table.row(1));
    System.out.println(table.rowMap());
    System.out.println(table.rowKeySet());
    System.out.println(table.column("B"));
    System.out.println(table.columnMap());
    System.out.println(table.columnKeySet());
    System.out.println(table.size());


    RangeSet<Integer> rangeSet = TreeRangeSet.create();
    rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
    rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
    rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
    rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
    rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}


    Excel3000 excel3000 = new Excel3000();
    excel3000.setCell(1, 1, "ABC");
    excel3000.setCell("A1", "123");
    excel3000.setCell("C5", "456");
    excel3000.setCell("C1", "=12*12");
    System.out.println(excel3000.getCellAt(1, 1));
    System.out.println(excel3000.getCellAt("A1"));
    System.out.println(excel3000.getCellAt("C5"));
    System.out.println(excel3000.getCellAt("C1"));
    excel3000 = excel3000.evaluate();
    System.out.println(excel3000.getCellAt("C1"));

    try {
      excel3000.writeToXLSX("tmp");
    } catch (IOException e) {}
  }
}
