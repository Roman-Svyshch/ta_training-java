package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewPastePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id="postform-text")
    private WebElement textBox;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement dropdown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement option;

    @FindBy(id = "select2-postform-format-container")
    private WebElement highLighting;

    @FindBy(xpath = "//li[contains(text(), 'Bash')]")
    private WebElement spanElement;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement savePasteButton;

    @FindBy(id = "postform-name")
    private WebElement postName;


    public NewPastePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text){
        textBox.sendKeys(text);
    }

    public void selectBashExpiration(){
        dropdown.click();
        option.click();
    }

    public void selectHighlight(){
        highLighting.click();
        spanElement.click();
    }

    public void enterPostName(String postNameText){
        postName.sendKeys(postNameText);
    }

    public void savePaste(){
        savePasteButton.click();
    }

    public void openPage(){
        driver.get("https://pastebin.com/");
    }
}
