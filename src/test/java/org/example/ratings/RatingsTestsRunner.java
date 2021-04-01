package org.example.ratings;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/ratings.feature"},
        monochrome = true,
        glue = {"org.example.ratings"})
public class RatingsTestsRunner {
}

