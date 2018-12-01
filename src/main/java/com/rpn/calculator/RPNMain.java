package com.rpn.calculator;

import com.rpn.exceptions.InputParseException;
import com.rpn.exceptions.InsufficientParametersException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RPNMain {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the expression or enter exit to quit");

        while (true) {
            System.out.print("Enter next input:");
            String inputString = scanner.nextLine();
            if ("exit".equals(inputString)) {
                System.exit(0);
            } else {
                try {
                    calculator.input(inputString);
                } catch (InputParseException | InsufficientParametersException ex) {
                    System.out.println(ex.getMessage());
                }
                calculator.printStack();

            }
        }

    }
}
