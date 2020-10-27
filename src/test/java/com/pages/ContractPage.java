package com.pages;


import com.github.javafaker.Faker;
import com.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractPage  {

   public ContractPage(){ PageFactory.initElements(Driver.getDriver(), this);}


WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

Actions actions =new Actions(Driver.getDriver());



    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]") //  (//li[@class='dropdown dropdown-level-1'])[1]
    public WebElement FleetButton;

    @FindBy(xpath = "//a[.='Vehicle Contracts']")
    public WebElement VehicleContractsButton;

    @FindBy(xpath = "//a[contains(@title,'Create Vehicle Contract')]")
    public WebElement CreateVehicleContractButton;

    @FindBy(name = "custom_entity_type[Responsible]")
    public WebElement ContractResponsibleButton;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement SaveAndCloseButton;

    @FindBy(xpath = "(//div[@class='control-label'])[2]")
    public WebElement SavedContractName;


    @FindBy(xpath = "//select[@name='custom_entity_type[Type]']")
    public WebElement ContractTypeDropDown;

    @FindBy(xpath = "//option[@value='leasing']")
    public WebElement ContractTypeLeasing;

    @FindBy(xpath = "//option[@value='omnium']")
    public WebElement ContractTypePersonalLoan;

    @FindBy(xpath = "//option[@value='credit_card']")
    public WebElement ContractTypeCreditCard;

    @FindBy(xpath = "//option[@value='cash']")
    public WebElement ContractTypeCash;


    @FindBy(xpath="//select[@name='custom_entity_type[RecurringCostAm]']")
    public WebElement recurringCostDropdown;

    @FindBy(xpath = "//option[@value='no']")
    public WebElement RecurringCostAmountNo;

    @FindBy(xpath = "//option[@value='daily']")
    public WebElement RecurringCostAmountDaily;

    @FindBy(xpath = "//option[@value='weekly']")
    public WebElement RecurringCostAmountWeekly;

    @FindBy(xpath = "//option[@value='monthly']")
    public WebElement RecurringCostAmountMonthly;

    @FindBy(xpath = "//option[@value='yearly']")
    public WebElement RecurringCostAmountYearly;

    @FindBy(xpath = "//a[contains(text (),'Cancel')]")
    public WebElement cancelContractButton;

    @FindBy(xpath="//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[2]/td[1]")
    public WebElement selectRowCell;

    @FindBy(xpath="//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[2]")
    public WebElement ClickSelectedRow;

    @FindBy(xpath = "//a[@title='Delete Vehicle Contract']")
    public WebElement deleteContractButton;

    @FindBy(xpath="//*[.='Yes, Delete']")
    public WebElement deleteContractConfirmationButton;


    @FindBy (xpath="//a[@title='Grid Settings']")
    public WebElement gridSettingsBtn;

    @FindBy (xpath="//table[@class='grid table-hover table table-bordered table-condensed']//tbody")
    public List<WebElement> gridSettingsFirstBtn;

    @FindBy (xpath="(//div[@class='dropdown'])[1]")
    public WebElement gridDropdown;

    @FindBy (xpath="(//a[@title='Delete'])[1]")
    public WebElement gridDeleteButton;

    @FindBy (xpath="//*[.='Yes, Delete']")
    public WebElement gridDeleteConfirmButton;




    public void fleet() {

        wait.until(ExpectedConditions.elementToBeClickable(FleetButton));
        actions.moveToElement(FleetButton).click().perform();

    }

    public void contract(){
        wait.until(ExpectedConditions.elementToBeClickable(VehicleContractsButton));
        actions.moveToElement(VehicleContractsButton).click().perform();

}

    public void createVehicleContract() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateVehicleContractButton));
        CreateVehicleContractButton.click();

    }
    public void contractResponsible(){
        Faker faker = new Faker();

        String name = faker.name().fullName();

        wait.until(ExpectedConditions.elementToBeClickable(ContractResponsibleButton));
        ContractResponsibleButton.sendKeys(name);

        contractType();

        contractCost();

        wait.until(ExpectedConditions.elementToBeClickable(SaveAndCloseButton));
        SaveAndCloseButton.click();

        wait.until(ExpectedConditions.visibilityOf(SavedContractName));
        String actualName = SavedContractName.getText();

        Assert.assertEquals(name, actualName);

    }


    public void contractType() {


        wait.until(ExpectedConditions.visibilityOf(ContractTypeLeasing));
        ContractTypeLeasing.click();

        wait.until(ExpectedConditions.visibilityOf(ContractTypePersonalLoan));
        ContractTypePersonalLoan.click();

        wait.until(ExpectedConditions.visibilityOf(ContractTypeCreditCard));
        ContractTypeCreditCard.click();

        wait.until(ExpectedConditions.visibilityOf(ContractTypeCash));
        ContractTypeCash.click();

        Select contractTypeDropDown = new Select(ContractTypeDropDown);

        List<WebElement> actualContractTypes = contractTypeDropDown.getOptions();

        List<String> expectedContractTypes = Arrays.asList("", "Leasing", "Personal Loan", "Credit Card", "Cash");

        List<String> actualContractTypeText = new ArrayList<>();

        for (WebElement each : actualContractTypes) {

            actualContractTypeText.add(each.getText());
        }

        Assert.assertEquals(actualContractTypeText, expectedContractTypes);

    }
    public void contractCost() {


        wait.until(ExpectedConditions.visibilityOf(RecurringCostAmountNo));
        RecurringCostAmountNo.click();

        wait.until(ExpectedConditions.visibilityOf(RecurringCostAmountDaily));
        RecurringCostAmountDaily.click();

        wait.until(ExpectedConditions.visibilityOf(RecurringCostAmountWeekly));
        RecurringCostAmountWeekly.click();

        wait.until(ExpectedConditions.visibilityOf(RecurringCostAmountMonthly));
        RecurringCostAmountMonthly.click();

        wait.until(ExpectedConditions.visibilityOf(RecurringCostAmountYearly));
        RecurringCostAmountYearly.click();


        Select recurringcostDropdown = new Select(recurringCostDropdown);

        List<WebElement> actualRecurringCost = recurringcostDropdown.getOptions();

        List<String> expectedRecurringCost = Arrays.asList("", "No", "Daily", "Weekly", "Monthly", "Yearly");

        List<String> actualRecurringCostText = new ArrayList();

        for (WebElement each : actualRecurringCost) {

            actualRecurringCostText.add(each.getText());

        }

        Assert.assertEquals(actualRecurringCostText, expectedRecurringCost);

    }





        public void contractCancel(){


//        wait.until(ExpectedConditions.elementToBeClickable(cancelContractButton));
//        cancelContractButton.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(selectRowCell));
//        selectRowCell.click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(ClickSelectedRow));
//        ClickSelectedRow.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteContractButton));
        deleteContractButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(deleteContractConfirmationButton));
        deleteContractConfirmationButton.click();

    }


//    public void gridSettings() {
//
//        wait.until(ExpectedConditions.elementToBeClickable(gridSettingsBtn));
//        gridSettingsBtn.click();
//
//        List<WebElement> gridSettingsList = gridSettingsFirstBtn;
//
//        for(WebElement each: gridSettingsList){
//
//            each.click();
//        }
//
//    }

}
