package myPackage;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class BaseTestCase {
	
	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	RemoteWebDriver driver;
	
	
	// Initializes the driver with browser
	@BeforeMethod
	@Parameters("myBrowser")
	public void beforeMethod(String myBrowser) throws MalformedURLException{
		
		
		RemoteWebDriver driver = null;
			
		
		if(myBrowser.equalsIgnoreCase("firefox")){
			DesiredCapabilities capability = new DesiredCapabilities().firefox();
			capability.setBrowserName("firefox");
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capability);
			
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
			DesiredCapabilities capability = new DesiredCapabilities().chrome();
			capability.setBrowserName("chorme");
			capability.setPlatform(Platform.WINDOWS);
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		
		setWebDriver(driver);
					
	}
	
	public void setWebDriver(RemoteWebDriver driver){
		dr.set(driver);
		
	}
	
	public WebDriver getWebDriver(){
		return dr.get();
	}

	
	@AfterMethod
	public void afterMethod(){
		getWebDriver().quit();
		
	}
}
