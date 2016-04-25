package pl.pragmatists.atm;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report"},
        glue = {"cucumber.api.spring", "cucumber.runtime.java.spring", "pl.pragmatists.atm"},
        strict = true,
        monochrome = true)
public class RunCukesTest {

}
