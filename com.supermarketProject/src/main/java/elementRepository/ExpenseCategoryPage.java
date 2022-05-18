package elementRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ExpenseCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();
	
	@FindBy(xpath = "//a[@onclick = 'click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement titleTextBox;
	@FindBy(name = "Create")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement createAlert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement duplicateAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement searchTitleTextBox;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButton2;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement searchResult;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	public @FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement updateValuetxt;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
	WebElement updatedValue;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	
	public ExpenseCategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickNewButton() {
		gu.clickAction(newButton);

	}
	public void enterTitle(String title) {
		gu.enterTextBoxValue(titleTextBox, title);
	}
	public void clickSaveButton(){
		gu.clickAction(saveButton);
	}
	public boolean alertMessageForSuccessfulCreationDisplayedOrNot() {
		return gu.elementIsVisible(createAlert);
	}
	public boolean alertMessageForDuplicateTitleDisplayedOrNot() {
		return gu.elementIsVisible(duplicateAlert);
	}

	public void clickResetButton()
	{
		gu.clickAction(resetButton);
	}
	public void clickMainSearchButton() {
		gu.clickAction(searchButton);
	}

	public void enterTheTitleToBeSearched(String title) {
		gu.enterTextBoxValue(searchTitleTextBox, title);
	}
	public void clickSearchButton() {
		gu.clickAction(searchButton2);
	}
	public void clickEditButton() {
		gu.clickAction(editButton);
	}
	public void clearTheTitle() {
		updateValuetxt.clear();
	}
	public void editTheValue(String text) {
		gu.enterTextBoxValue(updateValuetxt, text);
	}
	public void clickUpdateButton() {
		gu.clickAction(updateButton);
	}
	public void explicitWaitElementToBeClickable() {
		wait.elementToBeClickable(driver, editButton);
	}
	public void clickDeleteButton() {
		gu.clickAction(deleteButton);
	}
	public void explicitWaitAlertIsPresent() {
		wait.alertIsPresent(driver);
		driver.switchTo().alert().accept();
	}
	public String getTextFromTable() {
		return gu.getTextFromTheElement(searchResult);
	}
	



}
