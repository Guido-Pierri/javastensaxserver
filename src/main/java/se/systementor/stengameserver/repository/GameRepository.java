package se.systementor.stengameserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.systementor.stengameserver.models.Game;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository <Game,Integer>{


    @Override
    List<Game> findAll();





}