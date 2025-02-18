package haatbhaar.ui_simple;
import java.util.logging.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Welcome {
	private Logger log = Logger.getLogger(Welcome.class.getName());
	@Test
	public void StartTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/utils/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		log.info("First Success Test Case");
		driver.quit();
	}
}
