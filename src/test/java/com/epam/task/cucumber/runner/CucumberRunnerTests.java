package com.epam.task.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "",
        glue = "com/epam/task/cucumber",
        features = "src/test/resources/com.epam.task.cucumber/features")
public class CucumberRunnerTests {
}
