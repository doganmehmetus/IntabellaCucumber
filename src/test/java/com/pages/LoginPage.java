package com.pages;

import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);

    Actions actions =new Actions(Driver.getDriver());

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameinput;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordinput;

//    @FindBy(id="_submit")
//    public WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(xpath = "//i[@class='fa-caret-down']")
    public WebElement userDropdownbutton;

    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logOutButton;

    public void login(String username, String password){

        wait.until(ExpectedConditions.visibilityOf(usernameinput)).sendKeys(username);
        usernameinput.sendKeys(username+ Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOf(passwordinput)).sendKeys(password+Keys.ENTER);
        passwordinput.sendKeys(password+Keys.ENTER);

//        // 1st way we use SCENARIO OUTLINE: delete keywords and put new at the same time!
        usernameinput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), username);
        passwordinput.sendKeys(password, Keys.ENTER);

    }

    public void logOut() {


        wait.until(ExpectedConditions.visibilityOf(userDropdownbutton));
        userDropdownbutton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        actions.moveToElement(logOutButton).click().perform();
        Driver.closeDriver();

    }


}
