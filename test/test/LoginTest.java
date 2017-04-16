/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;




import static org.junit.Assert.*;
import nz.ac.aut.ense701.gameModel.Ranking;
import nz.ac.aut.ense701.gameModel.User;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class LoginTest {


    Ranking rank;
    User currentUser =new User("a","b");
     
    public LoginTest(){
        
    }
    
    @Test
    public void testloginFail() {
       User userfail=new User("textingName","textingPassword");
       User userfailpassword=new User("abc","textingPassword");
       User userSuccesfull=new User("TestTest","TestTest");
       boolean Fail1= true;
       boolean Fail2 =true;
       boolean True= false;
       if(rank.loadUser(userfail)==false){
           Fail1 = false;
       }
       if(rank.loadUser(userfailpassword)==false){
           Fail2 =false;
       }
       if(rank.loadUser(userSuccesfull)==true){
           True=true;
       }
       assertFalse("User Login fail",Fail1);
       assertFalse("User Login fail with password", Fail2);
       assertTrue("User Login Succesfull", True);
       
    }
    
}
