package com.rpn.calculator;

import com.rpn.exceptions.InputParseException;
import com.rpn.operations.Operator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class InputParser {
    Optional<Operator> parseOperator(String inputOperator) {
        return Arrays.stream(Operator.values())
            .filter(operator -> operator.getOperator().equalsIgnoreCase(inputOperator)).findAny();
    }

    Optional<InputNumber> parseNumber(String number) {
        try {
            return Optional.of(new InputNumber(number));
        } catch (NumberFormatException numberFormatException) {
            return Optional.empty();
        }
    }

    IOperator parseValue(String inputToken) throws InputParseException {
        IOperator input = null;
        Optional<InputNumber> number = parseNumber(inputToken);

        if (inputToken.matches("-?\\d+(\\.\\d+)?") && number.isPresent()) {
            input = number.get();
        } else {
            Optional<Operator> operator = parseOperator(inputToken);

            if (operator.isPresent()) {
                input = operator.get();
            } else {
                throw new InputParseException(inputToken);
            }
        }

        return input;
    }

    public Queue<IOperator> parse(String inputParse) throws InputParseException {
        String[] inputs = inputParse.split("\\s+");
        Queue<IOperator> inputQueue = new LinkedList<>();

        for (String input : inputs) {
            inputQueue.add(parseValue(input.trim()));
        }

        return inputQueue;
    }
}
