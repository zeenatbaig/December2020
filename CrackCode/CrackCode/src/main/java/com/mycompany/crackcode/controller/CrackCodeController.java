/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.controller;

import com.mycompany.crackcode.data.DuplicateNumberException;
import com.mycompany.crackcode.data.GameDao;
import com.mycompany.crackcode.data.RoundDao;
import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import com.mycompany.crackcode.data.serviceLayer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zeenatbaig
 */
@RestController
@RequestMapping("/api/crackcode")
public class CrackCodeController {
    private final serviceLayer service;
 
     public CrackCodeController(serviceLayer service) {
         this.service = service;
    }
     
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public Game startGame() {
        return service.begin();
    }
    
    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
     public Round playRound( @RequestBody Round round) throws DuplicateNumberException{
        //guess = service.setGuess(guess);
       
        
        return service.guess(round);
    }
    @GetMapping("/game")
    public List<Game> getAllGames() {
        return service.getGames() ;
    }
    
    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable int gameId){
       Game result = service.getGameId(gameId);
    if (result == null) {
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(result);
    }
    
    @GetMapping("/rounds/{gameId}")
         public ResponseEntity<List<Round>> getRounds(@PathVariable int gameId){
       List<Round>  result = service.getRounds(gameId);
    if (result == null) {
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(result);
    }
}
