package com.example.ebaytakehome.model;



import com.example.ebaytakehome.component.Operation;

import java.util.List;


public class ChainCalculateRequest {
    private double initValue;
    private List<String> operations;
    private List<Double> nums;

    public ChainCalculateRequest(double i,  List<String> operations, List<Double> nums) {
        this.initValue = i;
        this.operations = operations;
        this.nums = nums;
    }

    public double getInitValue() {
        return initValue;
    }

    public List<String> getOperations() {
        return operations;
    }

    public List<Double> getNums(){
        return nums;
    }
}
