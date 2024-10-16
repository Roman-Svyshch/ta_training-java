package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.test;

import com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.driverFactory.WebDriverFactory;
import com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.page.NewPastePage;
import com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.page.PasteResultPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewPasteTest {

    private NewPastePage pastePage;

    @BeforeEach
    void setUp() {

        WebDriverFactory.initDriver();
        pastePage = new NewPastePage(WebDriverFactory.getDriver());
    }

    @Test
    public void createNewPaste() {
        pastePage.openPage();
        pastePage.enterText("Hello from WebDriver");
        pastePage.selectBashExpiration();
        pastePage.enterPostName("hellowebPidor");
        pastePage.savePaste();
    }

    @Test
    public void createAndVerifyNewPaste() throws InterruptedException {
        String expectedCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String expectedTitle = "how to gain dominance among developers";

        pastePage.openPage();
        pastePage.enterText(expectedCode);
        pastePage.selectBashExpiration();
        pastePage.selectHighlight();
        pastePage.enterPostName(expectedTitle);
        pastePage.savePaste();


        Wait<WebDriver> wait = new FluentWait<>(WebDriverFactory.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement pasteTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        WebElement codeBlockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@class='bash']")));

        PasteResultPage resultPage = new PasteResultPage(WebDriverFactory.getDriver(), wait);
         String actualTitle = resultPage.getTitle();
         String actualCode = resultPage.getCodeText();


         assertEquals(expectedTitle, actualTitle);
         assertEquals(expectedCode, actualCode);
    }

//    @AfterEach
//    void tearDown() {
//        WebDriverFactory.closeDriver();
//    }
}
