package com.rpn.operations;

import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;

public class UndoOperation implements CalculatorOperation
{
    @Override
    public void perform(Calculator calculator) throws InsufficientParametersException
    {
        calculator.undo();
    }
}
