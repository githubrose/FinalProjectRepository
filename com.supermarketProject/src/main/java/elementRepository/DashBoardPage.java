package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	@FindBy(xpath = "//span[text()='7rmart supermarket']")	
	WebElement logo;
	@FindBy(xpath = "//p[contains(text(),' Manage Expense')]")
	WebElement manageExpense;
	@FindBy(xpath = "(//li[@class='nav-item'])[3]")
	WebElement manageExpenseList;
	@FindBy(xpath = "//h1[text()='Expense Category']")
	WebElement expenseCategoryLabel;
	@FindBy(xpath = "//ul[@class='navbar-nav']")
	WebElement pushMenu;
	@FindBy(className = "os-scrollbar-track")
	WebElement leftMenu;
	@FindBy(xpath = "(//img[starts-with(@src,'http://groceryapp.uniqassosiates.com')])[3]")
	WebElement adminImage;
	@FindBy(xpath = "(//a[starts-with(@href,'http://groceryapp.uniqassosiates')])[32]")
	WebElement homeLink;
	@FindBy(className = "d-block")
	WebElement userID;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTheLogo() {
		return gu.getTextFromTheElement(logo);
	}
	public String getTheUseID() {
		return gu.getTextFromTheElement(userID);
	}
	public boolean checkListUnderManageExpenseVisibleOrNot() {
		return gu.elementIsVisible(manageExpenseList);
	}
	public void clickManageExpenseList() {
		gu.clickAction(manageExpenseList);
	}
	public String getTextFromExpenseCatagoryLabel() {
		return gu.getTextFromTheElement(expenseCategoryLabel);
	}
	public boolean checkPushMenuIsEnabledOrNot() {
		return gu.elementIsEnabled(pushMenu);
	}
	public void clickOnPushMenu() {
		gu.clickAction(pushMenu);
	}
	public boolean checkLeftMenuVisibleOrNot() {
		return gu.elementIsVisible(leftMenu);
	}

	public void clickManageExpense() {
		gu.clickAction(manageExpense);
		
	}
	public void clickHomeLink() {
		gu.clickAction(homeLink);
	}

}
