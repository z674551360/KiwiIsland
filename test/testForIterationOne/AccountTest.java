/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testForIterationOne;




import static org.junit.Assert.*;
import nz.ac.aut.ense701.gameModel.Ranking;
import nz.ac.aut.ense701.gameModel.User;
import nz.ac.aut.ense701.welcome.WelcomePage;

import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class AccountTest {

	WelcomePage welcome = new WelcomePage();
    Ranking rank = new Ranking();
    String wrongFormat = "22*-55";
    String rightFormat = "TestTest";
    User userfailpassword=new User("TestTest","111");
    User userSuccesfull=new User("TestTest","TestTest");
     
    public AccountTest(){
        
    }
    
    @Test
    public void testLogin() {
       
       boolean FailPassword =true;
       boolean True= false;
       if(rank.loadUser(userfailpassword)==false){
    	   FailPassword =false;
       }
       if(rank.loadUser(userSuccesfull)==true){
           True=true;
       }
       assertFalse("User Login fail with password", FailPassword);
       assertTrue("User Login Succesfull", True);
       
    }
    
    @Test
    public void testCreate() {
       
       //We can only test failed creat, because once a account has been saved to databse, next time the test will failed
       assertFalse("User Login fail with password", rank.addUser(userfailpassword));
       
    }
    
    @Test
    public void testFormat(){
    	assertFalse("User Login fail",welcome.verifyFormat(wrongFormat));
    	assertTrue("User Login fail",welcome.verifyFormat(rightFormat));
    }
    
}
