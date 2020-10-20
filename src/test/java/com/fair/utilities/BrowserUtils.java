package com.fair.utilities;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.*;

public class BrowserUtils {
    public static void takeScreenshot(){

        TakesScreenshot takesScreenshot= (TakesScreenshot)Driver.getDriver();
        byte [] screenshot=takesScreenshot.getScreenshotAs(OutputType.BYTES);
        String path=System.clearProperty("user.dir")+ File.separator+"screenshots"+"Image.png";



        try {
            FileOutputStream fileOutputStream=new FileOutputStream(path);
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
