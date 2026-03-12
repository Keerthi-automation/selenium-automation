package com.auto.doodle.google;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.auto.doodle.steps",
    plugin = { "pretty", "html:target/cucumber-reports.html",  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" , "json:target/cucumber.json" },
    monochrome = true
)
public class Runnerdoodle {
	
}
