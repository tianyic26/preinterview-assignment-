package com.example.ebaytakehome.component;

import com.example.ebaytakehome.component.operator.*;

public class OperatorFactory {
    public static Operator getOperator(Operation op){
        if(op == Operation.ADD) {
            return new AddOperator();

        } else if (op == Operation.SUBTRACT){
            return new SubtractOperator();
        } else if (op == Operation.DIVIDE){
            return new DivideOperator();
        } else if (op == Operation.MULTIPLY){
            return new MultiplyOperator();
        } else{
            throw new IllegalArgumentException("Operator not supported");
        }

    }
}
