package com.rpn.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.rpn.calculator.InputNumber;

public class InputNumberTest
{
    @Test
    public void toNumberString()
    {
        assertEquals("200", new InputNumber("200").toString());
        assertEquals("900", new InputNumber("900.00").toString());
        assertEquals("1.2", new InputNumber("1.2000").toString());
        assertEquals("1.2001", new InputNumber("1.2001").toString());
    }

}
