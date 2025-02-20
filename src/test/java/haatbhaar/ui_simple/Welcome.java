package haatbhaar.ui_simple;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Welcome {
	@Test
	public void StartTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/utils/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
