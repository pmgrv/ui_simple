package pagesScripts;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import haatbhaar.ui_simple.BaseClass;
import pages.SearchPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class SearchProgram extends BaseClass {
	private SearchPage sp ;
	
	@Test(	description="Search a user in the List Functionality",
			groups= {"Regression","Smoke"})
	public void SearchUserInList() {
		test = extent.createTest(this.getClass().getSimpleName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
		test.info("Executing first test case");
		sp = new SearchPage(driver);
		boolean check = sp.IsExpectedResultAvailable(toOperate);
		Assert.assertEquals(check, true, "Result not found");
	}
	
	@Test( description="Search available user functionality",
			groups = {"Regression","Smoke"},
			dependsOnMethods  = "SearchUserInList")
	public void SearchAvailabeUser() throws IOException {
		test = extent.createTest(this.getClass().getSimpleName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
		test.info("Searching available user...");
		sp = new SearchPage(driver);
		sp.EnterTextToSearch(toOperate);
		sp.ClickAfterEnterText();	
		String toValidateResult = sp.SearchBySingleUser();
		try {
			Assert.assertEquals(toValidateResult, toOperate);
			test.pass("Assertion passed");
		}catch(AssertionError e){
			test.fail("Assertion failed:\t"+e.getMessage() );
			test.log(Status.FAIL, e);
			AShot ashot = new AShot(); 
			Screenshot ss = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(ss.getImage(), "PNG", new File(fullImagePath));
			test.fail("When test case getting failed then only images should attached");
			throw e;
		}finally {
			//Attach screenshot report
			test.addScreenCaptureFromPath(fullImagePath);
			extent.flush();
		}
	}
}
