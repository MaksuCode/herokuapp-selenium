package org.maksu;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
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
    static String browser = "chrome";
//    static String classP = System.getProperty("classP");
//    static String methodP = System.getProperty("methodP");
    static String isParallel = System.getProperty("isParallel");
//    static String lifeCycle = System.getProperty("lifeCycle");

    // TODO: 8.05.2021 : Implement Selenium Grid here to have a cross-browser test execution
    @BeforeAll
    static void setProp(){
        System.getProperty("browser");
//        System.getProperty("classP");
        setJunitProperties(isParallel , null,null);
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver" , "drivers/geckodriver");
    }

    @BeforeEach
    public void initateBrowser(){
        switch (browser){
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    // TODO: 15.05.2021 fix 
    public static void setJunitProperties(String isParallel,String classParallelism , String methodParallelism) {
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration("junit-platform.properties");
            if (isParallel != null){
                conf.setProperty("junit.jupiter.execution.parallel.enabled " , isParallel);
            }
            if (methodParallelism != null){
                conf.setProperty("junit.jupiter.execution.parallel.mode.default" , methodParallelism);
            }
            if (classParallelism != null){
                conf.setProperty("junit.jupiter.execution.parallel.mode.classes.default" , classParallelism);
            }
            conf.save();
        }catch (ConfigurationException configurationException){
            configurationException.getMessage();
        }
    }













}
