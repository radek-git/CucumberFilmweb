package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviePage extends PageWithAds {

    private static final String FAVOURITE_ICON_XPATH = "//div[@class='filmRatingBox__favRate']/div/div/a";
    private static final String USER_HEADER_BUTTON_XPATH = "//div[@id='userHeaderButton']";
//    private static final String WANT_SEE_BUTTON_XPATH = "//div[@class='wantToSeeStateButton__container']";
    private static final String WANT_SEE_BUTTON_XPATH = "//div[@class='filmRatingBox__container']/div[@class='filmRatingBox__mainCard']/div[@class= 'filmRatingBox__wtsPart']/div[contains(@class, 'tooltip__parent')]/div[@class='wantToSeeStateButton__container']";
//    private static final String WANT_TO_SEE_EYES_GRADATION_DIV_XPATH = "//div[contains(@class, 'isPanelReady')]";
//    private static final String WANT_TO_SEE_EYES_GRADATION_DIV_XPATH = "//div[contains(@class, 'isHover')]";
    private static final String WANT_TO_SEE_EYES_GRADATION_DIV_XPATH = "//div[@class='filmRatingBox__mainCard']/div[@class='filmRatingBox__wtsPart']/div[contains(@class, 'isHover')]";
    private static final String WANT_TO_SEE_BUTTON_MESSAGE_XPATH = "//div[@class='wantToSeeStateButton__state']/span[@class='wantToSeeStateButton__desc']";
//    private static final String WANT_TO_SEE_BUTTON_MESSAGE_XPATH = "//div[contains(@class, 'WantToSeeStateButton') and @data-value!=0]";
    private static final String RATING_DIV_XPATH = "(//div[@class='filmRatingBox__starRate']/div/div[@class='iconicRate__container']/a)";
    private static final String MOVIE_TITLE_XPATH = "//h1[@class='filmCoverSection__title text--uppercase ']/a";

    public MoviePage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }



    public void clickFavouriteIcon() {
        findElement(FAVOURITE_ICON_XPATH).click();
    }

    public UserPage clickUserButton() {
        findElement(USER_HEADER_BUTTON_XPATH).click();
        return new UserPage(getDriver(), getWait(), getActions());
    }

    public void moveMouseToWantSeeButton() {
        waitForElementVisibility(WANT_SEE_BUTTON_XPATH);
        getActions().moveToElement(findElement(WANT_SEE_BUTTON_XPATH)).build().perform();
    }

    public void waitForWantToSeeEyes() {
        waitForAdsAndClose();
        waitForElementVisibility(WANT_TO_SEE_EYES_GRADATION_DIV_XPATH);
    }

    public void clickWantToSeeButtonAtIndex(int index) {
        findElement("//div[@class='wantToSeeStateButton__areas']/div[@data-index='" + index + "']").click();
    }

    public String getTextFromWantToSeeButton() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WANT_TO_SEE_BUTTON_MESSAGE_XPATH)));
        return findElement(WANT_TO_SEE_BUTTON_MESSAGE_XPATH).getText();
    }

    public void clickStarOnIndex(int index) {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(RATING_DIV_XPATH)));
        findElement(RATING_DIV_XPATH + "[" + index + "]").click();
    }

    public String getTitle() {
        return findElement(MOVIE_TITLE_XPATH).getText();
    }

    
}
