package myPackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseTestCase {

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	WebDriver driver;
	
	@BeforeMethod
	@Parameters("myBrowser")
	public void beforemethod(String myBrowser){
		//WebDriver driver = new WebDriverFactory().create("firefox");
		if(myBrowser.equalsIgnoreCase("firefox")){
			 driver = new FirefoxDriver();
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			 driver = new ChromeDriver();
		}
		else{
			System.out.println("Your drive is not defined in the framework");
		}
		
		setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	public void setDriver(WebDriver driver){
			dr.set(driver);	
	}
	
	public WebDriver getDriver(){
			return dr.get();
		
	}
	
	@AfterMethod
	public void aftermethod(){
		getDriver().quit();
		dr.set(null);
	}
	
}
