/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author zeenatbaig
 */
public class Round {
    int roundId;
    int gameId;
    int guess;
    String result;
    LocalTime timeGuess;
    
    public int getRoundId() {
        return roundId;
    }

    public void setIdRound(int idRound) {
        this.roundId = idRound;
    }
    
     public int getGameId() {
        return gameId;
    }

    public void setGameId(int idGame) {
        this.gameId = idGame;
    }
    
     public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
    
       public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
     public LocalTime getTime() {
        return timeGuess;
    }

    public void setTime(LocalTime time) {
        this.timeGuess = time;
    }
}
