 
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	//import org.openqa.selenium.firefox.FirefoxDriver;

	public class Sample{
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver =new ChromeDriver();
			driver.get("https://www.amazon.com");
		     driver.getCurrentUrl();
		     driver.quit();
}
}
