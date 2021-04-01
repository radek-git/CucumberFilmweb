package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;

public class SeleniumUtils {

    private SeleniumUtils() {}

    public static <T> T performActionIfExists(WebDriver driver, String xpath, Function<WebElement, T> function) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        if (!elements.isEmpty()) {
            return function.apply(elements.get(0));
        } else {
            return null;
        }
    }

}
