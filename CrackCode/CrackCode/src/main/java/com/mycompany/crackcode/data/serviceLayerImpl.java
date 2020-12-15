/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.data.serviceLayer;
import com.mycompany.crackcode.data.GameDao;
import com.mycompany.crackcode.data.RoundDao;
import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author zeenatbaig
 */
@Repository
public class serviceLayerImpl implements serviceLayer {
    
    private final GameDao gameDao;
    private final RoundDao roundDao;
    
     public serviceLayerImpl(GameDao gameDao,RoundDao roundDao) {
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }
     
    @Override
    public Game begin() {
        Game game = gameDao.createGame();
       
       return  gameDao.getGame(game.getIdGame());
    }
    
     @Override
     public Round guess(Round round){
        int idGame = round.getGameId();
        int guess = round.getGuess();
        Game game = gameDao.getGameWithAnswer(idGame);
        Round createRound = roundDao.createRound(guess, game);
        if(createRound.getResult().equals("e:4p:4 YOU GUESSED THE RIGHT NUMBER")){
            Game game1 = new Game();
            game1.setIdGame(createRound.getGameId());
            game1.setStatus("finished");
            gameDao.update(game1);
        }
        return createRound;
        
        
    }

    @Override
    public List<Game> getGames() {
        List<Game> finishedGames = gameDao.getFinishedGames();
        List<Game> inprogressGames= gameDao.getInProgressGames();
        return Stream.concat(finishedGames.stream(), inprogressGames.stream())
                             .collect(Collectors.toList());
    }

    @Override
    public Game getGameId(int idGame) {
       return gameDao.getGame(idGame);
    }

    @Override
    public List<Round> getRounds(int idGame) {
        Game game = gameDao.getGame(idGame);
        return roundDao.getRoundsForGame(game);
    }
    
    private void varifyNumber(int guess) throws DuplicateNumberException{
         int val = guess;
        Set<Integer> set = new HashSet<Integer>(); // HashSet contains only unique elements
        int count = 0;       // keeps track of number of digits encountered in the number
      // code to get each digit from the number
        while (val > 0) {                           
            int tempVal = val % 10;
            set.add(tempVal);         // add each digit to the hash set
    // you can have a boolean check like if(!set.add(tempVal)) return false; because add() returns false if the element is already present in the set.
            val = val / 10;
            count++;
            if (count != set.size())
                 throw new DuplicateNumberException("ERROR: Number has Repeating digits");
        }
    }
    
    private void varifyIdGame(int idGame){
        List<Integer> gameIds = gameDao.getGameIds();
        if (!gameIds.contains(idGame))
            throw new NotInTableException("ERROR: no such game id");
    }
          

    @Override
    public int setGuess(int guess) throws DuplicateNumberException{
        varifyNumber(guess);
        return guess;
    }
    
    @Override
    public int setIdGame(int idGame) throws NotInTableException{
        varifyIdGame(idGame);
        return idGame;
    }
}
