package com.rpn.operations.number;

import com.rpn.calculator.InputNumber;

public class MultiplyOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(x.multiply(y));
    }
}
