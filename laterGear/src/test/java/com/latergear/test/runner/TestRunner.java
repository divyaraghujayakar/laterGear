package com.latergear.test.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "",
        plugin = {
                "pretty",
                "html:results/cucumber-reports.html"
        },
        glue = "com.latergear.test"
)


public class TestRunner {
}
