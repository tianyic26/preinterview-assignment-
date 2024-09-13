package com.example.ebaytakehome.model;


public class CalculatorRequest {
    private String operator;

    private double num1;

    private double num2;


    public CalculatorRequest(String operator, double num1, double num2) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
    }




    public String  getOperator() {
        return operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}
