package pagesScripts;

import org.testng.annotations.Test;

import haatbhaar.ui_simple.BaseClass;
import pages.SearchPage;

public class SearchProgram extends BaseClass {
	private SearchPage sp ;
	
	@Test(	description="Search Functionality",
			groups= {"Regression","Smoke"})
	public void SearchText() {
		sp = new SearchPage(driver);
		sp.EnterTextToSearch("Testing");
		sp.ClickAfterEnterText();
	}
}
