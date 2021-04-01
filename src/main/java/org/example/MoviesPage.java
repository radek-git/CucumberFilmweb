package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MoviesPage extends PageWithAds {

    private static final String MOVIE_POSTER_XPATH = "(//div[@class='simplePoster__poster'])";

    public MoviesPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public MoviePage clickMoviePosterOnIndex(int index) {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(MOVIE_POSTER_XPATH+ "[" + index + "]")));

        WebElement moviePoster = findElement(MOVIE_POSTER_XPATH + "[" + index + "]");

        moviePoster.click();

        try {
            Thread.sleep(500);
            moviePoster.click();

        } catch (StaleElementReferenceException ignored) {
            // ignore
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        getActions().doubleClick(moviePoster).build().perform();

//        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

//        getActions().moveToElement(moviePoster).sendKeys(Keys.ENTER).build().perform();
//        System.out.println("Enter naciśniety");

//        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        return new MoviePage(getDriver(), getWait(), getActions());
    }
}
