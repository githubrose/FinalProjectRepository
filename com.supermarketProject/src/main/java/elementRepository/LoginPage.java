package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
    
	@FindBy(xpath = "//b[starts-with(text(),'7rmart')]")
	WebElement loginPageLogo;
	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "password")
	WebElement passWord;
	@FindBy(xpath = "//label[@for = 'remember']")
	WebElement rememberMeCheckBox;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInbtn;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getTheLoginPageLogo() {
		return gu.getTextFromTheElement(loginPageLogo);
	}
	public void enterUserName(String uName) {
		gu.enterTextBoxValue(userName, uName);
	}
	public void enterPassWord(String pwd) {
		gu.enterTextBoxValue(passWord, pwd);

	}
	public void clickRemeberMeCheckBox() {
		gu.clickAction(rememberMeCheckBox);
	}
	public void clickSignInBtn() {
		gu.clickAction(signInbtn);
	}
	public boolean rememberMeSelectedorNot() {
		return gu.elementIsSelected(rememberMeCheckBox);
	}
	public String readUserName(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
	}
	public String readPassWord(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
	}

}
