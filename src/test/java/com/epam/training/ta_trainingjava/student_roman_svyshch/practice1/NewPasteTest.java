package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewPasteTest {
    WebDriver driver;
    NewPastePage pastePage;


    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        pastePage = new NewPastePage(driver);
    }

    @Test
    public void createNewPaste(){
        pastePage.openPage();
        pastePage.enterText("Hello from WebDriver");
        pastePage.selectExpiration();
        pastePage.enterPostName("hellowebPidor");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
