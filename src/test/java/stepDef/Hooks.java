package stepDef;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import Base.Base_class;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base_class {

//    @Before
//    public void setup() {
//        // Initialize WebDriver once in @Before
//        if (driver == null) {
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        }
    

    @After
    public void tearDown() {
        // Close browser after each scenario
        if (driver != null) {
            driver.quit();
            driver = null;  // Ensure cleanup between scenarios
        }
    }
}
