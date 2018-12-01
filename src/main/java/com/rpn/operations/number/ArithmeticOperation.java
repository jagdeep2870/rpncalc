package com.rpn.operations.number;

import com.rpn.calculator.InputNumber;
import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;

public abstract class ArithmeticOperation extends NumberOperation {
    abstract InputNumber calculate(InputNumber x, InputNumber y);

    @Override public void perform(Calculator calculator) throws InsufficientParametersException {
        InputNumber x = popInputNumber(calculator);
        InputNumber y;

        try {
            y = popInputNumber(calculator);
        } catch (InsufficientParametersException ex) {
            calculator.push(x);
            throw ex;
        }
        calculator.push(calculate(x, y));
    }
}
