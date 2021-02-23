package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./Features/"},
		glue={"stepDefinitions"},
		monochrome=true,
		plugin= {"pretty","html:test-output", "html:target/cucumber.html"},
		dryRun = false
		)
public class TestRun {

}

