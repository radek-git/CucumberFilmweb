package org.example.login;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/login.feature"},
        monochrome = true,
        glue = {"org.example.login"})
public class LoginTests {
}
