package com.dojo.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberControllerTest {

    @Mock
    Logger logger;

    @Mock
    NumberService numberService;

    @InjectMocks
    NumberController numberController;

    @Test
    void returns_the_number_given_by_number_service_and_close_the_service() throws Exception {
        // Given
        final int inputNumber = 32;
        final int outputNumber = 42;
        when(numberService.doTheMagic(inputNumber)).thenReturn(new NumericResult(outputNumber));

        // When
        int result = numberController.doTheMagic(inputNumber);

        // Then
        assertThat(result).isEqualTo(outputNumber);
        verify(numberService).close();
    }

    @ParameterizedTest
    @MethodSource("exceptionsAndExpectedLogs")
    void logs_exceptions_raised_by_the_service_and_close_the_service(MagicResult result, String expectedLoggedMessage) throws Exception {
        // Given
        final int inputNumber = 72;
        when(numberService.doTheMagic(inputNumber)).thenReturn(result);

        // When
        numberController.doTheMagic(inputNumber);

        // Then
        verify(logger).log(expectedLoggedMessage);
        verify(numberService).close();
    }

    static Stream<Arguments> exceptionsAndExpectedLogs() {
        return Stream.of(
                arguments(new DevilResult("Devil exception"), "The devil's message: Devil exception"),
                arguments(new BadLuckResult("Bad luck exception"), "Bad luck message: Bad luck exception"),
                arguments(new TooLowResult("Too low exception"), "Too low: Too low exception"),
                arguments(new OddResult("Odd exception"), "Weird case: Odd exception"),
                arguments(new NegativeResult("Run time exception"), "Just in case: Run time exception"),
                arguments(new GiveMeFiveResult(), "double dispatch pan pan")
        );
    }
}
