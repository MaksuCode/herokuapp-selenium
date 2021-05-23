package org.maksu.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class WindowsPage extends Base{

    By clickHereLinkLocator = new By.ByCssSelector("a[href='/windows/new']");

    public WindowsPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl.concat("/windows"));
    }

    public void openNewWindow() {
        click(clickHereLinkLocator);
    }

    public Boolean isNewWindowOpened() {
        return getWindows().size() > 1;
    }

//    public Boolean checkNewlyOpenedWindow() {
//        switchToWindow(1);
//        driver.getCurrentUrl();
//
//    }

//    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        WindowsPage windowsPage = new WindowsPage(driver);
//        String windowHandles = driver.getWindowHandle();
//        System.out.println(windowHandles);
//        windowsPage.openNewWindow();
//
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        System.out.println(driver.getCurrentUrl());
//
//
//    }
}
