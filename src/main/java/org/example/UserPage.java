package org.example;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserPage extends PageWithAds {
    
    private static final String TITLE_A_XPATH = "//div[@class='crs__container']/ul/li[@class='C']/div/div[@class='posterInfoBox__info ']/div/h3/a";
    private static final String NUMBER_OF_WANT_TO_SEE_MOVIES_XPATH = "(//span[@data-count-to-value])[2]";
    private static final String NUMBER_OF_STARS_XPATH = "//div[contains(@class, 'posterInfoBox') and ./div[@class='posterInfoBox__info ']/div/h3/a[@title='Eurovision Song Contest: Historia zespołu Fire Saga']]/div/div[contains(@class, 'RibbonFilm')]";
    private static final String POSTERS_XPATH = "//div[@class='filmPoster__link']";
    private static final String SEE_ALL_MOVIES_BUTTON_XPATH = "//div[@class='page__moreButton']/a";
//    private static final String NUMBER_OF_STARS_XPATH = "//div[@class='posterInfoBox__rateBox']/span[@class='posterInfoBox__rate']";

    public UserPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public List<String> getFavouriteMovieTitles() {
        List<WebElement> elements = getDriver().findElements(By.xpath(TITLE_A_XPATH));
        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

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


    public int getNumberOfWantToSeeMovies() {
        return Integer.parseInt(findElement(NUMBER_OF_WANT_TO_SEE_MOVIES_XPATH).getAttribute("data-count-to-value"));
    }

    public UserMovieRatingsPage clickSeeAllButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(SEE_ALL_MOVIES_BUTTON_XPATH)));
        findElement(SEE_ALL_MOVIES_BUTTON_XPATH).click();
        return new UserMovieRatingsPage(getDriver(), getWait(), getActions());
    }


}
