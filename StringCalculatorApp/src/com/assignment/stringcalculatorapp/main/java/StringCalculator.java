package com.assignment.stringcalculatorapp.main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringCalculator {

    public static void main(String[] args) {
        System.out.println("Provide input string");
        String input = "";
        try {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringCalculator stringCalculator = new StringCalculator();
        int addition = stringCalculator.add(input);
        System.out.println("Addition of the numbers in a string is " + addition);
    }

    int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        if (numbers.startsWith("//")) {
            String controlCode = numbers.substring(2, numbers.indexOf("\\n"));
            numbers = numbers.substring(numbers.indexOf("\\n") + 2);
            String[] delimitersArray = controlCode.split(",");
            for (String delimiter : delimitersArray)
                numbers = numbers.replace(delimiter, ",");
        }

        int[] numberArray = Arrays.stream(numbers.replace("\\n", "").split(",")).mapToInt(Integer::parseInt).toArray();

        int addition = 0;
        List<Integer> negativeNumbers = new ArrayList<>();
        for (int number : numberArray) {
            if (number < 0) {
                negativeNumbers.add(number);
                continue;
            } else if (number > 1000) {
                continue;
            }
            addition += number;
        }
        if (negativeNumbers.size() > 0)
            throw new IllegalArgumentException("Negatives not allowed. Invalid numbers are " + negativeNumbers.toString());
        return addition;
    }
}
