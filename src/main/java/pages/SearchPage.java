package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import haatbhaar.ui_simple.BaseClass;

public class SearchPage {
	
	private WebDriver driver;
	
	@FindBy(id = "search-term")
	private WebElement inputSearchEnter;
	
	@FindBy(xpath = "//button[contains(@onclick,'searchUsers')]")
	private WebElement btnSearchClick;

	/*
	 * @FindBys({
	 * 
	 * @FindBy(xpath = "//ul/li") }) private List<WebElement> getSearchResult;
	 */
	//Replacing above code with below
	@FindBy(xpath = "//ul/li")
	private List<WebElement> getSearchResult;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void EnterTextToSearch(String toSearch) {
		inputSearchEnter.sendKeys(toSearch);
	}
	
	public void ClickAfterEnterText() {
		/*
		 * JavascriptExecutor je = (JavascriptExecutor) driver;
		 * je.executeScript("arguments[0].click();", btnSearchClick);
		 */
		btnSearchClick.click();
	}

	public List<WebElement> getResult() {	
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        try{
        	wait.until(ExpectedConditions.elementToBeClickable(getSearchResult));
		 * }catch(StaleElementReferenceException sere) {
		 * System.out.println("Wait time out"); }
		 */	
		return getSearchResult;
	}
	
	public String SearchBySingleUser() {
		String foundResult = "";
		if(!getSearchResult.isEmpty())
			return getSearchResult.get(0).getText();
		return foundResult;
	}

	public boolean IsExpectedResultAvailable(String expItem) {
		List<WebElement> results = getResult();
		for(WebElement ele: results ) {
			if(ele.getText().equalsIgnoreCase(expItem))
				return false;
		}
		return true;
	}
	
	
}
