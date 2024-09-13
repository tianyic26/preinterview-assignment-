package com.example.ebaytakehome.controller;
import com.example.ebaytakehome.model.CalculatorRequest;
import com.example.ebaytakehome.model.ChainCalculateRequest;
import com.example.ebaytakehome.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculateController {

    private final CalculateService calculatorService;

    @Autowired
    public CalculateController(CalculateService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public double calculate(@RequestBody CalculatorRequest request) throws Exception {
        double result = calculatorService.calculate(request);
        return result;
    }

    @PostMapping("/chaincalculate")
    public double chainCalculate(@RequestBody ChainCalculateRequest request)  {
        double result = calculatorService.chainCalculate(request);
        return result;
    }
}
