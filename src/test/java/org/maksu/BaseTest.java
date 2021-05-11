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
    static String browser = System.getProperty("Browser");

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    @BeforeAll
    static void setProp(){
        switch (browser.toLowerCase()){
            case "chrome" :
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
                break;
        }
    }

    @BeforeEach
    public void initateBrowser(){
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
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
