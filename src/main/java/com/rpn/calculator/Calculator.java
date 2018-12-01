package com.rpn.calculator;

import com.rpn.exceptions.InputParseException;
import com.rpn.exceptions.InsufficientParametersException;
import com.rpn.operations.Operator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Calculator {
    private Stack<InputNumber> currentInputStack = new Stack<>();
    private LinkedList<IOperator> inputHistory = new LinkedList<>();

    public void input(String input) throws InputParseException, InsufficientParametersException {
        InputParser inputParser = new InputParser();

        Queue<IOperator> inputQueue = inputParser.parse(input.trim());
        int currentInputSize = inputQueue.size();
        try {
            while (!inputQueue.isEmpty()) {
                IOperator nextToken = inputQueue.poll();
                handleInput(nextToken);
            }
        } catch (InsufficientParametersException exception) {
            int offset = 2 * (currentInputSize - inputQueue.size()) - 1;
            Operator operator = (Operator) inputHistory.removeLast();
            String warning = String
                .format("WARNING:operator %s (position: %s ): insufficient parameters.\n",
                    operator.getOperator(), offset);
            if (inputQueue.size() > 0) {
                String error = String
                    .format("The %s were not pushed to stack due to previous error",
                        inputQueue.toString());
                warning = warning + error;
            }
            throw new InsufficientParametersException(warning);
        }
    }

    private void handleInput(IOperator inputToken) throws InsufficientParametersException {

        inputHistory.add(inputToken);
        if (inputToken.isOperator()) {
            Operator operator = (Operator) inputToken;
            operator.perform(this);
        } else {
            currentInputStack.push((InputNumber) inputToken);
        }

    }

    public void push(InputNumber inputToken) throws InsufficientParametersException {
        currentInputStack.push((InputNumber) inputToken);
    }

    public IOperator pop() {
        return currentInputStack.pop();
    }

    public void clear() {
        currentInputStack = new Stack<>();
    }

    public void undo() throws InsufficientParametersException {

        if (inputHistory.size() > 1) {
            currentInputStack = new Stack<>();

            inputHistory.removeLast();
            inputHistory.removeLast();

            LinkedList<IOperator> input =
                (LinkedList<IOperator>) inputHistory.clone();

            inputHistory = new LinkedList<>();
            for (IOperator inputToken : input) {
                handleInput(inputToken);
            }
        } else if (inputHistory.size() == 1) {
            inputHistory.removeLast();
            System.out.println("No more operations to undo:");
            printStack();
        }
    }

    public void printStack() {
        String stack =
            currentInputStack.toString().replace("[", "").replace("]", "").replaceAll(",", "");
        System.out.println("Stack:" + stack);
    }

    public String stackState() {
        return currentInputStack.toString().replace("[", "").replace("]", "").replaceAll(",", "");

    }
}
