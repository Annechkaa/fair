package com.fair.utilities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.io.FileHandler;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BrowserUtils {
    public static String date() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter d = DateTimeFormatter.ofPattern("MMMM_dd_yyyy_hh:mm:ss");
        return now.format(d);

    }


    public static void takeScreenshot() {
        File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File desfile = new File("/Users/anna/IdeaProjects/fair/screenshots/Image"+date()+".png");
        try {
            FileHandler.copy(scrFile, desfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
