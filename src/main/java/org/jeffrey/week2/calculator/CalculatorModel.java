package org.jeffrey.week2.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;

import java.util.HashMap;
import java.util.Map;

public class CalculatorModel {
  private ExpressionBuilder expressionBuilder;
  private final Map<String, Double> variables = new HashMap<>();

  public CalculatorModel() {}

  public void setExpressionBuilder(String expression) {
    if (isVariable(expression)) {
      String[] arr = extractVariable(expression);
      expressionBuilder = new ExpressionBuilder(arr[1]);
      addVariable(arr[0], expressionBuilder.build().evaluate());
    } else {
      expressionBuilder = new ExpressionBuilder(expression);
    }
  }

  private boolean isVariable(String input) {
    if (input != null && input.trim().length() != 0) {
      return input.contains("=") && input.replace(" ", "").split("=").length == 2 ? true : false;
    } else {
      throw new IllegalArgumentException();
    }
  }

  private String[] extractVariable(String input) {
    return input.replace(" ", "").split("=");
  }

  private void addVariable(String key, double value) {
    variables.put(key, value);
  }

  private Expression build() {
    return expressionBuilder
            .variables(variables.keySet())
            .build()
            .setVariables(variables);
  }

  public ValidationResult validate() {
    return build().validate();
  }

  public double evaluate() {
    return build().evaluate();
  }
}
