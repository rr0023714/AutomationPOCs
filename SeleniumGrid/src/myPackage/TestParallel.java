package myPackage;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestParallel extends BaseClass{

	@Test
	public void test_01() throws InterruptedException{
		getWebDriver().get("http://www.w3schools.com/");
		Thread.sleep(5000);
		
		getWebDriver().findElement(By.xpath("html/body/div[2]/div/a[4]")).click();
	    Thread.sleep(5000);
	    
	    getWebDriver().findElement(By.xpath(".//*[@id='gsc-i-id1']")).sendKeys("test");
	    Thread.sleep(5000);
		
		
	

	}
	
	
}
