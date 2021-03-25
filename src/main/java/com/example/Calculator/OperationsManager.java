package com.example.Calculator;

import com.example.Calculator.model.Calculation;

public class OperationsManager {

    public Calculation Manage(Calculation calculation) {
        switch(calculation.getOperation()){
            case "+":
                calculation.setResult(Add(calculation.getFirst_operand(), calculation.getSecond_operand()));
                break;
            case "-":
                calculation.setResult(Minus(calculation.getFirst_operand(), calculation.getSecond_operand()));
                break;
            case "*":
                calculation.setResult(Multiply(calculation.getFirst_operand(), calculation.getSecond_operand()));
                break;
            case "/":
                calculation.setResult(Delen(calculation.getFirst_operand(), calculation.getSecond_operand()));
                break;
        }
        return calculation;
    }

    private float Add(float operand1, float operand2) {
        return operand1 + operand2;
    }

    private float Minus(float operand1, float operand2) {
        return operand1 - operand2;
    }

    private float Multiply(float operand1, float operand2) {
        return operand1 * operand2;
    }

    private float Delen(float operand1, float operand2) {
        return operand1 / operand2;
    }
}
