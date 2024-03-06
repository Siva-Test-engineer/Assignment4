package Assignment4.POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;

	@FindBy(xpath = "//ul[@class='fl-right p-1']//li[1]")
	WebElement sign_in_button_webElement;

	@FindBy(xpath = "//input[@name='userName']")
	WebElement username_WebElement;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordWebElement;

	@FindBy(xpath = "//input[@name='submitBtn']")
	WebElement login_button_WebElement;

	@FindBy(xpath = "//a[text()='Forgot Password']")
	WebElement forgot_passwordWebElement;

	@FindBy(xpath = "//div[@class='alert alert-warning']//strong")
	WebElement login_errorWebElement;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String current_url() {
		return driver.getCurrentUrl();
	}

	// login with the user name and password
	public void login_here(String username, String password) {
		username_WebElement.sendKeys(username);
		passwordWebElement.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.querySelector('#bookingsForm > div > div > div > div.custom-control.custom-checkbox.mb-3.text-center > label',':before').click();");
		login_button_WebElement.click();
	}

	public String error_Alert_Text() {
		return login_errorWebElement.getText();
	}
	public void actionnnns() {
	
	}

	public String forgot_password(String username) {
		forgot_passwordWebElement.click();
		username_WebElement.sendKeys(username);
		login_button_WebElement.click();
		return login_errorWebElement.getText();
	}
}
