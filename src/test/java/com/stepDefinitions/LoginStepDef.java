package com.stepDefinitions;

import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();

    @Given("User navigates to the login url")
    public void userNavigatesToTheLoginUrl() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }


    @Given("User enter {string} and {string} and clicks on the login button")
    public void userEnterAndAndClicksOnTheLoginButton(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("User should logout")
    public void userShouldLogout() throws InterruptedException{
        loginPage.logOut();
    }


}
