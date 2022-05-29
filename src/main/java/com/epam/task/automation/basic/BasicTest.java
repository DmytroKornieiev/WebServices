package com.epam.task.automation.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicTest {
    protected WebDriver driver;

    @BeforeEach
    public void browserOpen(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver= new ChromeDriver();
        wait(5);
    }

    @AfterEach
    public void browserClose(){
        driver.quit();
    }

    public void wait(int second){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }

    public void getPage(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
