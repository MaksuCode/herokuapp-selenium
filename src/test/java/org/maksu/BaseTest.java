package org.maksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.maksu.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements Config {

    WebDriver driver ;
    static String browser = System.getProperty("Browser");
    static String OS = System.getProperty("os.name");

    @BeforeAll
    static void beforeClass(){
        if (browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
        }else if (browser.equals("Firefox")){
            WebDriverManager.firefoxdriver().setup();
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
