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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest implements Config {

    WebDriver driver ;
    static String browser = System.getProperty("Browser");

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    @BeforeAll
    static void setProp(){
        switch (browser){
            case "Chrome" :
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
                break;
        }
    }

    @BeforeEach
    public void initateBrowser(){
        switch (browser){
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "Firefox" :
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
        }
    }

    @AfterEach
    public void tearDown(){
       driver.quit();
    }











}
