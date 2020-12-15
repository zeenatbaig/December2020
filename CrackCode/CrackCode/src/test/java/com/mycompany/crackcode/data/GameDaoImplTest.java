/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;

import com.mycompany.crackcode.TestApplicationConfiguration;
import com.mycompany.crackcode.model.Game;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDaoImplTest {
     
    
    @Autowired
   GameDao gameDao;
   
    @Autowired
    RoundDao roundDao;
    public GameDaoImplTest() {
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
     * Test of createGame method, of class GameDaoImpl.
     */
    @Test
    public void testCreateGame() {
        Game game = new Game();
        game.setAnswer(1234);
        game.setStatus("in-progress");
        game = gameDao.createGame();
        Game fromDao = gameDao.getGame(game.getIdGame());
        assertEquals(game.getIdGame(), fromDao.getIdGame());
    }

    /**
     * Test of getGame method, of class GameDaoImpl.
     */
    @Test
    public void testGetGame() {
    }

    /**
     * Test of getFinishedGames method, of class GameDaoImpl.
     */
    @Test
    public void testGetFinishedGames() {
    }

    /**
     * Test of getInProgressGames method, of class GameDaoImpl.
     */
    @Test
    public void testGetInProgressGames() {
    }

    /**
     * Test of update method, of class GameDaoImpl.
     */
    @Test
    public void testUpdate() {
    }
    
}
