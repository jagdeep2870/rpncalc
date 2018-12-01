package com.rpn.operations.number;

import com.rpn.calculator.InputNumber;
import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;

import java.math.BigDecimal;

public class SqrtOperation extends NumberOperation
{
    @Override
    public void perform(Calculator calculator) throws InsufficientParametersException
    {
        InputNumber inputNumber = popInputNumber(calculator);
        calculator.push(new InputNumber(new BigDecimal(Math.sqrt(inputNumber.doubleValue()))));
    }
}
