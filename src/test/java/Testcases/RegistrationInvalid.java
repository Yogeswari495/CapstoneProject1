package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.Base_class;
import Base.ExtentReport;
import Pages.RegisterPage;
import utilities.Excel;

public class RegistrationInvalid extends Base_class {
	RegisterPage rp;

	@Test
	public void RegisterInvalid() throws IOException, InterruptedException {
		String url = Excel.getData(1, 0);
		// String gender =Excel.getData(1,1);
		String firstname = Excel.getData(1, 2);
		String lastname = Excel.getData(1, 3);
		String email = Excel.getData(1, 4);
		String password = Excel.getData(1, 5);
		String confirmPassword = Excel.getData(1, 6);
		driver.get(url);
		RegisterPage rp = new RegisterPage(driver);
		// clicking on Register
		rp.Register();
		rp.Gender().click();
		rp.FirstName().sendKeys(firstname);
		rp.LastName().sendKeys(lastname);
		rp.email().sendKeys(email);
		rp.Password().sendKeys(password);
        rp.cPassword().sendKeys(confirmPassword);
        rp.Registerbutton();
		screenshot();
		ExtentReport.createTest("RegisterInvalid").log(Status.PASS, "login Success for invalid data");

	}
}
