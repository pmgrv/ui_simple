package haatbhaar.ui_simple;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;

public class AshotIntegration extends BaseClass{
	public static final Logger log = LogManager.getLogger(AshotIntegration.class);

	@Test(	description = "Attach Screnshot to extent report",
			groups = {"Regression", "Smoke"})
	public void DropThree() throws IOException {
		try {
			test = extent.createTest(this.getClass().getSimpleName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
			log.info("Log must be implemented");
			test.info("Welcome to my report with attached Screenshot");
			
			AShot ashot = new AShot(); 
			ru.yandex.qatools.ashot.Screenshot ss = ashot.takeScreenshot(driver);
			ImageIO.write(ss.getImage(), "PNG", new File(fullImagePath));
			test.info("Image getting attached");
			Assert.assertTrue(false);//Expected condition True but intentionally failed it to attach an screenshot
		}catch(AssertionError | Exception e){
			test.fail("When test case getting failed then only images should attached");
			//Attach screenshot report
			test.addScreenCaptureFromPath(fullImagePath);
			
		}
		QuitBrowser();
	}
	
	@Test(	description="Show pass and pass result",
			groups = {"Regression","Smoke"})
	public void DropPartial() {
		test = extent.createTest(this.getClass().getSimpleName() + "-" + Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("Image is generated at : {}", fullImagePath);
		test.info("Image is generated at : " + fullImagePath);
		System.out.println(fullImagePath);
		test.pass("Image is attached successfully!!!");
		QuitBrowser();
	}
	
}
