package org.maksu;

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
    String browser = System.getProperty("Browser");

    @BeforeAll
    static void beforeClass(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver");
    }

    @BeforeEach
    public void beforeMethod(){
        if ("firefox".equals(browser)) {
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
