package org.maksu;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junitpioneer.jupiter.SetSystemProperty;
import org.maksu.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest implements Config {

    WebDriver driver ;
    String browser = System.getProperty("browser");

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    @BeforeAll
    static void setProp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver");
    }

    @BeforeEach
    public void initateBrowser(){
        if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    // TODO: 15.05.2021 fix 
    public static void setJunitProperties(String parallelMode) {
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration("junit-platform.properties");
            conf.setProperty("junit.jupiter.execution.parallel.mode.default" , parallelMode );
            conf.save();
        }catch (ConfigurationException configurationException){
            configurationException.getMessage();
        }
    }















}
