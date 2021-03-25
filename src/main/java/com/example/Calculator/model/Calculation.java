package com.example.Calculator.model;

import com.sun.javafx.beans.IDProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float first_operand;
    private float second_operand;
    private float result;
    private String operation;
    private String operation_string;

    public Calculation() {}

    public Calculation(long id, float first_operand, float second_operand, float result, String operation, String operation_string) {
        this.id = id;
        this.first_operand = first_operand;
        this.second_operand = second_operand;
        this.result = result;
        this.operation = operation;
        this.operation_string = operation_string;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getFirst_operand() {
        return first_operand;
    }

    public void setFirst_operand(float first_operand) {
        this.first_operand = first_operand;
    }

    public float getSecond_operand() {
        return second_operand;
    }

    public void setSecond_operand(float second_operand) {
        this.second_operand = second_operand;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation_string() {
        return operation_string;
    }

    public void setOperation_string(String operation_string) {
        this.operation_string = operation_string;
    }

    @Override
    public String toString() {
        String format_operand1 = first_operand == (long) first_operand ? String.format("%d", (long) first_operand) : String.format("%s", first_operand);
        String format_operand2 = second_operand == (long) second_operand ? String.format("%d", (long) second_operand) : String.format("%s", second_operand);
        String format_resullt = result == (long) result ? String.format("%d", (long) result) : String.format("%s", result);
        return format_operand1 + " " + operation + " " + format_operand2 + " = " + format_resullt;
    }
}
