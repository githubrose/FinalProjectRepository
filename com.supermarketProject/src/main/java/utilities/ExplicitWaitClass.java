package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void presenceOfElementLocated(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

	}
	public void alertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void elementToBeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeSelected(element));	

	}




}
