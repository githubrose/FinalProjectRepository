package executeClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import elementRepository.LoginPage;
import elementRepository.ManageUserPage;

public class ExecuteManageUserPage extends BaseClass {
	
	LoginPage lp;
	ManageUserPage mu;
	
	@Test(priority = 0)
	public void verifyManageUserPage() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		String expectedResult = "http://groceryapp.uniqassosiates.com/admin/list-user";
		String actualResult = mu.getTheURLOfManageUserPage();
		Assert.assertEquals(actualResult, expectedResult);

	}
	@Test(priority = 1)
	public void isSearchButtonOnManageUserPageEnabled() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		Boolean actualResult = mu.verifySearchButtonOnIsEnabledOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 2)
	public void verifyTheSearchFunctionality() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		String actualResult = mu.getSearchResult();
		String expectedResult = "test152";
		Assert.assertEquals(actualResult.toLowerCase(), expectedResult.toLowerCase());
	}
	@Test(priority = 3)
	public void isShowDetailsPushMenuArrowEnabled() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		Boolean actualResult = mu.showDetailButtonIsEnabledOrNot(); 
		Assert.assertTrue(actualResult);

	}
	@Test(priority = 4)
	public void isPasswordDisplayedOrNotAfterTheClickOnShowDetails() {

		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		mu.clickOnShowDetailPullDownArrow();
		Boolean actualResult = mu.passwordIsDisplayedOrNotAfterClockOnShowDetails();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 5)
	public void isUserStusActive(){
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		Boolean actualResult = mu.activeButtonEnabledOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 6)
	public void isStatusButtonUnlocked(){
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		Boolean actualResult = mu.verifyButtonIsUnlockOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 7)
	public void verifyAfterClickOnActiveButtonUserStatusChangedToInactive() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		mu.clickOnActiveStatusButton();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		String expectedStatus = "Inactive";
		String actualStatus = mu.getTheInactiveStatusText();
		Assert.assertEquals(actualStatus,expectedStatus);
	}
	@Test(priority = 8)
	public void isStatusButtonLocked(){
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		Boolean actualResult = mu.verifyButtonIslockedOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 9)
	public void isDeleteButtonDisplayed(){
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnSearchButton();
		mu.enterTextInSearchNameTextBox("test152");
		mu.clickSearchButton2();
		mu.scrollWindowToGetPassword();
		mu.explicitWaitElementToBeClickableOnShowDetailButton();
		Boolean actualResult = mu.deleteButtonIsDisplayedOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 10)
	public void isResetButtonEnabled() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		boolean actualResult = mu.resetButtonIsEnabledOrNot();
		Assert.assertTrue(actualResult);
	}
	@Test(priority = 11)
	public void isTheFirstPageOfTheUserListDisplayedAfterclickOnResetButton() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickONResetButton();
		mu.scrollWindowToTheFooter();
		Boolean actualResult = mu.firstPageOfUserListDisplayedOnClickOfResetButton();
		Assert.assertTrue(actualResult);

	}
	@Test(priority = 12)
	public void isFooterDisplayedOrNot() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickONResetButton();
		mu.scrollWindowToTheFooter();
		Boolean actualResult = mu.footerIsDisplayedOrNot();
		Assert.assertTrue(actualResult);

	}
	@Test(priority = 13)
	public void isLogOutButtonVisible() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnAdminLogo();
		Boolean actualResult = mu.logOutButtonDisplayedOrNot();
		Assert.assertTrue(actualResult);

	}
	@Test(priority = 14)
	public void verifySuccessfullyLoggedOut() {
		lp = new LoginPage(driver);
		lp.enterUserName("admin");
		lp.enterPassWord("admin");
		lp.clickRemeberMeCheckBox();
		lp.clickSignInBtn();
		mu = new ManageUserPage(driver);
		mu.clickOnManageUserLink();
		mu.clickOnAdminLogo();
		mu.clickOnLogOutButton();
		String expectedTitle = "Login | 7rmart supermarket";
		String actualTitle = mu.getTheTitleOfLoginPage();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

}
