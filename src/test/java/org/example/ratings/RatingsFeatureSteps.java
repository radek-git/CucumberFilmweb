package org.example.ratings;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.PendingException;
import org.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class RatingsFeatureSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private LoginPage loginPage;
    private HomePage homePage;
    private MoviesPage moviesPage;
    private MoviePage moviePage;
    private String movieTitle;
    private UserPage userPage;
    private UserMovieRatingsPage userMovieRatingsPage;

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        chromeOptions.addArguments("load-extension=" + "E:\\IdeaProjects\\CucumberFilmweb\\extensions\\3.8.4_0");
//        chromeOptions.addArguments("load-extension=" + "E:\\IdeaProjects\\CucumberFilmweb\\extensions\\4.14.0_0");
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

    @Given("^User loggs in using username=\"([^\"]*)\" and password=\"([^\"]*)\"$")
    public void user_loggs_in_using_username_and_password(String username, String password) throws Throwable {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        homePage = loginPage.clickSubmitButton();
    }

    @When("^User clicks on Films button$")
    public void user_clicks_on_Films_button() throws Throwable {
         moviesPage = homePage.clickOnMoviesButton();
    }

    @When("^User selects (\\d+) movie$")
    public void user_selects_movie(int index) throws Throwable {
        moviePage = moviesPage.clickMoviePosterOnIndex(index);
    }

    @When("^User ranks star (\\d+)$")
    public void user_ranks_star(int index) throws Throwable {
        moviePage.clickStarOnIndex(index);
        movieTitle = moviePage.getTitle();
    }

    @When("^User clicks User button$")
    public void user_clicks_User_button() throws Throwable {
        userPage = moviePage.clickUserButton();
    }

    @Then("^Movie has rating (\\d+)$")
    public void movie_has_rating(int stars) throws Throwable {
        userMovieRatingsPage = userPage.clickSeeAllButton();
        assertEquals(stars, userMovieRatingsPage.getRatingForMovie(movieTitle));
    }


}
