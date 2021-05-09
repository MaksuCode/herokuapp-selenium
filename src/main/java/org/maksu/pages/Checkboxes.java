package org.maksu.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkboxes extends Base{

    By checkboxLocator = new By.ByCssSelector("input[type='checkbox']");


    public Checkboxes(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("/checkboxes"));
        Assertions.assertTrue(isDisplayed(checkboxLocator),
                "Not on /checkboxes pages");
    }

    public void clickCheckbox(int index){
        click(getCheckboxList().get(index));
    }

    public List<WebElement> getCheckboxList(){
        return findAll(checkboxLocator);
    }
}
