package com.example.ebaytakehome.config;

import com.example.ebaytakehome.component.*;

import com.example.ebaytakehome.component.operator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class CalculatorConfig {
    @Bean
    public Map<Operation, Operator> operators(
            AddOperator addOperator,
            SubtractOperator subtractOperator,
            MultiplyOperator multiplyOperator,
            DivideOperator divideOperator) {
        Map<Operation, Operator> operators = new HashMap<>();
        operators.put(Operation.ADD, addOperator);
        operators.put(Operation.SUBTRACT, subtractOperator);
        operators.put(Operation.MULTIPLY, multiplyOperator);
        operators.put(Operation.DIVIDE, divideOperator);
        return operators;
    }
}
