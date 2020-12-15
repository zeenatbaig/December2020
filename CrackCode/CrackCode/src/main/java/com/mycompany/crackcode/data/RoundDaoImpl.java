/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.data.GameDaoImpl.GameMapper;
import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.sql.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zeenatbaig
 */
@Repository
public class RoundDaoImpl implements RoundDao{
  private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoundDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
      
    @Override
    @Transactional
    public Round createRound(int guess, Game game) {
        Round round = new Round();
        round.setGuess(guess);
        round.setGameId(game.getIdGame());
        
        String guessString = Integer.toString(guess);
        
        String answer = Integer.toString(game.getAnswer());
     
     
        // Creating array of string length 
        char[] guessC = new char[guessString.length()]; 
        char[] answrC = new char[answer.length()];
        
        int e=0;
        int p =0;
        // Copy character by character into array 
        for (int i = 0; i < guessString.length(); i++) { 
            guessC[i] = guessString.charAt(i); 
        } 
  
        for (int i = 0; i < answer.length(); i++) { 
            answrC[i] = answer.charAt(i); 
        } 
        
        for (int i = 0; i < guessString.length(); i++) { 
            if (guessC[i]==(answrC[i])){
                e++;
            } 
            if (answer.indexOf(guessC[i])!= -1 && guessC[i]!=(answrC[i])){
                p++;
            }
                
        } 
        String result = "e:"+ e+ "p:"+p;
        if(result.equals("e:4p:4")){
            result += " YOU GUESSED THE RIGHT NUMBER";
        }
        round.setResult(result);
        
        LocalTime time = LocalTime.now();
        
        round.setTime(time);
        
        final String sql = "INSERT INTO round(guess, timeGuess,result,  game_idGame) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,
                round.getGuess(),
                Time.valueOf(round.getTime()),
                round.getResult(),
                round.getGameId());
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setIdRound(newId);
        
        return round;
    }

    @Override
    public Round getRound(int idRound) {
        final String sql = "SELECT idRound, guess, timeGuess, result "
                + "FROM round WHERE idRound = ?;";

        Round round =  jdbcTemplate.queryForObject(sql, new RoundMapper(), idRound);
        round.setGameId(getGameForRound(round).getIdGame());
        return round;
    }

   

    @Override
    public List<Round> getRoundsForGame(Game game) {
        final String sql = "SELECT * FROM round WHERE game_idGame = ?";
        List<Round> rounds = jdbcTemplate.query(sql, 
                new RoundMapper(), game.getIdGame());
        
        
        return rounds;
    }
    
    public static final class RoundMapper implements RowMapper<Round>{

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setIdRound(rs.getInt("idRound"));
            round.setGuess(rs.getInt("guess"));
            round.setTime(rs.getTime("timeGuess").toLocalTime());
            round.setResult(rs.getString("result"));
            return round;
        }
        
    }
    
        private Game getGameForRound(Round round) {
        final String SELECT_Game_FOR_Round = "SELECT g.* FROM game g "
                + " JOIN round r ON g.idGame = r.game_idGame WHERE r.idRound = ?";
        return jdbcTemplate.queryForObject(SELECT_Game_FOR_Round, new GameMapper(), 
                round.getRoundId());
    }
}
