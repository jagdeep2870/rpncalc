package com.rpn.operations;

import com.rpn.calculator.Calculator;

public class ClearOperation implements CalculatorOperation
{
    @Override
    public void perform(Calculator calculator)
    {
        calculator.clear();
    }
}
