package org.example;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage extends PageWithAds {

    private static final String FILMWEB_ACCOUNT_LOGIN_BUTTON_XPATH = "//div[contains(@class, 'authButton--filmweb')]";
    private static final String USERNAME_INPUT_XPATH = "//input[@name='j_username']";
    private static final String PASSWORD_INPUT_XPATH = "//input[@name='j_password']";
    private static final String SUBMIT_BUTTON_XPATH = "//button[contains(@class, 'authButton--submit')]";
    private static final String RODO_DIV_XPATH = "//button[contains(@class, 'authButton--submit')]";
    private static final String RODO_CONFIRM_BUTTON_XPATH = "//div[@class='rodo__buttons']/button";
    private static final String LOGIN_ERROR_MESSAGE_XPATH = "//div[@class='authPage__description authPage__description--error' and contains(text(), 'błędny e-mail lub hasło')]";



    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void waitForRodoMessage() {
        try {
            waitForElementVisibility(RODO_CONFIRM_BUTTON_XPATH);
        } catch (Exception ignored) {

        }
    }

    public void clickRodoConfirmButton() {
//        List<WebElement> buttons = getDriver().findElements(By.xpath(RODO_CONFIRM_BUTTON_XPATH));
//        if (!buttons.isEmpty()) {
//            buttons.get(0).click();
//        }

        SeleniumUtils.performActionIfExists(getDriver(), RODO_CONFIRM_BUTTON_XPATH, button -> {
            button.click();
            return null;
        });
    }

    public void clickFilmwebAccountButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(FILMWEB_ACCOUNT_LOGIN_BUTTON_XPATH)));
        findElement(FILMWEB_ACCOUNT_LOGIN_BUTTON_XPATH).click();
    }

    public void inputUsername(String username) {
        findElement(USERNAME_INPUT_XPATH).sendKeys(username);
    }

    public void inputPassword(String password) {
        findElement(PASSWORD_INPUT_XPATH).sendKeys(password);
    }

    public boolean isLoginErrorMessageDisplayed() {
        List<WebElement> elements = getDriver().findElements(By.xpath(LOGIN_ERROR_MESSAGE_XPATH));
        return !elements.isEmpty();
    }

    public HomePage clickSubmitButton() {
        findElement(SUBMIT_BUTTON_XPATH).click();
        if (!isLoginErrorMessageDisplayed()) {
            return new HomePage(getDriver(), getWait(), getActions());
        }
        return null;
    }

}
