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
import nz.ac.aut.ense701.gameModel.TimeChangeListener;
import nz.ac.aut.ense701.gameModel.Timer;
import nz.ac.aut.ense701.gameModel.User;
import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;


/**
 *
 * @author Administrator
 */
public class TimerTest extends TestCase {
	Thread timer;
	TimeChangeListener timeListenner;

	public TimerTest() {

	}

	@Before
	@Override
	public void setUp() {
		timer = new Timer(0);
	}

	@After
	@Override
	public void tearDown() {
		timer = null;
		
	}

	@Test
	public void testTimeDifferent() {
		String first, second;
		timer.start();
		first= ((Timer)timer).getTime();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		second = ((Timer)timer).getTime();
		assertFalse("Time should not be same each second", first.equals(second));
	}

}
