package com.stepDefinitions;

import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
     Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("scenario = " + scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("End of scenario");
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        Driver.closeDriver();


    }
}
