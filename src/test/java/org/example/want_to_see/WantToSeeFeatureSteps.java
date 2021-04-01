package org.example.want_to_see;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.LoginPage;
import org.example.MoviePage;
import org.example.UserPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class WantToSeeFeatureSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private MoviePage moviePage;
    private LoginPage loginPage;
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
        moviePage = new MoviePage(driver, wait, actions);
        loginPage = new LoginPage(driver, wait, actions);
        userPage = new UserPage(driver, wait, actions);
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

    @When("^User moves mouse to Want to see button$")
    public void user_moves_mouse_to_Want_to_see_button() throws Throwable {
        moviePage.moveMouseToWantSeeButton();
    }

    @When("^User wait for visibility Want to see eyes$")
    public void user_wait_for_visibility_Want_to_see_eyes() throws Throwable {
        moviePage.waitForAdsAndClose();
        moviePage.waitForWantToSeeEyes();
    }


    @When("^User clicks item index=(\\d+)$")
    public void user_clicks_item_index(int index) throws Throwable {
        moviePage.clickWantToSeeButtonAtIndex(index);
    }



    @When("^Message displayed on Want to see button is message=\"([^\"]*)\"$")
    public void message_displayed_on_Want_to_see_button_is_message(String message) throws Throwable {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        assertEquals(message, moviePage.getTextFromWantToSeeButton());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @When("^User clicks User page button$")
    public void user_clicks_User_page_button() throws Throwable {
        userPage = moviePage.clickUserButton();
    }

    @Then("^Number of Want to see movies is wantToSeeMovies=(\\d+)$")
    public void number_of_Want_to_see_movies_is_wantToSeeMovies(int wantToSeeMovies) throws Throwable {
        assertEquals(wantToSeeMovies, userPage.getNumberOfWantToSeeMovies());
    }


}
