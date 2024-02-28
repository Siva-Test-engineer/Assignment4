package Assignment4.Testcomponent;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import Assignment4.POM.Homepage;

public class BaseTest {
	public WebDriver driver;
	Homepage home_page;

	public WebDriver initializeDriver() throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public Homepage launchApplication() throws IOException {
		driver = initializeDriver();
		home_page = new Homepage(driver);
		return home_page;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	public void getScreenshot(String testcase) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//solution//"+testcase + ".png");
		FileUtils.copyFile(sourceFile, file);		
	}

}
