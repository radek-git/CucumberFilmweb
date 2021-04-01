package org.example.want_to_see;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/wantToSee.feature"},
        monochrome = true,
        glue = {"org.example.want_to_see"})
public class WantToSeeTests {
}
