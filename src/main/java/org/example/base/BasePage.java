package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends KlasaMatka {



    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        PageFactory.initElements(driver, wait);
    }

    public WebElement findElement(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    public void waitForElementVisibility(String xpath) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void sendKeys(WebElement webElement, String str) throws InterruptedException {
        for (int i = 0; i < str.length(); i++) {
            webElement.sendKeys(String.valueOf(str.toCharArray()[i]));
            Thread.sleep(50);
        }
    }







}

