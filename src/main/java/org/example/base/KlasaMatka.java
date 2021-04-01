package org.example.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class KlasaMatka {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public KlasaMatka(WebDriver driver, WebDriverWait wait, Actions actions) {
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }


    public Actions getActions() {
        return actions;
    }

    public void waitUntilElementIsClickableAndClick(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement button = driver.findElement(By.xpath(xpath));
        button.click();
    }

    public void clickButton(String xpath) {
        WebElement button = getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void switchToIframe(String xpath) {
        WebElement iframe = getDriver().findElement(By.xpath(xpath));
        getDriver().switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    public boolean isButtonSelected(String buttonXpath, String attribute, String expectedValue) {
        WebElement button = getDriver().findElement(By.xpath(buttonXpath));
        return button.getAttribute(attribute).equals(expectedValue);
    }

    public void clickCtrlZ() {
        actions.keyDown(Keys.CONTROL).sendKeys("z").build().perform();
        actions.keyUp(Keys.CONTROL).build().perform();
    }


    public void clickCtrlC() {
        actions.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
        actions.keyUp(Keys.CONTROL).build().perform();
    }






}
