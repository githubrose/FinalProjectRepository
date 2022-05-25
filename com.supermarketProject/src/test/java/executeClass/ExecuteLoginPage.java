
package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class ExecuteLoginPage extends BaseClass {

	LoginPage lp ;
	DashBoardPage dp;

	@Test(priority = 0)
	public void verifyTheLoginPageLogo() {
		lp = new LoginPage(driver);
		String expectedLogo= "7rmart supermarket";
		String actualLogo = lp.getTheLoginPageLogo();
		Assert.assertEquals(actualLogo, expectedLogo);
	}

	@Test(priority = 1)
	public void isRememberMeCheckBoxSelected() {

		lp = new LoginPage(driver);
		Assert.assertFalse(lp.rememberMeSelectedorNot());
	}

	@Test(priority = 3)
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPage(driver);
		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassWord(lp.readPassWord(1, 1));
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		String expectedLogo = "7rmart supermarket";
		String actualLogo = dp.getTheLogo();
		Assert.assertEquals(actualLogo, expectedLogo);
	}
	@Test(priority=2,dataProvider="data-provider",dataProviderClass=DataProviderClass.class)
	public void verifyUnsuccessfulLogin(String uName,String password) {
		lp = new LoginPage(driver);
		lp.enterUserName(uName);
		lp.enterPassWord(password);
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		String expectedLogo = "7rmart supermarket";
		String actualLogo = dp.getTheLogo();
		Assert.assertEquals(actualLogo, expectedLogo);
		
	}

}
