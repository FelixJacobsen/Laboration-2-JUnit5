package com.example.stringcalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    public int add(String numbers){

        if(numbers.isEmpty())
            return 0;

        return convertToInt(numbers);
    }

    private int convertToInt(String numbers) {
        Stream<String> converter = Arrays.stream((numbers.split(",|\n")));
        return converter.mapToInt(Integer::parseInt).sum();
    }


}
