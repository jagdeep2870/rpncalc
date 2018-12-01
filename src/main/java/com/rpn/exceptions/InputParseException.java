package com.rpn.exceptions;

public class InputParseException extends Exception
{
    public InputParseException(String input)
    {
        super("Unable to parse: " + input);
    }
}
