package com.dojo.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentMatchers.eq;
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
    void number_service_is_call_with_a_instance_of_magic_collaborator()
    {
        ArgumentCaptor<DoTheMagicCollaborator> argumentCaptor = ArgumentCaptor.forClass(DoTheMagicCollaborator.class);

        int result = numberController.doTheMagic(32);

        verify(numberService).doTheMagic(eq(32), argumentCaptor.capture());
        assertThat(result).isEqualTo(argumentCaptor.getValue().getResult());
    }
}
