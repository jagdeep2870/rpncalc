package com.rpn.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InputNumber extends BigDecimal implements IOperator
{
    public InputNumber(String number)
    {
        super(number);
    }

    public InputNumber(BigDecimal bigDecimal)
    {
        super(bigDecimal.toString());
    }

    @Override
    public boolean isOperator()
    {
        return false;
    }

    public String toString()
    {
        String string = super.toPlainString();

        if (scale() >= 1) {
            BigDecimal bigDecimal = new BigDecimal(string);
            string = bigDecimal.setScale(10, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
        }

        return string;
    }
}
