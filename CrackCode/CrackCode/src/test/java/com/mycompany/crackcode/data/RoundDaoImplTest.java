/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.data;
import com.mycompany.crackcode.data.GameDao;
import com.mycompany.crackcode.data.RoundDao;
import com.mycompany.crackcode.TestApplicationConfiguration;
import com.mycompany.crackcode.model.Game;
import com.mycompany.crackcode.model.Round;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.zone;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDaoImplTest {
    
    @Autowired
   GameDao gameDao;
   
    @Autowired
    RoundDao roundDao;
            
    public RoundDaoImplTest() {
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
     * Test of createRound method, of class RoundDaoImpl.
     */
   
    @Test
    public void testCreateRound() {
       
         Game game = new Game();
       
        game = gameDao.createGame();
        int guess = 1234;
        
      
        Round round = roundDao.createRound(guess, game);
        Round fromDao = roundDao.getRound(round.getRoundId());
        
        assertEquals(round.getRoundId(), fromDao.getRoundId());
    }

    /**
     * Test of getRound method, of class RoundDaoImpl.
     */
    @Test
    public void testGetRound() {
    }

    /**
     * Test of getRoundsForGame method, of class RoundDaoImpl.
     */
    @Test
    public void testGetRoundsForGame() {
    }
    
}
