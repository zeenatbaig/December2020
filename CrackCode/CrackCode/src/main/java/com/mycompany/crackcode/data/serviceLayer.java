/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.util.List;

/**
 *
 * @author zeenatbaig
 */
public interface serviceLayer {
    public Game begin();
    public Round guess(Round round);
    public List<Game> getGames();
    public Game getGameId(int idGame);
    public List<Round> getRounds(int idGame);
    public int setGuess(int guess) throws DuplicateNumberException;
    public int setIdGame(int idGame) throws NotInTableException;
}
