package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utils.ScreenshotUtil;
import reporting.ExtentManager;

public class TestListener implements ITestListener {

	ExtentReports extent=ExtentManager.getInstance();
	ExtentTest test;
	private static final Logger log=LogManager.getLogger(TestListener.class);
	
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.error("Test failed: {}", result.getThrowable().getMessage());
		String testName=result.getMethod().getMethodName();
		String screenshotpath=ScreenshotUtil.captureScreenshot(testName);
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(screenshotpath);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
