package MyRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Parameters;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;




@RunWith(Cucumber.class)

@CucumberOptions(features = ".\\src\\test\\java\\feature\\Login.feature",
glue = { "stepDef"},
	plugin = { "pretty","html:target/cucumber-reports//cucumber.html" },
	tags = "@signup",
	monochrome = true)



public class LoginRunner {

}
