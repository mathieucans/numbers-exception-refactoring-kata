package com.dojo.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


class NumberServiceTest {

    private NumberService numberService = new NumberService();

    @Test
    void returns_a_devil_result_for_666() {
        assertThat(numberService.doTheMagic(666)).isEqualTo(new DevilResult("The devil exception"));
    }

    @Test
    void returns_a_bad_luck_result_for_13(){
        assertThat(numberService.doTheMagic(13)).isEqualTo(new BadLuckResult("That's not my lucky number"));
    }

    @Test
    void give_me_five() {
        assertThat(numberService.doTheMagic(5)).isInstanceOf(GiveMeFiveResult.class);

    }

    @ParameterizedTest
    @MethodSource("numbersBetween10And20Except13")
    void returns_too_low_result_for_numbers_between_10_and_20_except_13(int number){
        assertThat(numberService.doTheMagic(number)).isEqualTo(new TooLowResult("You can do better"));
    }

    static IntStream numbersBetween10And20Except13() {
        return IntStream.range(10, 21).filter(i -> i != 13);
    }

    @ParameterizedTest
    @MethodSource("evenNumbersBetween100And200")
    void return_3_times_the_number_for_even_numbers_between_100_and_200(int number) {
        assertThat(numberService.doTheMagic(number)).isEqualTo(new NumericResult(number * 3));
    }

    static IntStream evenNumbersBetween100And200() {
        return IntStream.range(100, 201).filter(i -> i % 2 == 0);
    }


    @ParameterizedTest
    @MethodSource("oddNumbersBetween100And200")
    void returns_an_odd_result_for_odd_numbers_between_100_and_200(int number) {
        assertThat(numberService.doTheMagic(number)).isEqualTo(new OddResult("Hmm... no"));
    }

    static IntStream oddNumbersBetween100And200() {
        return IntStream.range(100, 201).filter(i -> i % 2 == 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -100, -21321})
    void returns_negative_result_for_negative_numbers(int number) {
        assertThat(numberService.doTheMagic(number)).isEqualTo(new NegativeResult("Should not happen"));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 34, 453, 1000})
    void return_2_times_the_number(int number) {
        assertThat(numberService.doTheMagic(number)).isEqualTo(new NumericResult(number * 2));
    }
}
