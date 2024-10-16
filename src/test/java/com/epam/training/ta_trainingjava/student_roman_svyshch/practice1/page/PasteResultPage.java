package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class PasteResultPage {

    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    @FindBy(xpath = "//h1")
    WebElement pasteTitle ;

    @FindBy(xpath = "//ol[@class='bash']")
    WebElement codeBlock;

    public PasteResultPage(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

//    public PasteResultPage(WebDriverFactory driver, WebDriverWait wait) {
//        this.driver = driver;
//        this.wait = wait;
//    }


    public String getTitle(){
        return pasteTitle.getText();
    }
    public String getCodeText(){
     return codeBlock.getText();
    }
}
