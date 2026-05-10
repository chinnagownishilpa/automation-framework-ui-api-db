package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import Utils.ScreenshotUtil;
import reporting.ExtentManager;

public class TestListener
        implements ITestListener {

    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        ExtentManager.getReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {

        test =
                ExtentManager.getReporter()
                .createTest(result.getName());

        System.out.println(
                "STARTED: "
                + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        System.out.println(
                "PASSED: "
                + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        System.out.println(
                "FAILED: "
                + result.getName());

        try {

            String screenshotPath =
                    ScreenshotUtil.captureScreenshot(
                            result.getName());

            test.addScreenCaptureFromPath(
                    screenshotPath);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip(
                "Retried/Skipped: "
                + result.getName());

        System.out.println(
                "SKIPPED: "
                + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.flushReport();

        System.out.println(
                "REPORT GENERATED");
    }
}