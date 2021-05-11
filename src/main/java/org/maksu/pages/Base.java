package org.maksu.pages;

import org.maksu.config.Config;
import org.maksu.httpclient.RequestSender;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Base implements Config {

    private WebDriver driver;
    RequestSender requestSender = new RequestSender();

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public void visit(String url){
        driver.get(url);
    }

    public WebElement find(By locator){
        highlight(locator , null);
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    public void click(By locator){
        highlight(locator , null);
        find(locator).click();
    }

    public void click(WebElement element){
        highlight(element , null);
        element.click();
    }

    public void type(String inputText , By locator){
        highlight(locator , null);
        find(locator).sendKeys(inputText);
    }

    public void submit(By locator){
        highlight(locator , null);
        find(locator).submit();
    }

    public Boolean isDisplayed(By locator){
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator) , 10);
            highlight(locator , null);
            return find(locator).isDisplayed();
        }catch (NoSuchElementException noSuchElementException){
            return false;
        }
    }

    public Boolean waitForIsDisplayed(By locator, Integer... timeout){
        try {
            waitFor(ExpectedConditions.visibilityOf(find(locator)),
                    (timeout.length > 0 ? timeout[0] : null ));
        }catch (TimeoutException timeoutException){
            return false;
        }
        return true;
    }

    private void waitFor(ExpectedCondition<WebElement> condition , Integer timeout){
        timeout = timeout != null ? timeout : 5 ;
        WebDriverWait wait = new WebDriverWait(driver , timeout);
        wait.until(condition);
    }

    /**
     * Highlights the given element for debugging purposes.
     * @param locator Locator of the element which is to be highlighted.
     * @param duration Duration in ms.
     */
    private void highlight(By locator , Integer duration) {
        duration = duration != null ? duration : 10 ;
        WebElement element = driver.findElement(locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])"
                ,element,
                "style",
                "border: 3px solid red; border-style: dashed;");
        try {
            if (duration > 0){
                Thread.sleep(duration);
                ((JavascriptExecutor)driver).executeScript( "arguments[0].setAttribute(arguments[1], arguments[2])",
                        element,
                        "style",
                        originalStyle);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void highlight(WebElement element , Integer duration) {
        duration = duration != null ? duration : 10 ;
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])"
                ,element,
                "style",
                "border: 3px solid red; border-style: dashed;");
        try {
            if (duration > 0){
                Thread.sleep(duration);
                ((JavascriptExecutor)driver).executeScript( "arguments[0].setAttribute(arguments[1], arguments[2])",
                        element,
                        "style",
                        originalStyle);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Boolean brokenImageExist(List<WebElement> elements){
        for (WebElement element : elements){
            if (requestSender.getStatusCode(getAttributeOf(element , "src")) != 200){
                return true;
            }
        }
        return false;
    }


    public String getAttributeOf(WebElement element , String attributeName){
        return element.getAttribute(attributeName);
    }

    public Boolean isSelected(WebElement element){
        return element.isSelected();
    }


}
