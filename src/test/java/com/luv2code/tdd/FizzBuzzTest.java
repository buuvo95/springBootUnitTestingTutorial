package com.luv2code.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FizzBuzzTest {

    // If number is divisible by 3, print Fizz

    // If number is divisible by 5, print Buzz

    // If number is divisible by 3 and 5, print FizzBuzz

    // If number is NOT divisible by 3 or 5, print the number

    @DisplayName("Divisible By three")
    @Test
    @Order(1)
    void testForDivisibleByThree(){
        String expected = "Fizz";

        assertEquals(expected, FizzBuss.compute(3));
    }

    @DisplayName("Divisible By Five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuss.compute(5));
    }

    @DisplayName("Divisible By Three and Five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuss.compute(15));
    }

    @DisplayName("Not divisible By Three or Five")
    @Test
    @Order(4)
    void testForNotDivisibleByThreeOrFive() {
        String expected = "4";

        assertEquals(expected, FizzBuss.compute(4));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testWithSmallData(int value, String expected) {
        assertEquals(expected, FizzBuss.compute(value));
    }

    @DisplayName("Testing with medium data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testWithMediumData(int value, String expected) {
        assertEquals(expected, FizzBuss.compute(value));
    }

    @DisplayName("Testing with large data file")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testWithLargeData(int value, String expected) {
        assertEquals(expected, FizzBuss.compute(value));
    }

}
