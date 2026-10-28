package com.site.automation.runners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.site.automation.stepdefinitions",
            "com.site.automation.hooks"},
    plugin = {"pretty", "html:reports/cucumber-report.html"},
    monochrome = true,
    tags = "@login"
)
public class TestRunner extends AbstractTestNGCucumberTests 
{
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() 
    {
        return super.scenarios();
    }
}

