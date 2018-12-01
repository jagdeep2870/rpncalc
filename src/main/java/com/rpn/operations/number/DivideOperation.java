package com.rpn.operations.number;

import java.math.RoundingMode;

import com.rpn.calculator.InputNumber;

public class DivideOperation extends ArithmeticOperation
{
    @Override
    public InputNumber calculate(InputNumber x, InputNumber y)
    {
        return new InputNumber(y.divide(x));
    }
}
