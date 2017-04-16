package testForIterationOne;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import nz.ac.aut.ense701.gameModel.Food;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Hazard;
import nz.ac.aut.ense701.gameModel.Island;
import nz.ac.aut.ense701.gameModel.Kiwi;
import nz.ac.aut.ense701.gameModel.Occupant;
import nz.ac.aut.ense701.gameModel.Player;
import nz.ac.aut.ense701.gameModel.Position;
import nz.ac.aut.ense701.gameModel.Ranking;
import nz.ac.aut.ense701.gameModel.Tool;
import nz.ac.aut.ense701.gameModel.User;
import nz.ac.aut.ense701.welcome.WelcomePage;

public class MapTest extends TestCase {
	Position position;
	Island island;
	Game game;
	Player player;
	Occupant kiwi;
	User userSuccesfull = new User("TestTest", "TestTest");

	public MapTest() {

	}

	@Before
	@Override
	public void setUp() {
		game = new Game(new User("TestAccount", "TestAccount"), false);
		position = game.getPlayer().getPosition();
		player = game.getPlayer();
		island = game.getIsland();
	}

	@After
	@Override
	public void tearDown() {

		game = null;
		player = null;
		position = null;
	}

	@Test
	public void testHazardAtBirth() {
		Occupant[] mapOccupant = island.getOccupants(position);
		if (mapOccupant.length > 0) {
			for (int m = 0; m < mapOccupant.length; m++) {
				Occupant occupant = mapOccupant[m];
				String occType = occupant.getStringRepresentation();
				assertFalse("Hazard should not on birth position", occType.equals("H"));
			}
		}
	}

	@Test
	public void testHazardAtAround() {
		position = new Position(island, 0, 1);
		Occupant[] mapOccupant = island.getOccupants(position);
		if (mapOccupant.length > 0) {
			for (int m = 0; m < mapOccupant.length; m++) {
				Occupant occupant = mapOccupant[m];
				String occType = occupant.getStringRepresentation();
				assertFalse("Hazard should not on this position", occType.equals("H"));
			}
		}

		position = new Position(island, 0, 3);
		mapOccupant = island.getOccupants(position);
		if (mapOccupant.length > 0) {
			for (int m = 0; m < mapOccupant.length; m++) {
				Occupant occupant = mapOccupant[m];
				String occType = occupant.getStringRepresentation();
				assertFalse("Hazard should not on this position", occType.equals("H"));
			}
		}

		position = new Position(island, 1, 2);
		mapOccupant = island.getOccupants(position);
		if (mapOccupant.length > 0) {
			for (int m = 0; m < mapOccupant.length; m++) {
				Occupant occupant = mapOccupant[m];
				String occType = occupant.getStringRepresentation();
				assertFalse("Hazard should not on this position", occType.equals("H"));
			}
		}
	}

	@Test
	public void testHazardshouldNotWithOther() {
		for (int i = 0; i < game.getNumRows(); i++) {
			for (int n = 0; n < game.getNumColumns(); n++) {
				Occupant[] mapOccupant = island.getOccupants(new Position(island, i,n));
				if (mapOccupant.length > 0 && mapOccupant.length!=1) {
					for (int m = 0; m < mapOccupant.length; m++) {
						Occupant occupant = mapOccupant[m];
						String occType = occupant.getStringRepresentation();
						assertFalse("Hazard should not share space with others", occType.equals("H"));
					}
				}
			}
		}
	}
}
