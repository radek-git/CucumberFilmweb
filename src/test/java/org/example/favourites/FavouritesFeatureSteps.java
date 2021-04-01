package org.example.favourites;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.LoginPage;
import org.example.MoviePage;
import org.example.UserPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FavouritesFeatureSteps {


    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private LoginPage loginPage;
    private MoviePage moviePage;
    private UserPage userPage;



    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-US");
        driver = new ChromeDriver(chromeOptions);

        init();

        driver.get("https://www.filmweb.pl/login");
        loginPage = new LoginPage(driver, wait, actions);
    }

    public void init() {
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Given("^User waits for RODO message and clicks RODO confirm button$")
    public void user_waits_for_RODO_message_and_clicks_RODO_confirm_button() throws Throwable {
        loginPage.waitForRodoMessage();
        loginPage.clickRodoConfirmButton();
    }

    @Given("^User clicks Filmweb account login button$")
    public void user_clicks_Filmweb_account_login_button() throws Throwable {
        loginPage.clickFilmwebAccountButton();
    }

    @Given("^User loggs in using credentials$")
    public void user_loggs_in_using_credentials(List<List<String>> credentials) throws Throwable {
        loginPage.inputUsername(credentials.get(1).get(0));
        loginPage.inputPassword(credentials.get(1).get(1));
        loginPage.clickSubmitButton();
    }

    @When("^User moves to movie page$")
    public void user_moves_to_movie_page(List<String> movieUrls) throws Throwable {
        driver.get(movieUrls.get(1));
        moviePage = new MoviePage(driver, wait, actions);
    }

    @When("^User clicks favourite icon$")
    public void user_clicks_favourite_icon() throws Throwable {
        moviePage.waitForAdsAndClose();
        moviePage.clickFavouriteIcon();
    }

    @Then("^Movies are in favourites$")
    public void movies_are_in_favourites(List<String> movieTitles) throws Throwable {
        userPage = moviePage.clickUserButton();
        assertTrue(userPage.getFavouriteMovieTitles().containsAll(movieTitles.subList(1, movieTitles.size() - 1)));
    }
}
