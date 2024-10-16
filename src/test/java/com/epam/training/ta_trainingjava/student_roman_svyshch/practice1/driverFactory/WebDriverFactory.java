package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.driverFactory;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver driver;
    @BeforeClass
    public static void initDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pastebin.com/");
    }
    public static WebDriver getDriver() {
        if (driver == null){
            initDriver();
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
