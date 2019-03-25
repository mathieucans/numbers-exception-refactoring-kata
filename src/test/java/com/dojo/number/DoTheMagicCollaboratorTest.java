package com.dojo.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class DoTheMagicCollaboratorTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private DoTheMagicCollaborator magicCollaborator;

    @Test
    void devil_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.devilResult("Devil exception");

        verify(logger).log("The devil's message: Devil exception");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void bad_luck_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.badLuckResult("Bad luck exception");

        verify(logger).log("Bad luck message: Bad luck exception");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void too_low_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.tooLowResult("Too low exception");

        verify(logger).log("Too low: Too low exception");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void odd_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.oddResult("Odd exception");

        verify(logger).log("Weird case: Odd exception");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void negative_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.negativeResult("Run time exception");

        verify(logger).log("Just in case: Run time exception");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void give_me_five_result_should_be_log_and_result_set_to_minsus_one() {
        magicCollaborator.giveMeFive();

        verify(logger).log("double dispatch pan pan");
        assertThat(magicCollaborator.getResult()).isEqualTo(-1);
    }

    @Test
    void numeric_result_should_be_log_and_result_set_to_given_number() {
        magicCollaborator.numericResult(123);

        assertThat(magicCollaborator.getResult()).isEqualTo(123);
    }
}
