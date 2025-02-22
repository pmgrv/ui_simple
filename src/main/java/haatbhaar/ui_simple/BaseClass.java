package haatbhaar.ui_simple;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	protected static ExtentReports extent;
	private  static String userDir = System.getProperty("user.dir");
//	public static String fullImagePath = userDir + "/target/CaptureImage.png";
	protected static String fullImagePath = System.getProperty("user.dir") + "/target/currentPageScreenshot.png";
	private static String fullReportPath = userDir + "/target/" +"ExtentReport.html";
	protected static WebDriver driver;
	private String urlPath = "https://google.com";
	protected static Logger log;
	protected ExtentTest test;
	
	@BeforeSuite
	public void InitExtentReport() {
		//Initialize ExtentReports
		extent = new ExtentReports();
		
		//Initialize ExtentReports Spark: Image/File/Video
		ExtentSparkReporter report = new ExtentSparkReporter(fullReportPath);
		
		//AttachReport
		extent.attachReporter(report);
		
		//Add system information
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@BeforeClass
	public void InitDriver() {
		log = org.apache.logging.log4j.LogManager.getLogger();		
		test = extent.createTest("Wake up call!!!");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");

		log.info("Driver initilization started...");
//		driver = new ChromeDriver(options);
		test.info("Driver initilized...");
		
		driver = new ChromeDriver();
		log.info("Chrome is ready. Window maximization...");
		test.info("Chrome is ready. Window maximization...");
		
		driver.manage().window().maximize();
		log.info("Entering URL");
		test.info("Entering URL");
		
		driver.get(urlPath);
		log.info("Congratulation!!! Page loaded successfully.");
		test.info("Congratulation!!! Page loaded successfully.");
	}
	
	@AfterClass
	protected void QuitBrowser() {
		log.info("Driver getting closed successfully!!!");
		test.info("Driver getting closed successfully!!!");
		if( driver != null)	{
			driver.quit();
			log.info("Hurray!! Dirve quit successfully!! \n Congratulations, Test Executed Successfully!");
			test.info("Hurray!! Dirve quit successfully!! \n Congratulations, Test Executed Successfully!");
		}
		
	}
	
	@AfterSuite
	public void FlushExtentReport() {
		if(extent != null)	extent.flush();
	}
	
	
	
}
