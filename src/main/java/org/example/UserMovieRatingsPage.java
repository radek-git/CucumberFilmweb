package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserMovieRatingsPage extends PageWithAds {

    public UserMovieRatingsPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public int getRatingForMovie(String title) {
        String xpath = "//div[@class='myVoteBox__mainBox' and ./div/div/div[@class='filmPreview__card']/div[@class='filmPreview__header']/div/a/h2/text()[translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '" + title.toLowerCase() + "']]/div[contains(@class,'voteCommentBox')]/div[@class='voteCommentBox__container']/div[@class='voteCommentBox__userRate']/div/div/span";
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement rating = findElement(xpath);
        return Integer.parseInt(rating.getText());
    }
}
