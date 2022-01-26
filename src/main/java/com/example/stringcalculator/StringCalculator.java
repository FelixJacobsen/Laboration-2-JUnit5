package com.example.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {
    private String delimiter = ",|\n";

    public int add(String numbers) {
        if (numbers.isEmpty())
            return 0;


        if(numbers.startsWith("//[")){
            customDelimiter(numbers);
        } else if (numbers.startsWith("//")){
            delimiter = numbers.charAt(2) + "|\n";
        }



        if (numbers.contains("-"))
            filterNegatives(numbers);

        return getSum(numbers, delimiter);
    }

    private void customDelimiter(String numbers) {
        Pattern pattern = Pattern.compile("\\[.*?]");
        Matcher matcher = pattern.matcher(numbers);
        buildDelimiter(matcher);
    }

    private void buildDelimiter(Matcher matcher) {
        StringBuilder stringBuilder = new StringBuilder();
        while(matcher.find()) {
            stringBuilder
                    .append("\\Q")
                    .append(matcher.group(), 1, matcher.group().length() - 1)
                    .append("\\E")
                    .append("|");
        }
        stringBuilder.append("\n");
        delimiter = stringBuilder.toString();
    }


    private IntStream getNumbers(String numbers) {
        return Arrays.stream(numbers.split(delimiter))
                .mapToInt(Integer::parseInt);
    }

    private void filterNegatives(String numbers) {
        String negatives = getNumbers(numbers)
                .filter(n -> n < 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        if (!negatives.isEmpty())
            throw new IllegalArgumentException("Negative numbers is not allowed!" +
                    " Numbers:" + negatives);
    }

    private int getSum(String numbers, String delimiter) {
        return Stream.of(numbers.split(delimiter))
                .filter(this::isNumeric)
                .mapToInt(Integer::parseInt)
                .filter(s -> s < 1001)
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
