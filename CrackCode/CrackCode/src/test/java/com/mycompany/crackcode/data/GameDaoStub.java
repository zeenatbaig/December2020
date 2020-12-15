/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.model.Game;
import java.util.List;

/**
 *
 * @author zeenatbaig
 */

public class GameDaoStub implements GameDao {

    @Override
    public Game createGame() {
        Game game = new Game();
        game.setAnswer(1238);
        game.setIdGame(1);
        game.setStatus("in-progress");
        return game;
        
        
        
    }

    @Override
    public Game getGame(int idGame) {
        Game game = new Game();
        game.setAnswer(1238);
        game.setIdGame(1);
        game.setStatus("in-progress");
        return game;
    }

    @Override
    public List<Game> getFinishedGames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> getInProgressGames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getGameIds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Game game) {
       
    }

    @Override
    public Game getGameWithAnswer(int idGame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
