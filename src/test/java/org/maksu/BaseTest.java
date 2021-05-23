package org.maksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.maksu.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest implements Config {

    WebDriver driver ;
    static String browser = System.getProperty("Browser");

    @BeforeAll
    public static void beforeClass(){
        if (browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
        }else{
            WebDriverManager.chromedriver().setup();
        }
    }

    @BeforeEach
    public void beforeMethod(){
        if ("Firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterMethod(){
        driver.quit();
    }

    @AfterAll
    public static void afterClass(){

    }
















}
