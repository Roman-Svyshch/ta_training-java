package com.epam.training.ta_trainingjava.student_roman_svyshch.practice1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPastePage {

    private final WebDriver driver ;
    @FindBy(id="postform-text")
    private WebElement textBox ;

    @FindBy(id = "select2-postform-expiration-container")
    private  WebElement dropdown;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement option;

    @FindBy(id = "postform-name")
    private WebElement postName;

    public NewPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterText(String text){
        textBox.sendKeys(text);
    }
    public void selectExpiration(){
        dropdown.click();
        option.click();
    }
    public void enterPostName(String postNameText){
        postName.sendKeys(postNameText);
    }
    public void openPage(){
        driver.get("https://pastebin.com/");
    }

}
