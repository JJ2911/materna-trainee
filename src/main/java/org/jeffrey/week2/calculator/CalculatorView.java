package org.jeffrey.week2.calculator;

import java.util.List;

public class CalculatorView {
  public void printResult(double result) {
    System.out.println(result);
  }

  public void printErrors(List<String> errors) {
    for (String error : errors) {
      System.out.println(error);
    }
  }
}
