package Assignment4.Test;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Assignment4.POM.Homepage;
import Assignment4.POM.Loginpage;
import Assignment4.Testcomponent.BaseTest;

public class ksrtc extends BaseTest {
	Homepage home_page;
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void login_functionality() throws IOException {
		home_page = launchApplication();
		// launch application
		home_page.launch_url();
		// verify the phone number is matching with "080-26252626"
		String actual_phone_number = home_page.phone_number_verify();
		softAssert.assertEquals(actual_phone_number, "080-26252626");
		getScreenshot("testcase1");
		// click on sign-in
		Loginpage login_page = home_page.clicking_sign_in_button();
		// verify the current url is matching as expected
		softAssert.assertEquals(login_page.current_url(), "https://www.ksrtc.in/oprs-web/login/show.do");
		// login with the user name and password
		login_page.login_here("siva_shivzz", "Verizon@#$5");
		// if the user is not a registered user,then verify the url is matching as
		// expected
		softAssert.assertEquals(login_page.current_url(), "https://www.ksrtc.in/oprs-web/login/perform.do");
		getScreenshot("testcases2");
		String login_error_alert = login_page.error_Alert_Text();
		getScreenshot("testcases3");
		softAssert.assertEquals(login_error_alert, "Login incorrect. Please try again");
		// click on forgot password
		// enter the email
		login_page.forgot_password("siva.k15@wipro.com");
		// if the email id is not valid, then verify "Login Name not found in the
		// system." text is displayed
		String forgot_error_Alert = login_page.error_Alert_Text();
		getScreenshot("testcases4");
		softAssert.assertEquals(forgot_error_Alert, "Login Name not found in the system.");
		softAssert.assertAll();
	}
}
