/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testForIterationOne;

import nz.ac.aut.ense701.gameModel.Food;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Island;
import nz.ac.aut.ense701.gameModel.Kiwi;
import nz.ac.aut.ense701.gameModel.Occupant;
import nz.ac.aut.ense701.gameModel.Player;
import nz.ac.aut.ense701.gameModel.Position;
import nz.ac.aut.ense701.gameModel.SaveGame;
import nz.ac.aut.ense701.gameModel.Timer;
import nz.ac.aut.ense701.gameModel.User;
import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;


/**
 *
 * @author Administrator
 */
public class SaveLoadTest extends TestCase {
	SaveGame save;
	Game game;
	User user;

	public SaveLoadTest() {

	}

	@Before
	@Override
	public void setUp() {
		user = new User("TestTest", "TestTest");
		game = new Game(user,false);
		save = new SaveGame(game);
	}

	@After
	@Override
	public void tearDown() {
		game = null;
		user = null;
		
	}

	@Test
	public void testSave(){
		save.save();
		String fileName = "./data/" + user.getUserName();
		File file = new File(fileName);
		assertTrue("Record file should be exist now", file.exists());
	}
	

}
