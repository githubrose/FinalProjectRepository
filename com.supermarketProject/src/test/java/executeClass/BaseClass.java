package executeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import elementRepository.LoginPage;
import utilities.ScreenShotClass;

public class BaseClass {

	WebDriver driver;
	ScreenShotClass sh;

	public static Properties property;
	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		property.load(fs);
	}

	@BeforeMethod
	@Parameters("browser")//for cross browser testing
	
	public void beforeMethod(String browserValue) throws IOException {

		readProperty();
		
		if(browserValue.equalsIgnoreCase("chrome")) {
			
			System.setProperty(property.getProperty("ChromeSystemProperty"), System.getProperty("user.dir")+property.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}
		else if(browserValue.equalsIgnoreCase("edge")){
			System.setProperty(property.getProperty("EdgeSystemProperty"), System.getProperty("user.dir")+property.getProperty("EdgeDriverPath"));
			driver = new EdgeDriver();
		}
		
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {

		if(iTestResult.getStatus()==ITestResult.FAILURE) {
			sh = new ScreenShotClass();
			sh.takeScreenshot(driver, iTestResult.getName());
		}	

		driver.quit();
	}


}
