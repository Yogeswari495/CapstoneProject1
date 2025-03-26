package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.AddToCart;
import Pages.Checkout;
import Pages.ConfirmOrder;
import Pages.LoginPageF;


public class CheckoutTestcase extends Base_class {
	 String url, email, password, coupon, giftCard, pincode, city, address, phoneNo;
	

	@BeforeTest
	public void readData() throws IOException {
		 
		FileInputStream fis = new FileInputStream("C:\\Users\\yoges\\eclipse-workspace\\Capstone1\\src\\test\\java\\utilities\\Data.Properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		coupon = prop.getProperty("coupon");
		giftCard = prop.getProperty("giftCard");
		pincode = prop.getProperty("pincode");
		city = prop.getProperty("city");
		address = prop.getProperty("address");
		phoneNo = prop.getProperty("phoneNo");
		
		ExtentReport.getInstance();

	}

	@Test
	//@Parameters({ "browser"} )
	public void checkOutTest() throws InterruptedException, IOException {
       // setup(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		LoginPageF lp = new LoginPageF(driver);
		lp.clickOnLoginPage();// clicking on login page link
		Thread.sleep(1000);
		lp.enterEmailId();// entering the email
		Thread.sleep(1000);
		lp.enterPwd();// entering the password
		Thread.sleep(1000);
		lp.clickOnRemCheckBox();// clicking on the checkbox
		Thread.sleep(1000);
		lp.clickOnLoginBtn();// By clicking on the login button it will navigate to loginpage
		Thread.sleep(1000);
		ExtentReport.createTest("login test").log(Status.INFO, "login succesfully completed");

		 AddToCart ac = new AddToCart(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the link to navigate to the Gift Card page
		wait.until(ExpectedConditions.elementToBeClickable(ac.link())).click();
		
		System.out.println("navigated to giftcard page");
		// Select sorting option "Name: A-Z"
		wait.until(ExpectedConditions.elementToBeClickable(ac.Positions())).sendKeys(Keys.ARROW_DOWN, "Name:A-Z",
				Keys.ENTER);
		Thread.sleep(3000);
		// Selecting display format as "List"
		wait.until(ExpectedConditions.elementToBeClickable(ac.Grid())).sendKeys(Keys.ARROW_DOWN, "List", Keys.ENTER);
		Thread.sleep(3000);
		// Selecting the number of items displayed per page
		wait.until(ExpectedConditions.elementToBeClickable(ac.view())).sendKeys(Keys.ARROW_DOWN, "4", Keys.ENTER);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(ac.Giftcard())).click();

		// entering the recipient details

		wait.until(ExpectedConditions.visibilityOf(ac.name())).sendKeys("Yogeswari");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(ac.email())).sendKeys("Yogeswari1234@gmail.com");
		Thread.sleep(5000);
		// Fill in sender details
		wait.until(ExpectedConditions.visibilityOf(ac.sendername())).sendKeys("Keerthi");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(ac.senderemail())).click();

		// Enter a personalized message
		wait.until(ExpectedConditions.visibilityOf(ac.Message())).sendKeys("All the best");
		Thread.sleep(2000);
		// Click on the "Add to Cart" button
		wait.until(ExpectedConditions.elementToBeClickable(ac.AdToCart())).click();

		Thread.sleep(2000);
		// add product to cart
	
		ExtentReport.createTest("Add giftcard test").log(Status.INFO, "giftcard  added successfully");

		// checkout
		Checkout c = new Checkout(driver);
		ExtentReport.createTest("checkout details").log(Status.INFO, "entered checkout details");
		c.clickOnCart();
		Thread.sleep(1000);
		c.enterCoupon(coupon);
		Thread.sleep(1000);
		c.clickOnCoupon();
		Thread.sleep(1000);
		c.enterGiftCode(giftCard);
		c.clickOnGiftCard();
		Thread.sleep(1000);
		c.clickOnTerms();
		Thread.sleep(1000);
		c.clickOnCheckOut();
		Thread.sleep(3000);
		ExtentReport.createTest("checkout test").log(Status.PASS, "Successfully Clicked On Checkout");

		ConfirmOrder cp = new ConfirmOrder(driver);
		ExtentReport.createTest("confirm order details").log(Status.INFO,"shipping address and billing are in process");

		cp.selectBillAddress();
		cp.selectCountry();
		cp.enterCity(city);
		cp.enterAddress(address);
		cp.enterPincode(pincode);
		cp.enterPhoneNum(phoneNo);
		cp.clickOnAddressContinue();
		cp.clickOnCOD();
		Thread.sleep(2000);
		cp.clickOnPaymentContinue();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		cp.clickOnPaymentInfo();
		cp.clickOnConfirmOrder();
		try {
			if (cp.getMsgTitle().isDisplayed()) {
				String msg = cp.getMsgTitle().getText();
				System.out.println("successfully orderd: " + msg);
				String orderNo = cp.getOrderNum().getText();
				System.out.println("order number : " + orderNo);
				screenshot();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		cp.clickOnOrderDetails();
		cp.getOrderPdf();
		screenshot();
		ExtentReport.createTest("confirm order test").log(Status.PASS, "order confirm is successfully completed");

	}

}
