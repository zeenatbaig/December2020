/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.model.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class GameDaoImpl implements GameDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Game createGame() {
        final String sql = "INSERT INTO game(answer,status) VALUES(?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        Game game = new Game();
        int answer;
        List<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                numbers.add(i);
            }

            Collections.shuffle(numbers);

            String result = "";
            for(int i = 0; i < 4; i++){
                result += numbers.get(i).toString();
            }
            answer = Integer.parseInt(result);
            game.setAnswer(answer);
            game.setStatus("in-progress");
        jdbcTemplate.update(sql,
                game.getAnswer(),
                game.getStatus()); 

        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setIdGame(newId);
     
        return game;
    }

    @Override
    public Game getGame(int idGame) {
         final String sql = "SELECT idGame, status FROM game WHERE idGame = ?;";

        return jdbcTemplate.queryForObject(sql, new GameMapper(), idGame);
    }
    
     @Override
    public Game getGameWithAnswer(int idGame) {
         final String sql = "SELECT idGame,answer, status FROM game WHERE idGame = ?;";

        return jdbcTemplate.queryForObject(sql, new GameMapperWithAnswer(), idGame);
    }


    @Override
    public List<Game> getFinishedGames() {
        final String SELECT_ALL_FINISHED_GAMES = "SELECT idGame, answer, status "
                + "FROM game WHERE status = 'finished';";
         return jdbcTemplate.query(SELECT_ALL_FINISHED_GAMES, new GameMapperWithAnswer());
    }

    @Override
    public List<Game> getInProgressGames() {
        final String SELECT_ALL_PROGRESS_GAMES = "SELECT idGame,  status "
                            + "FROM game WHERE status = 'in-progress';";
         return jdbcTemplate.query(SELECT_ALL_PROGRESS_GAMES, new GameMapper());    
    }

    @Override
    public void update(Game game) {
        final String sql = "UPDATE game SET "
                + " status = ?"
                + " WHERE idGame = ?";
        jdbcTemplate.update(sql,
                game.getStatus(),
                game.getIdGame());
    }

    @Override
    public List<Integer> getGameIds() {
        final String SELECT_ALL_PROGRESS_GAMES = "SELECT idGame "
                            + "FROM game ";
        List<Game> idGames = jdbcTemplate.query(SELECT_ALL_PROGRESS_GAMES, new idGameMapper()); 
        List<Integer> idGamelist= new ArrayList<Integer>();
        for(Game game : idGames) {
            idGamelist.add(game.getIdGame());
        }
        return idGamelist;
    }

   
    
    public static final class GameMapper implements RowMapper<Game>{
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException{
            Game game = new Game();
            game.setIdGame(rs.getInt("idGame"));
            //game.setAnswer(rs.getInt("answer"));
            game.setStatus(rs.getString("status"));
            return game;
        }
    }
    
     public static final class GameMapperWithAnswer implements RowMapper<Game>{
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException{
            Game game = new Game();
            game.setIdGame(rs.getInt("idGame"));
            game.setAnswer(rs.getInt("answer"));
            game.setStatus(rs.getString("status"));
            return game;
        }
    }
      public static final class idGameMapper implements RowMapper<Game>{
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException{
            Game game = new Game();
            game.setIdGame(rs.getInt("idGame"));
            
            return game;
        }
    }
    
}
