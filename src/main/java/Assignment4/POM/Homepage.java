package Assignment4.POM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath = "//ul[@class='col-md-3 fl-left']//a")
	WebElement phone_number_webElement;
	@FindBy(xpath = "//ul[@class='fl-right p-1']//li[1]")
	WebElement sign_in_button_webElement;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launch_url() throws IOException {
		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(
				"C:\\Users\\USER\\eclipse-workspace\\Assignment4\\src\\main\\java\\Assignment4\\properties\\Config.properties");
		prop.load(fi);
		String urlString = prop.getProperty("url");
		driver.get(urlString);
	}

	public String phone_number_verify() {
		return phone_number_webElement.getText();
	}

	public Loginpage clicking_sign_in_button() {
		sign_in_button_webElement.click();
		Loginpage login_page = new Loginpage(driver);
		return login_page;

	}

}