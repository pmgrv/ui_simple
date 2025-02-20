package haatbhaar.ui_simple;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WriteContentOnHtmlReport extends BaseClass {
	public static final Logger log = LogManager.getLogger(WriteContentOnHtmlReport.class);
	@Test(	description = "Steps to be printed",
			groups = { "Regression", "Smoke"})
	public void DropTwo() {
		test = extent.createTest(this.getClass().getSimpleName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
		test.info("Welcome to my report");
		log.info("Log must be implemented");
		QuitBrowser();
	}
}
