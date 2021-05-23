package org.maksu.tests;

import org.junit.jupiter.api.*;
import org.maksu.pages.Login;

@Tag("regression")
public class Test_Login extends BaseTest {

    @Test
    public void successful_login()  {
        Login login = new Login(driver);
        login.with(username , password );
        Assertions.assertTrue(login.successMessagePresent(),"nope!");
    }

    @Test
    public void failure_login_with_invalid_password(){
        Login login = new Login(driver);
        login.with(username , "invalid_password" );
        Assertions.assertTrue(login.failureMessagePresent(),"nope!");
    }

    @Test
    public void failure_login_with_invalid_username(){
        Login login = new Login(driver);
        login.with("invalid_username" , password );
        Assertions.assertTrue(login.failureMessagePresent(),"nope!");
    }


}
