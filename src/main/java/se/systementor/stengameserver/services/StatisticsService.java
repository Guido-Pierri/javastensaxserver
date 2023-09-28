package se.systementor.stengameserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.systementor.stengameserver.models.Game;
import se.systementor.stengameserver.repository.GameRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class

StatisticsService {

    @Autowired
    GameRepository gameRepository;

    private static ArrayList<Game> games = new ArrayList<Game>();

    public void save(String winner, String yourSelection, String mySelection) {
        var game = new Game();
        game.setCreated(LocalDateTime.now());
        game.setMySelection(mySelection);
        game.setYourSelection(yourSelection);
        game.setWinner(winner);
        //game.setId(games.size()+1);
        gameRepository.save(game);
    }

    public String getStatistics() {
var sb = new StringBuilder();
        sb.append("<table>");
        sb.append("<tr><th>Id</th><th>Winner</th><th>Your selection</th><th>My selection</th><th>Created</th></tr>");
        for(var game : gameRepository.findAll()){
            sb.append("<tr>");
            sb.append("<td>").append(game.getId()).append("</td>");
            sb.append("<td>").append(game.getWinner()).append("</td>");
            sb.append("<td>").append(game.getYourSelection()).append("</td>");
            sb.append("<td>").append(game.getMySelection()).append("</td>");
            sb.append("<td>").append(game.getCreated()).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();

    }
}