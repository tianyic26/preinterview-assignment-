package com.example.ebaytakehome.component.operator;

import org.springframework.stereotype.Component;

@Component
public class DivideOperator implements Operator {

    @Override
    public double calculate(double num1, double num2) {
        if(num2 == 0){
            throw  new ArithmeticException("Division by zero");
        }
        return num1/num2;
    }
}
