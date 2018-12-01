package com.rpn.operations;

import com.rpn.calculator.IOperator;
import com.rpn.calculator.Calculator;
import com.rpn.exceptions.InsufficientParametersException;
import com.rpn.operations.number.*;

public enum Operator implements IOperator
{
    ADD("+", new AddOperation()),
    SUBTRACT("-", new SubtractOperation()),
    MULTIPLY("*", new MultiplyOperation()),
    DIVIDE("/", new DivideOperation()),
    SQRT("sqrt", new SqrtOperation()),
    UNDO("undo", new UndoOperation()),
    CLEAR("clear", new ClearOperation());

    private final CalculatorOperation calculatorOperationValue;
    private final String operatorValue;

    Operator(String operator, CalculatorOperation calculatorOperation)
    {
    	operatorValue = operator;
    	calculatorOperationValue = calculatorOperation;
    }

    public void perform(Calculator calculator) throws InsufficientParametersException
    {
    	calculatorOperationValue.perform(calculator);
    }

    public String getOperator()
    {
        return operatorValue;
    }

    @Override
    public boolean isOperator()
    {
        return true;
    }

    @Override
    public String toString() {
        return getOperator();
    }
}
