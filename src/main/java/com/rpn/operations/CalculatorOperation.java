package com.rpn.operations;

import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;

public interface CalculatorOperation
{
    void perform(Calculator calculator) throws InsufficientParametersException;
}
