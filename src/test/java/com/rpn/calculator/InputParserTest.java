package com.rpn.calculator;

import static org.junit.Assert.assertEquals;

import com.rpn.calculator.InputNumber;
import com.rpn.calculator.InputParser;
import com.rpn.exceptions.InputParseException;
import com.rpn.operations.Operator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class InputParserTest
{
    private final InputParser inputParser = new InputParser();

    @Test
    public void parseNumber()
    {
        assertEquals(
                inputParser.parseNumber("7"),
                Optional.of(new InputNumber("7"))
        );
    }

    @Test
    public void failToParseNumber()
    {
        assertEquals(
                inputParser.parseNumber("as"),
                Optional.empty()
        );
    }

    @Test
    public void parseAddOperator()
    {
        assertEquals(
                inputParser.parseOperator("+"),
                Optional.of(Operator.ADD)
        );
    }

    @Test
    public void parseSubtractOperator()
    {
        assertEquals(
                inputParser.parseOperator("-"),
                Optional.of(Operator.SUBTRACT)
        );
    }

    @Test
    public void parseMultiplyOperator()
    {
        assertEquals(
                inputParser.parseOperator("*"),
                Optional.of(Operator.MULTIPLY)
        );
    }

    @Test
    public void parseDivideOperator()
    {
        assertEquals(
                inputParser.parseOperator("/"),
                Optional.of(Operator.DIVIDE)
        );
    }

    @Test
    public void parseClearOperator()
    {
        assertEquals(
                inputParser.parseOperator("clear"),
                Optional.of(Operator.CLEAR)
        );
    }

    @Test
    public void parseUndoOperator()
    {
        assertEquals(
                inputParser.parseOperator("undo"),
                Optional.of(Operator.UNDO)
        );
    }

    @Test
    public void parseSqrtOperator()
    {
        assertEquals(
                inputParser.parseOperator("sqrt"),
                Optional.of(Operator.SQRT)
        );
    }



    @Test
    public void throwException()
    {
        try {
            inputParser.parseValue("a");
        }
        catch (InputParseException exception) {
            return;
        }

        Assert.fail("Eligible for InputParseException exception");
    }
}
