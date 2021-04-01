package org.example;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *
 * TODO: ustawic takie czasy czekania, ze gry reklama sie nie wyswietli to nie czeka za dlugo
 *
 */

public class HomePage extends PageWithAds {

    private static final String SKIP_AD_BUTTON_XPATH = "//button[@class='ws__skipButton']";
    private static final String AD_DISPLAYED_XPATH = "//div[@class='ws__countdown']";
    private static final String USER_HEADER_XPATH = "//div[@id='userHeader']";
    private static final String MOVIES_BUTTON_XPATH = "//ul[@class='list']/li[@id='filmwebMainMobile']/a[@id='filmsMainMenuLink']";


    public HomePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

//    public void waitForAdDisplayed() {
//        try {
//            waitForElementVisibility(AD_DISPLAYED_XPATH);
//        } catch (Exception ignored) {
//
//        }
//    }
//
//    public void waitForSkipButtonAndClick() {
//        try {
//            getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='ws__skipButton--inactive']")));
//            waitForElementVisibility(SKIP_AD_BUTTON_XPATH);
//            findElement(SKIP_AD_BUTTON_XPATH).click();
//        } catch (Exception ignored) {
//
//        }
//
//    }

    public boolean isHomePageDisplayed() {
        return SeleniumUtils.performActionIfExists(getDriver(), USER_HEADER_XPATH, webElement -> true) != null;
    }


    public MoviesPage clickOnMoviesButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(MOVIES_BUTTON_XPATH)));
        findElement(MOVIES_BUTTON_XPATH).click();
        return new MoviesPage(getDriver(), getWait(), getActions());
    }


    
}
