package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ManageUserPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();

	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageUserLink;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement listUserLabel;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement searchName;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchButton2;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement searchResult;
	@FindBy(xpath = "//i[@class='fa fa-angle-double-down']")
	WebElement showDetailButton;
	@FindBy(className = "profile-info-name")
	WebElement password;
	@FindBy(xpath = "//span[text()='Active']")
	WebElement activeButton;
	@FindBy(xpath = "//i[@class='fa fa-unlock']")
	WebElement unlockButton;
	@FindBy(xpath = "//span[text()='Inactive']")
	WebElement inActiveButton;
	@FindBy(xpath = "//i[@class='fa fa-lock']")
	WebElement lockButton;
	@FindBy(xpath = "//i[@class = 'fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath = "//*[text()=' Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//footer[@class='main-footer text-sm']")
	WebElement footer;
	@FindBy(xpath = "(//a[@class='page-link'])[1]")
	WebElement firstPage;
	@FindBy(xpath = "//img[@class='img-circle']")
	WebElement adminLogo;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logOutButton;
	
	


	public ManageUserPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnManageUserLink() {
		gu.clickAction(manageUserLink);
	}
	public String getTheLabelOfManageUserPage() {
		return gu.getTextFromTheElement(listUserLabel);
	}
	public boolean verifySearchButtonOnIsEnabledOrNot() {
		return gu.elementIsEnabled(searchButton);
	}
	public void clickOnSearchButton() {
		gu.clickAction(searchButton);
	}
	public void enterTextInSearchNameTextBox(String text) {
		gu.enterTextBoxValue(searchName, text);
	}
	public void clickSearchButton2() {
		gu.clickAction(searchButton2);
	}
	public String getSearchResult() {
		return gu.getTextFromTheElement(searchResult);
	}
	public boolean showDetailButtonIsEnabledOrNot() {
		return gu.elementIsEnabled(showDetailButton);
	}
	public void explicitWaitElementToBeClickableOnShowDetailButton() {
		wait.elementToBeClickable(driver, showDetailButton);
	}
	public void clickOnShowDetailPullDownArrow() {
		gu.clickAction(showDetailButton);
	}
	public boolean passwordIsDisplayedOrNotAfterClockOnShowDetails() {
		return gu.elementIsVisible(password);
	}
	public void scrollWindowToGetPassword() {
		gu.scrollWindowToTheElement(driver, showDetailButton);
	}
	public boolean activeButtonEnabledOrNot() {
		return gu.elementIsEnabled(activeButton);
	}
	public void clickOnActiveStatusButton() {
		gu.clickAction(activeButton);
	}

	public String getTheInactiveStatusText() {
		return gu.getTextFromTheElement(inActiveButton);
	}
	public boolean verifyButtonIsUnlockOrNot() {
		return gu.elementIsVisible(unlockButton);
	}
	public boolean verifyButtonIslockedOrNot() {
		return gu.elementIsVisible(lockButton);
	}
	public boolean deleteButtonIsDisplayedOrNot() {
		return gu.elementIsVisible(deleteButton);
	}
	public boolean resetButtonIsEnabledOrNot() {
		return gu.elementIsEnabled(resetButton);
	}
	public void clickONResetButton() {
		gu.clickAction(resetButton);
	}
	public void scrollWindowToTheFooter() {
		gu.scrollWindowToTheElement(driver, footer);
	}
	public boolean firstPageOfUserListDisplayedOnClickOfResetButton() {
		return gu.elementIsVisible(firstPage);
	}
	public boolean footerIsDisplayedOrNot() {
		return gu.elementIsVisible(footer);
	}
	public void clickOnAdminLogo() {
		gu.clickAction(adminLogo);
	}
	public void clickOnLogOutButton() {
		gu.clickAction(logOutButton);
	}
	public boolean logOutButtonDisplayedOrNot() {
		return gu.elementIsVisible(logOutButton);
	}
	public String getTheTitleOfLoginPage() {
		return gu.getTheTitle(driver);
	}
	

}
