package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	private static ExtentReports extent;// static instance of Extent Report ensuring only one instantance is  created
	private static ExtentTest test;//To log test steps and Results

	public static ExtentReports getInstance() {
		if (extent == null) {//check if extent is already intialized
			extent = createInstance(); //creates new instance if the extent is null
		}
		return extent;
	}

	private static ExtentReports createInstance() {
		//to specify the output report file name
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("tricienties.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		return extent;//returns the extentReports instance
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}
}
