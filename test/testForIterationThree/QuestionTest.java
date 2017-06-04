package testForIterationThree;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import nz.ac.aut.ense701.gameModel.Question;
import nz.ac.aut.ense701.gameModel.Rebirth;


public class QuestionTest extends TestCase {
	
	
	private ArrayList<Question> questions;
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
	public void QuestionSizeTest(){
		rebirth =new Rebirth();
		assertTrue("The ActionAnimation should start",rebirth.getQuestionSize()>=30);
	}

	
}
