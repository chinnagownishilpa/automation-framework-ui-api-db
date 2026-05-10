package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReporter() {
		if(extent == null) {
			ExtentSparkReporter reporter=
					new ExtentSparkReporter("reports/extent_report.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	
	public static void flushReport() {

        if (extent != null) {

            extent.flush();
        }
    }

}
