package haatbhaar.ui_simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogChecker {
	public static final Logger log =  LogManager.getLogger();
	@Test
	public void DropOne(){
		String url = "https:\\google.com";
		System.setProperty("webdriver.chrome.driver.", "src/main/utils/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		log.info("First Log: WebDriver Initialized!!!");
		driver.get(url);
		log.info("Hit url: {} successfully", url);
		log.info("Expected title {} ", driver.getTitle());
		driver.quit();
		log.info("Driver left job!!");
	}
}
