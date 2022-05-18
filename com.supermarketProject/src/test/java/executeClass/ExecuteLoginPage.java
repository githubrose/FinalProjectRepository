
package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import elementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass {

	LoginPage lp ;

	@Test(priority = 0)
	public void verifyTheLoginPageWithURL() {
		String expectedURL = "http://groceryapp.uniqassosiates.com/admin/login";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}

	@Test(priority = 1)
	public void isRememberMeCheckBoxSelected() {

		lp = new LoginPage(driver);
		Assert.assertFalse(lp.rememberMeSelectedorNot());
	}

	@Test(priority = 2)
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassWord(lp.readPassWord(1, 1));
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		String expectedTitle = "Dashboard | 7rmart supermarket";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
