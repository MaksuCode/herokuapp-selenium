package org.maksu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.maksu.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest implements Config {

    protected WebDriver driver ;

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    protected WebDriver getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        return new ChromeDriver(options);
    }

    protected void tearDown(WebDriver driver){
        driver.quit();
    }

    @BeforeEach
    public void setDriver(){
        this.driver = getDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver(){
        tearDown(this.driver);
    }









}
