package com.example.ebaytakehome.component.operator;

import org.springframework.stereotype.Component;

@Component
public class MultiplyOperator implements Operator {

    @Override
    public double calculate(double num1, double num2) {
        return num1*num2;
    }
}
