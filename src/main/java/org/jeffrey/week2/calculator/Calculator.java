package org.jeffrey.week2.calculator;

public class Calculator {
  public static void main(String[] args) {
    CalculatorController calculatorController = new CalculatorController(new CalculatorModel(), new CalculatorView());
    calculatorController.open();
  }
}
