package se.systementor.stengameserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.systementor.stengameserver.DTO.GameResult;
import se.systementor.stengameserver.services.StatisticsService;

import java.util.Random;

// ex http://localhost:8080/api/play?yourSelection=STONE

@RestController
@CrossOrigin
public class GameController {


    @Autowired
    StatisticsService statisticsService;

    private static Random rand = new Random();
    @GetMapping("/api/play")
    public GameResult play(@RequestParam String yourSelection){
        String winner = "Tie";
        String mySelection = randomizeSelection();
        if(yourSelection == "STONE" && mySelection == "SCISSOR")winner = "You";
        if(yourSelection == "SCISSOR" && mySelection == "BAG")winner = "You";
        if(yourSelection == "BAG" && mySelection == "STONE")winner = "You";
        if(mySelection == "STONE" && yourSelection == "SCISSOR")winner = "Computer";
        if(mySelection == "STONE" && yourSelection == "SCISSOR")winner = "Computer";
        if(mySelection == "STONE" && yourSelection == "SCISSOR")winner = "Computer";

        var gameResult = new GameResult();
        gameResult.setWinner(winner);
        gameResult.setYourSelection(yourSelection);
        gameResult.setComputerSelection(mySelection);

        statisticsService.save(winner,yourSelection,mySelection);

        return gameResult;
    }

    private String randomizeSelection() {
        var index = rand.nextInt(3);
        if(index == 0) return "STONE";
        if(index == 1) return "SCISSOR";
        return "BAG";
    }
}
