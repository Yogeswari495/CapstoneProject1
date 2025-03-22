package stepDef;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import Base.Base_class;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base_class {
    @After
    public void tearDown() {
        // Close browser after each scenario
        if (driver != null) {
            driver.quit();
            driver = null;  // Ensure cleanup between scenarios
        }
    }
}
