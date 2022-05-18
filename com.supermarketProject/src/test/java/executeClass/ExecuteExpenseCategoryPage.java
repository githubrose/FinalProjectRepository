package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashBoardPage;
import elementRepository.ExpenseCategoryPage;
import elementRepository.LoginPage;

public class ExecuteExpenseCategoryPage extends BaseClass {
	LoginPage lp;
	DashBoardPage dp;
	ExpenseCategoryPage ecp ;

	@Test(priority = 0)
	public void verifyExpenseCategoryPageByURL() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		String expectedURL = "http://groceryapp.uniqassosiates.com/admin/expense-category";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);


	}
	@Test(priority = 1)
	public void isNewTitleCreatedOrNot() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		ecp = new ExpenseCategoryPage(driver);
		ecp.clickNewButton();
		ecp.enterTitle("Shampoo");
		ecp.clickSaveButton();
		Boolean actual = ecp.alertMessageForSuccessfulCreationDisplayedOrNot();
		Assert.assertTrue(actual);



	}
	@Test(priority = 2)
	public void isDuplicateTitleAllowedOrNot() throws InterruptedException{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		ecp = new ExpenseCategoryPage(driver);
		ecp.clickNewButton();
		ecp.enterTitle("Shampoo");
		ecp.clickSaveButton();
		Boolean actual = ecp.alertMessageForDuplicateTitleDisplayedOrNot();
		Assert.assertTrue(actual);

	}
	@Test(priority = 3)
	public void verifyTheSearchFunctionality()
	{

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		ecp = new ExpenseCategoryPage(driver);
		ecp.clickMainSearchButton();
		ecp.enterTheTitleToBeSearched("shampoo");
		ecp.clickSearchButton();
		String expectedSearchTitle = "shampoo";
		String actualSearchTitle = ecp.getTextFromTable();
		Assert.assertEquals(actualSearchTitle.toLowerCase(), expectedSearchTitle.toLowerCase());
	}

	@Test(priority = 4)
	public void verifyTheUpdateFuncionality()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		ecp = new ExpenseCategoryPage(driver);
		ecp.clickMainSearchButton();
		ecp.enterTheTitleToBeSearched("shampoo");
		ecp.clickSearchButton();
		ecp.explicitWaitElementToBeClickable();
		ecp.clickEditButton();
		ecp.updateValuetxt.clear();
		ecp.editTheValue("Natural Shampoo");
		ecp.clickUpdateButton();
		String expectedValue = "Natural Shampoo";
		String actualValue = ecp.getTextFromTable();
		Assert.assertEquals(actualValue, expectedValue);
	}
	@Test(priority = 5)
	public void verifyTheDeleteFuncionality()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		dp = new DashBoardPage(driver);
		dp.clickManageExpense();
		dp.clickManageExpenseList();
		ecp = new ExpenseCategoryPage(driver);
		ecp.clickMainSearchButton();
		ecp.enterTheTitleToBeSearched("Natural Shampoo");
		ecp.clickSearchButton();
		ecp.clickDeleteButton();
		ecp.explicitWaitAlertIsPresent();
		String expectedValue = "Natural Shampoo";
		String actualValue = ecp.getTextFromTable();
		Assert.assertNotEquals(actualValue, expectedValue);

	}

}
