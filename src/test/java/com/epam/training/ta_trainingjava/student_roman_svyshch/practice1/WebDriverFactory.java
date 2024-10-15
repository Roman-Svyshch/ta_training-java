package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver createWebDriver(){
        return new ChromeDriver();
    }
}
