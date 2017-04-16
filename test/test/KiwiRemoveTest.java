/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Island;
import nz.ac.aut.ense701.gameModel.Kiwi;
import nz.ac.aut.ense701.gameModel.Player;
import nz.ac.aut.ense701.gameModel.Position;
import nz.ac.aut.ense701.gameModel.User;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class KiwiRemoveTest extends junit.framework.TestCase {
   Position position;
    Island island;
    Game   game;
    Player player;
     
    public KiwiRemoveTest(){
        
    }
    
    
    @Before
    @Override
        public void setUp() {    
        game           = new Game(new User("TestAccount","TestAccount"),false);
        position = game.getPlayer().getPosition();
        player         = game.getPlayer();
        island = game.getIsland();   
    }
        
    @After
   @Override
    public void tearDown() {

        game = null;
        player = null;
        position= null;
    }
    
     @Test
    public void testShowingOfKiwi() {
        Kiwi kiwi = new Kiwi(position,"Kiwi", "A little spotted kiwi");
        island.addOccupant(position, kiwi); 
        game.countKiwi();
        assertFalse("Kiwi should be not on island", island.hasOccupant(position, kiwi));
       
    }
        
        
        
        
}
