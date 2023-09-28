package se.systementor.stengameserver.controllers;

import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.systementor.stengameserver.services.StatisticsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    @Mock
    private StatisticsService statisticsService;


    @Test
    @DisplayName("user is winner")
    void whenYourSelectionEqualsScissorAndMyselectionEqualsBag_thenWinnerIsYou() {

        //given
        String yourSelection = "SCISSOR";
        String mySelection = "BAG";
        String winner = "You";

        //when
        statisticsService.save(winner,yourSelection,mySelection);

        //then
        assertEquals("You", winner);
        verify(statisticsService).save(winner,yourSelection,mySelection);
        verifyNoMoreInteractions(statisticsService);


    }

}