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
public interface GameDao {
    Game createGame();
    Game getGame(int idGame);
   Game getGameWithAnswer(int idGame);
    List<Game> getFinishedGames();
    List<Game> getInProgressGames();
    List<Integer> getGameIds();
    void update(Game game);
}
