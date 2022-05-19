package utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	
	public void enterTextBoxValue(WebElement element,String text) {
		element.sendKeys(text);

	}

	public void clickAction(WebElement element) {
		element.click();
	}

	public boolean elementIsSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean elementIsVisible(WebElement element) {
		return element.isDisplayed();
	}
	public boolean elementIsEnabled(WebElement element) {
		return element.isEnabled();
	}
	public String getTextFromTheElement(WebElement element) {
		return element.getText();
	}
	
	public void addImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void scrollWindowToTheElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public String getTheURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getTheTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public void selectFromDropDown(WebElement element,int i) {
		Select select = new Select(element);
		select.selectByIndex(i);
	}

}
