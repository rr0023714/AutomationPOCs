package myTests;
import myPackage.BaseTestCase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestSuite1 extends BaseTestCase{
	

	@Test
	public void firstTest() throws InterruptedException{
		getWebDriver().get("http://www.w3schools.com/");
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath(".//*[@id='sidemenu']/a[2]")).click();
		Thread.sleep(5000);
		System.out.println("First Test case completed");
	}
	
	@Test
	public void SecondTest() throws InterruptedException{
		getWebDriver().get("http://www.w3schools.com/");
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath(".//*[@id='sidemenu']/a[2]")).click();
		Thread.sleep(5000);
		System.out.println("Second Test case completed");
	}
	
	@Test
	public void thirdTest() throws InterruptedException{
		getWebDriver().get("http://www.w3schools.com/");
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath(".//*[@id='sidemenu']/a[2]")).click();
		Thread.sleep(5000);
		System.out.println("Third Test case completed");
	}
	
	@Test
	public void fourthTest() throws InterruptedException{
		getWebDriver().get("http://www.w3schools.com/");
		Thread.sleep(5000);
		getWebDriver().findElement(By.xpath(".//*[@id='sidemenu']/a[2]")).click();
		Thread.sleep(5000);
		System.out.println("Fourth Test case completed");
	}
}
