package org.maksu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;


public class Login extends Base{

    By usernameLocator = By.name("username");
    By passwordLocator = By.id("password");
    By submitButtonLocator =  new By.ByCssSelector(".radius");
    By successMessageLocator = new By.ByCssSelector("div.flash.success");
    By failureMessageLocator = new By.ByCssSelector("div.flash.error");

    public Login(WebDriver driver){
        super(driver);
        visit(baseUrl.concat("/login"));
        Assertions.assertTrue(isDisplayed(submitButtonLocator),
                "Not on login page!");
    }

    public void with(String username , String password){
        type(username , usernameLocator);
        type(password , passwordLocator);
        submit(submitButtonLocator);
    }

    public Boolean successMessagePresent(){
        return isDisplayed(successMessageLocator);
    }

    public Boolean failureMessagePresent(){
        return isDisplayed(failureMessageLocator);
    }


}
