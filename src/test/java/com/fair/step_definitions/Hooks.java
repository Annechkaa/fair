package com.fair.step_definitions;

import com.fair.utilities.ConfigurationReader;
import com.fair.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public   class Hooks {

   @Before
    public void setup(){
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
    }
/*
    @After
   public void tearDown(){
        Driver.closeDriver();
    }



 */


}
