package org.example;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageWithAds extends BasePage {

    private WebDriverWait wait;

//    private static final String FULL_SCREEN_SKIP_AD_BUTTON_XPATH = "//button[@class='ws__skipButton']";
    private static final String FULL_SCREEN_SKIP_AD_BUTTON_XPATH = "//div[@class='ws__topBar']/button[contains(text(), 'Filmwebu')]";

    private static final String FULL_SCREEN_AD_DISPLAYED_XPATH = "//div[@class='ws__countdown']";
    private static final String TOP_LAYER_AD_DISPLAYED_XPATH = "//div[@class='faTopLayerScreening__content']/iframe";
    private static final String TOP_LAYER_AD_CLOSE_BUTTON_XPATH = "//div[@class='faTopLayerScreening__closeButton']";

    public PageWithAds(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        this.wait = new WebDriverWait(getDriver(), 1);
    }

    public void waitForAdsAndClose() {
        closeAd1();
        closeAd2();
    }

    public void closeAd1() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_LAYER_AD_CLOSE_BUTTON_XPATH)));
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            findElement(TOP_LAYER_AD_CLOSE_BUTTON_XPATH).click();
            getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception ignored) {

        }
    }


    public void closeAd2() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='ws__skipButton--inactive']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FULL_SCREEN_AD_DISPLAYED_XPATH)));
            getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            findElement(FULL_SCREEN_SKIP_AD_BUTTON_XPATH).click();
            getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        } catch (Exception ignored) {

        }
    }



}
