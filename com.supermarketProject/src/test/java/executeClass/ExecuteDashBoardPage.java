package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;

public class ExecuteDashBoardPage extends BaseClass {
	DashBoardPage dp;
	LoginPage lp;
	
	@Test(priority = 0)
	public void verifyTheUserID() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		String expectedUser = "Admin";
		String actualUser = dp.getTheUseID();
		Assert.assertEquals(actualUser,expectedUser);
	}
	@Test(priority = 1)
	public void isPushMenuEnabled()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		boolean actualResult = dp.checkPushMenuIsEnabledOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 2)
	public void isLeftMenuVisibleAfterClickOnPushMenu() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickOnPushMenu();
		boolean actualResult = dp.checkLeftMenuVisibleOrNot();
		Assert.assertFalse(actualResult);

	}
	@Test(priority = 3)
	public void isListUnderManageExpenseVisible()  {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickOnPushMenu();
		dp.clickOnPushMenu();
		dp.clickManageExpense();
		boolean actualResult = dp.checkListUnderManageExpenseVisibleOrNot();
		Assert.assertTrue(actualResult);

	}
	@Test(priority = 4)
	public void verifyLabelExpenseCategoryAfterClickOnExpenseCategory() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickOnPushMenu();
		dp.clickOnPushMenu();
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		String expectedLabel = "Expense Category";
		String actualLabel = dp.getTextFromExpenseCatagoryLabel();
		Assert.assertEquals(actualLabel, expectedLabel);
	}
	@Test(priority = 5)
	public void verifyHomeLinkRedirectsToHomePage() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickOnPushMenu();
		dp.clickOnPushMenu();
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		dp.clickHomeLink();
		String expectedURL = "http://groceryapp.uniqassosiates.com/admin/home";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL,expectedURL);
	}


}


