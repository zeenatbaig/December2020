/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.TestApplicationConfiguration;
import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author zeenatbaig
 */

public class serviceLayerImplTest {
    private serviceLayer service;
    
  
    public serviceLayerImplTest() {
        GameDao gameDao = new GameDaoStub();
    RoundDao roundDao = new RoundDaoStub();
   
    service = new serviceLayerImpl( gameDao, roundDao);  
       
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of begin method, of class serviceLayerImpl.
     */
    @Test
    public void testBegin() {
    }

    /**
     * Test of guess method, of class serviceLayerImpl.
     *
    @Test
    public void testGuess() {
        Round round = new Round();
        Round round2 = service.guess(round);
        Game game = new Game();
        game.setIdGame(1);
        int idGame = game.getIdGame();
        List<Round> rounds = service.getRounds(idGame);
        Round round1 =rounds.get(0);
        assertEquals(round2,round2);
      
    }
       */
    /**
     * Test of getGames method, of class serviceLayerImpl.
     */
    @Test
    public void testGetGames() {
    }

    /**
     * Test of getGameId method, of class serviceLayerImpl.
     */
    @Test
    public void testGetGameId() {
    }

    /**
     * Test of getRounds method, of class serviceLayerImpl.
     */
    @Test
    public void testGetRounds() {
    }

    /**
     * Test of setGuess method, of class serviceLayerImpl.
     */
    @Test
    public void testSetGuess() throws Exception {
    }
    
}
