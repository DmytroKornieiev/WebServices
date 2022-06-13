package com.epam.task.cucumber.pages;

import com.epam.task.cucumber.driver.DriverManager;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public final String URL = "https://www.saucedemo.com/";
    public final By USER_NAME_FIELD = By.xpath("//input[@id='user-name']");
    public final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    public final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");
    public final By ERROR_MESSAGE = By.cssSelector(".error-button");

    public void openHomePage(){
        DriverManager.getDriver().get(URL);
    }

    public void setLoginAndPassword(String login, String password){
        findElement(USER_NAME_FIELD).sendKeys(login);
        findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton(){
        findElement(LOGIN_BUTTON).click();
    }

    public String getPageUrl(){
        return DriverManager.getDriver().getCurrentUrl();
    }

    public String isUserNameFieldEmpty() {
        return findElement(USER_NAME_FIELD).getText();
    }

    public String isPasswordFieldEmpty() {
        return findElement(PASSWORD_FIELD).getText();
    }

    public boolean isErrorMessageDisplayed(){
        return findElement(ERROR_MESSAGE).isDisplayed();
    }
}
