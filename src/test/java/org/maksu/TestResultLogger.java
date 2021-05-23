package org.maksu;

import com.google.common.io.Files;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class TestResultLogger extends BaseTest implements TestWatcher, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {

    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println(context.getDisplayName() + " test disabled with reason " + reason.get());

    }

//    @Override
//    public void testSuccessful(ExtensionContext context) {
//
//    }
//
//    @Override
//    public void testAborted(ExtensionContext context, Throwable cause) {
//
//    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println(context.getDisplayName() + " failed due to " + cause.getMessage());
        takeScreenShot();
    }


    private void takeScreenShot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver ;
        File image = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(image , new File("screenshots/123.png"));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
