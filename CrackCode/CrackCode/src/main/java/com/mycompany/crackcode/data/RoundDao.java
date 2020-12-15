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
public interface RoundDao {
   Round createRound(int guess, Game game);
   Round getRound(int idRound);
 
   
   List<Round> getRoundsForGame(Game game);
}
