package com.example.stringcalculator;

import java.util.stream.Stream;

public class StringCalculator {
    private String delimiter = ",|\n";


    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        if (numbers.startsWith("//"))
            delimiter = numbers.charAt(2) + "|\n";

        return getSum(numbers, delimiter);
    }

    private int getSum(String numbers, String delimiter) {
        return Stream.of(numbers.split(delimiter))
                .filter(this::isNumeric)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public boolean isNumeric(String number) {
        try {
            Integer.parseInt(String.valueOf(number));
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }


}
