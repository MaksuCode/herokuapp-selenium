package org.maksu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.maksu.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest implements Config {

    WebDriver driver ;
    //static String browser = System.getProperty("Browser");

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    @BeforeAll
    static void setProp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    }

    @BeforeEach
    public void initateBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    //    protected WebDriver getDriver(){
//        ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--headless");
//        options.addArguments("--incognito");
//        options.addArguments("start-maximized");
//        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
//        return new ChromeDriver(options);
//    }

//    @BeforeEach
//    public void setDriver(){
//        this.driver = getDriver();
//        driver.manage().window().maximize();
//    }












}
