package org.maksu;

import org.junit.jupiter.api.*;
import org.maksu.pages.BrokenImage;

public class Test_Broken_Images extends BaseTest{

    @Test
    public void broken_image_test() {
        BrokenImage brokenImage = new BrokenImage(driver);
        Assertions.assertTrue(brokenImage.brokenImageExist() ,
                "Page has broken images!");
    }

}
