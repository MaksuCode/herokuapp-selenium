package org.maksu.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maksu.pages.WindowsPage;

public class Test_Open_New_Window extends BaseTest {

    @Test
    public void open_new_window(){
        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.openNewWindow();
        Assertions.assertTrue(windowsPage.isNewWindowOpened() ,
                "New window is not opened!");
//        Assertions.assertTrue(windowsPage.checkNewlyOpenedWindow(),
//                "Newly opened window is the correct one!");
    }


}
