package com.rpn.operations.number;

import com.rpn.calculator.InputNumber;

public class SubtractOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(y.subtract(x));
    }
}
