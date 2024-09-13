package com.example.ebaytakehome.component.operator;

import com.example.ebaytakehome.component.operator.Operator;
import org.springframework.stereotype.Component;

@Component
public class SubtractOperator implements Operator {
    @Override
    public double calculate(double num1, double num2) {
        return num1-num2;
    }
}
