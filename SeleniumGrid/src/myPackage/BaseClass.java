package myPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeMethod
	@Parameters("myBrowser")
	public void beforemethod(String myBrowser) throws IllegalAccessException, MalformedURLException{
		
		RemoteWebDriver driver = null;
		
		if(myBrowser.equals("chrome")){
			DesiredCapabilities capability = new DesiredCapabilities().chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		
		if(myBrowser.equals("firefox")){
			DesiredCapabilities capability = new DesiredCapabilities().firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.WINDOWS);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		}
		
		setWebDriver(driver);
		
		getWebDriver().manage().window().maximize();
		getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void setWebDriver(RemoteWebDriver driver){
		dr.set(driver);
	}
	
	
	public WebDriver getWebDriver(){
		return dr.get();
	}
	
	@AfterMethod
	public void aftermethod(){
		getWebDriver().quit();
		dr.set(null);
	}
}
