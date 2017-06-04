package testForIterationThree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import nz.ac.aut.ense701.gameModel.Rebirth;


public class QuestionTest extends TestCase {
	
	private Rebirth rebirth;
	
	public QuestionTest() {

	}
	
	@Before
	@Override
	public void setUp() {
		rebirth =new Rebirth();
	}
	
	@After
	@Override
	public void tearDown() {
		rebirth = null;
		
	}
	
	@Test
	public void testQuestionSizeTest(){
		rebirth =new Rebirth();
		assertTrue("There should be true",(rebirth.getQuestionSize())>=20);
	}

	
}
