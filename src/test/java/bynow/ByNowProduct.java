package bynow;



import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ByNowProduct extends Methods
{
	
	String searchitem = "Dell Laptop";
  @BeforeMethod
  public void launchbrowser() throws InterruptedException
  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

  }
  @Test
  public void searchItem() throws InterruptedException, IOException
  {
	  	
	  	ScreenShots();
	  	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(searchitem);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		ScreenShots();
		implicitWait(3);
		driver.findElement(By.linkText("Dell Inspiron 3525 Laptop, AMD Athlon Silver 3050U, Win 11 + MSO'21, 8GB GDDR4, 256Gb SSD, Radeon Graphics, 15.6\" (39.62Cms) HD Anti-Glare (D560766Win9Be, 1.68Kgs)")).click();
		implicitWait(3);
		ScreenShots();
		windowHandles("//input[@id='buy-now-button']");
		implicitWait(3);
		createYourAccount();

		
  }
 public void createYourAccount() throws InterruptedException, IOException
  {
	 	String yourName = ExcelReadMethod("Info",2,1);
	 	String mobileNo = ExcelReadMethod("Info",2,2);
	 	String email = ExcelReadMethod("Info",2,3);
	 	String pwd = ExcelReadMethod("Info",2,4);
	 	
	 	driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		implicitWait(3);
		ScreenShots();
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(yourName);
		implicitWait(3);
		
		driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys(mobileNo);
		implicitWait(3);

		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(email);
		implicitWait(3);

		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pwd);
		ScreenShots();
		
		ExplicitWait(30);

  }
  
  @AfterMethod
  public void closeBrowser() throws InterruptedException
  {
	  clearCache();
	  driver.quit();
  }
	  
  
  
}
