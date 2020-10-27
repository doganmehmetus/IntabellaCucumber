package com.stepDefinitions;

import com.pages.ContractPage;
import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContractStepDef {

    ContractPage ContractPage = new ContractPage();
    LoginPage loginPage = new LoginPage();

    @Given("User enters {string} and {string} and clicks on the login button")
    public void userEntersAndAndClicksOnTheLoginButton(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        loginPage.login(username, password);
    }


    @Given("User clicks on the fleet module")
    public void userClicksOnTheFleetModule() {
        ContractPage.fleet();
    }

    @And("User clicks on the contract page")
    public void userClicksOnTheContractPage() {
        ContractPage.contract();
    }

    @And("User clicks on create vehicle contract page")
    public void userClicksOnCreateVehicleContractPage() {
        ContractPage.createVehicleContract();
    }

    @And("User enters info for contract and verifies")
    public void userEntersInfoForContractAndVerifies() {
        ContractPage.contractResponsible();
    }


    @Then("User cancels the contract")
    public void userCancelsTheContract() {
        ContractPage.contractCancel();
    }


//    @And("User checks if grid settings are functional")
//    public void userChecksIfGridSettingsAreFunctional() {
//        ContractPage.gridSettings();
//
//    }

    @Then("User logs out")
    public void userLogsOut() {
        loginPage.logOut();
    }




}

