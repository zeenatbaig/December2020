/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zeenatbaig
 */
public class RoundDaoStub implements RoundDao {

    @Override
    public Round createRound(int guess, Game game) {
        Round round = new Round();
        int idGame = game.getIdGame();
        round.setGameId(idGame);
        round.setGuess(guess);
        round.setResult("e:4p:4");
        round.setIdRound(1);
        round.setTime(LocalTime.MIN);
        return round;
        
    }

    @Override
    public Round getRound(int idRound) {
        Round round = new Round();
        int idGame =1;
        round.setGameId(idGame);
        round.setGuess(1238);
        round.setResult("e:4p:4");
        round.setIdRound(1);
        round.setTime(LocalTime.MIN);
        return round;
    }

    @Override
    public List<Round> getRoundsForGame(Game game) {
        Round round = new Round();
        int idGame =1;
        round.setGameId(idGame);
        round.setGuess(1238);
        round.setResult("e:4p:4");
        round.setIdRound(1);
        round.setTime(LocalTime.MIN);
        List<Round> list = new ArrayList<>();
        list.add(round);
        return list;
    }
    
}
