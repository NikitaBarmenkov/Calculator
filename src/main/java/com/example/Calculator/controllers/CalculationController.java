package com.example.Calculator.controllers;

import com.example.Calculator.OperationsManager;
import com.example.Calculator.model.Calculation;
import com.example.Calculator.repository.CalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculation")
public class CalculationController {
    private CalculationRepository calculationRepository;

    private OperationsManager operationsManager;

    @Autowired
    public CalculationController(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
        operationsManager = new OperationsManager();
    }

    @GetMapping
    public List<Calculation> getCalculations() {
        return calculationRepository.findAll();
    }

    @PostMapping
    public Calculation createCalculation(@RequestBody Calculation calculation) {
        Calculation calculation_with_result = operationsManager.Manage(calculation);
        calculation_with_result.setOperation_string(calculation_with_result.toString());
        return calculationRepository.save(operationsManager.Manage(calculation_with_result));
    }
}
