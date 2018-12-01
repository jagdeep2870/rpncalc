package com.rpn.operations.number;

import com.rpn.calculator.IOperator;
import com.rpn.calculator.InputNumber;
import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;
import com.rpn.operations.CalculatorOperation;

import java.util.EmptyStackException;

abstract class NumberOperation implements CalculatorOperation
{
    InputNumber popInputNumber(Calculator calculator) throws InsufficientParametersException
    {
        try {
            IOperator input = calculator.pop();
            return (InputNumber) input;
        }
        catch (EmptyStackException exception) {
            throw new InsufficientParametersException();
        }
    }
}
