package org.example.login;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.HomePage;
import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginFeatureSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;
    private LoginPage loginPage;
    private HomePage homePage;

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

    @Given("^User inputs username and password$")
    public void user_inputs_username_and_password(List<List<String>> credentials) throws Throwable {
       loginPage.inputUsername(credentials.get(1).get(0));
       loginPage.inputPassword(credentials.get(1).get(1));
    }

    @When("^User clicks Submit button$")
    public void user_clicks_Submit_button() throws Throwable {
        homePage = loginPage.clickSubmitButton();
    }

    @Then("^User is logged in$")
    public void user_is_logged_in() throws Throwable {
        homePage.waitForAdsAndClose();
    }

    @Then("^Error message is displayed$")
    public void error_message_is_displayed() throws Throwable {
        assertTrue(loginPage.isLoginErrorMessageDisplayed());
    }


}
