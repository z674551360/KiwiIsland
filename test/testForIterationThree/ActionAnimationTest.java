/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testForIterationThree;

import nz.ac.aut.ense701.gui.*;
import nz.ac.aut.ense701.gameModel.*;
import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ActionAnimationTest extends TestCase {
	Position position;
	Island island;
	Game game;
	Player player;
	Occupant Predator;
	
	
	public ActionAnimationTest() {
		
	}

	@Before
	@Override
	public void setUp() {
		game = new Game(new User("TestAccount", "TestAccount"), false);
		position = game.getPlayer().getPosition();
		player = game.getPlayer();
		island = game.getIsland();
		island.addOccupant(position, Predator);
	}

	@After
	@Override
	public void tearDown() {

		game = null;
		player = null;
		position = null;
	}

    @Test
    public void testActionAnimation(){
        Item trap = new Tool(position,"Trap", "Rat trap",1.0, 1.0);
        player.collect(trap);
        Predator = new Predator(position,"Rat", "Norway rat");
        island.addOccupant(position, Predator);
        game.useItem(trap);
        assertTrue("The ActionAnimation should start",game.getActionAnimation().checkRunning());
    }
    

}
