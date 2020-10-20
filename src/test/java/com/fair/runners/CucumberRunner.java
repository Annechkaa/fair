package com.fair.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/fair/step_definitions",
        features = "src/test/resources/features",
        plugin = {"html:target/cucumber-report.html", "json:target/cucumber.json", "rerun:target/rerun.txt"}

)






public class CucumberRunner {


}
