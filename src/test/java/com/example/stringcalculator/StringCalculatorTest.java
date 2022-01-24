package com.example.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void emptyStringShouldBeEqualToZero(){
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void addNumbersAsStringShouldReturn13(){
        assertThat(stringCalculator.add("5,3")).isEqualTo(8);
    }

    @Test
    void addNumbersSeparatedByNewLine(){
        assertThat(stringCalculator.add("5\n2,1")).isEqualTo(8);
    }

    @Test
    void differentDelimiterShouldReturn8(){
        assertThat(stringCalculator.add("//;\n5;3")).isEqualTo(8);
    }

    @Test
    void negativeNumbersThrowAExceptionAndShowIllegalNumbers(){
        assertThatThrownBy(() -> stringCalculator.add("-3,-5"))
                .hasMessageContaining("Negative numbers is not allowed! Numbers:-3,-5");
    }

}
