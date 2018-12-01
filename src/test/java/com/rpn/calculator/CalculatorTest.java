package com.rpn.calculator;

import com.rpn.exceptions.InsufficientParametersException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = null;

    @Before public void setUp() {
        calculator = new Calculator();
    }

    @Test public void testCaseCompareValues() throws Exception {
        calculator.input("5 2");
        assertEquals("5 2", calculator.stackState());
    }

    @Test public void testCaseSqrtClearSqrt() throws Exception {
        calculator.input("2 sqrt");

        assertEquals("1.4142135623", calculator.stackState());

        calculator.input("clear 9 sqrt");

        assertEquals("3", calculator.stackState());
    }

    @Test public void testCaseSubClear() throws Exception {
        calculator.input("5 2 -");

        assertEquals("3", calculator.stackState());

        calculator.input("3 -");

        assertEquals("0", calculator.stackState());

        calculator.input("clear");

        assertEquals("", calculator.stackState());
    }

    @Test public void testCaseUndoMulMulUndo() throws Exception {
        calculator.input("5 4 3 2");

        assertEquals("5 4 3 2", calculator.stackState());

        calculator.input("undo undo *");

        assertEquals("20", calculator.stackState());

        calculator.input("5 *");

        assertEquals("100", calculator.stackState());

        calculator.input("undo");

        assertEquals("20 5", calculator.stackState());
    }

    @Test public void testCaseDivMulDiv() throws Exception {
        calculator.input("7 12 2 /");

        assertEquals("7 6", calculator.stackState());

        calculator.input("*");

        assertEquals("42", calculator.stackState());

        calculator.input("4 /");

        assertEquals("10.5", calculator.stackState());
    }

    @Test public void testCaseMulClearSub() throws Exception {
        calculator.input("1 2 3 4 5");

        assertEquals("1 2 3 4 5", calculator.stackState());

        calculator.input("*");

        assertEquals("1 2 3 20", calculator.stackState());

        calculator.input("clear 3 4 -");

        assertEquals("-1", calculator.stackState());
    }

    @Test public void testCaseMul() throws Exception {
        calculator.input("1 2 3 4 5");

        assertEquals("1 2 3 4 5", calculator.stackState());

        calculator.input("* * * *");

        assertEquals("120", calculator.stackState());
    }

    @Test public void testCaseInsufficientParamtersException() throws Exception {
        try {
            calculator.input("1 2 3 * 5 + * * 6 8");
        } catch (InsufficientParametersException e) {
            System.out.println(e.getMessage());
            assertEquals(
                "WARNING:operator * (position: 15 ): insufficient parameters.\nThe [6, 8] were not pushed to stack due to previous error",
                e.getMessage());
        }

    }

    @Test public void testCaseInsufficientParameters() throws Exception {
        calculator.input("1 2 3 * 5");
        assertEquals("1 6 5", calculator.stackState());
        try {
            calculator.input("+ * - 6 5");
        } catch (InsufficientParametersException e) {
            System.out.println(e.getMessage());
            assertEquals(
                "WARNING:operator - (position: 5 ): insufficient parameters.\nThe [6, 5] were not pushed to stack due to previous error",
                e.getMessage());
        }

    }



}
