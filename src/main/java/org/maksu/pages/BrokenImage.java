package org.maksu.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImage extends Base{

    By brokenImagesTitleLocator = By.className("example");
    By brokenImagesLocator = new By.ByCssSelector(".example img");

    public BrokenImage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("/broken_images"));
        Assertions.assertTrue(isDisplayed(brokenImagesTitleLocator),
                "Not on broken images page!");
    }

    public Boolean brokenImageExist(){
        return brokenImageExist(getImages());
    }

    private List<WebElement> getImages(){
        return findAll(brokenImagesLocator);
    }
}
