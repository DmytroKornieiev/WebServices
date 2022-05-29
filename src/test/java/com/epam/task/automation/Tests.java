package com.epam.task.automation;

import com.epam.task.automation.basic.BasicTest;
import com.epam.task.automation.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests extends BasicTest {

    LoginPage loginPage;

    @BeforeEach
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void positiveTest(){
        wait(15);
        getPage(loginPage.URL);
        maximizeWindow();
        loginPage.login();
        wait(10);
        assertEquals(loginPage.URL_AFTER_LOGIN,getUrl(),"fail- unable to login");
    }

    @Test
    public void negativeTest(){
        wait(15);
        getPage(loginPage.URL);
        maximizeWindow();
        loginPage.loginFailed();
        wait(10);
        assertEquals(loginPage.URL,getUrl(),"fail- wrong URL!");
    }

}
