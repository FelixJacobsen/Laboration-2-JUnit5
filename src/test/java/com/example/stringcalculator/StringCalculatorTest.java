package com.example.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void emptyStringShouldBeEqualToZero(){
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void addNumberAsStringShouldReturnIntValue(){
        assertThat(stringCalculator.add("5,3")).isEqualTo(8);
    }

}
