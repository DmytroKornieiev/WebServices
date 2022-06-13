package com.epam.task.cucumber.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Optional;

import static org.openqa.selenium.chrome.ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY;

public class DriverManager {

    private final static String CHROME_DRIVER_PATH = "C:\\Users\\Dmytro_Kornieiev\\Desktop\\Course EPAM Middle\\Core\\src\\main\\resources\\chromedriver.exe";
    private final static int IMPLICITLY_WAIT_TIMEOUT = 5;
    private final static int WAIT_TIMEOUT_FOR_PAGE_LOAD = 20;
    private final static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setUpDriver() {
        System.setProperty(CHROME_DRIVER_EXE_PROPERTY, CHROME_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_TIMEOUT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WAIT_TIMEOUT_FOR_PAGE_LOAD));
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver(){
        Optional.ofNullable(getDriver()).ifPresent(webDriver ->{
            webDriver.quit();
            webDriverThreadLocal.remove();
        });
    }
}
