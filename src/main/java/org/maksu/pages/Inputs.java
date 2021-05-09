package org.maksu.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inputs extends Base {

    By inputLocator = new By.ByCssSelector("div input");


    public Inputs(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("/inputs"));
        Assertions.assertTrue(isDisplayed(inputLocator) ,
                "Not on inputs page!");
    }

    public void setInput(String value){
        type(value , inputLocator);
    }

    public Boolean checkInput(){
        String value = getInput();
        if (value.length() > 0){
            return true;
        }
        return false ;
    }

    private String getInput(){
        return getAttributeOf(find(inputLocator) , "value");
    }








}
