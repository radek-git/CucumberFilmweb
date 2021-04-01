package org.example.favourites;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/favourites.feature"},
        monochrome = true,
        glue = {"org.example.favourites"})
public class FavouritesTests {
}
