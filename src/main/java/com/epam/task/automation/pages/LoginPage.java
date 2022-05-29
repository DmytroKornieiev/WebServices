package com.epam.task.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String URL = "https://www.saucedemo.com/";
    public final String URL_AFTER_LOGIN = "https://www.saucedemo.com/inventory.html";
    public final String USER_NAME = "standard_user";
    public final String PASSWORD = "secret_sauce";
    public final String WRONG_PASSWORD = "secret";
    public final By USER_NAME_FIELD = By.xpath("//input[@id='user-name']");
    public final By PASSWORD_FIELD = By.xpath("//input[@id='password']");
    public final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");

    public void login(){
        driver.findElement(USER_NAME_FIELD).sendKeys(USER_NAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginFailed(){
        driver.findElement(USER_NAME_FIELD).sendKeys(USER_NAME);
        driver.findElement(PASSWORD_FIELD).sendKeys(WRONG_PASSWORD);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
