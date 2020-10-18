package com.fair.utilities;

import io.cucumber.java8.Scenario;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.IIOException;
import java.io.*;

public class BrowserUtils {
    public static void takeScreenshot(){


        TakesScreenshot takesScreenshot= (TakesScreenshot)Driver.getDriver();
        byte [] screenshot=takesScreenshot.getScreenshotAs(OutputType.BYTES);
        String path=System.clearProperty("user.dir")+ File.separator+"screenshots"+"image.png";

        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
