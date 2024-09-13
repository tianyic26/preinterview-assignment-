package com.example.ebaytakehome.service;

import com.example.ebaytakehome.model.CalculatorRequest;
import com.example.ebaytakehome.model.ChainCalculateRequest;
import com.example.ebaytakehome.component.Operation;
import com.example.ebaytakehome.component.operator.Operator;
import com.example.ebaytakehome.component.OperatorFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculateService {
    private final Map<Operation, Operator> operators;

    public CalculateService(Map<Operation, Operator> operators) {
        this.operators = operators;
    }

    public double calculate(CalculatorRequest request) throws Exception {

        Operation tempOp = Operation.valueOf(request.getOperator().toUpperCase());
        Operator op = OperatorFactory.getOperator(tempOp);


        double result = op.calculate(request.getNum1(), request.getNum2());
        return result;
    }



    public double chainCalculate(ChainCalculateRequest request){
        if (request.getOperations().size() != request.getNums().size()) {
            throw new IllegalArgumentException("Number of operations must match number of operands");
        }
        double result = request.getInitValue();
        System.out.println("init " + result);
        for (int i =0; i < request.getOperations().size(); i++){
            Operation tempOp = Operation.valueOf(request.getOperations().get(i).toUpperCase());
            Operator op = OperatorFactory.getOperator((tempOp));

            if (op == null){
                throw new RuntimeException("Operator cannot be null");

            }
            double value = request.getNums().get(i);
            result = op.calculate(result, value);
            System.out.println(result);

        }
        return result;

    }

}
