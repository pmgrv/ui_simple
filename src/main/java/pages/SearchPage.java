package pages;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import haatbhaar.ui_simple.BaseClass;

public class SearchPage {
	
	private WebDriver driver;
	
	@FindBy(id = "APjFqb")
	private WebElement inputSearchEnter;
	
	@FindBy(name = "btnK")
	private WebElement btnSearchClick;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterTextToSearch(String toSearch) {
		inputSearchEnter.sendKeys(toSearch);
	}
	
	public void ClickAfterEnterText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
        try{
        	wait.until(ExpectedConditions.elementToBeClickable(btnSearchClick));
        	btnSearchClick.click();
        }catch(StaleElementReferenceException sere) {
        	System.out.println("Wait time out");
        }
	}
}
