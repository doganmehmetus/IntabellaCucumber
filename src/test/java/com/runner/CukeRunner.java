package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

    plugin={"html:target/cucumber-report.html",
        "json:target/cucumber.json",
         "rerun:target/rerun.txt"},
    features="src/test/resources/features",
    glue="com/stepDefinitions",
    dryRun=false,
    tags = "@smoke_test"

)

public class CukeRunner {

}
