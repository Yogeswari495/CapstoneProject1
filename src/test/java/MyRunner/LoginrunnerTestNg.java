package MyRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\feature\\Login.feature",
glue = { "stepDef"},
	plugin = { "pretty","html:target/cucumber-reports//cucumber.html" },
	tags = "@signup",
	monochrome = true)

public class LoginrunnerTestNg extends AbstractTestNGCucumberTests {

}
