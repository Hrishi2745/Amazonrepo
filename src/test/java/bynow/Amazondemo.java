package bynow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazondemo 
{
	WebDriver driver;
  @Test
  public void Bynow()
  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\Driver\\Chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	driver.findElement(By.linkText("Dell Inspiron 3525 Laptop, AMD Athlon Silver 3050U, Win 11 + MSO'21, 8GB GDDR4, 256Gb SSD, Radeon Graphics, 15.6\" (39.62Cms) HD Anti-Glare (D560766Win9Be, 1.68Kgs)")).click();
	String parentWin =driver.getWindowHandle();
	System.out.println(parentWin);
	Set<String> childwin=driver.getWindowHandles();
	System.out.println(childwin);
	Iterator<String> itr = childwin.iterator();
	while (itr.hasNext())
	{
		String childwindow = itr.next();
		if (!parentWin.equalsIgnoreCase(childwindow))
		{
			driver.switchTo().window(childwindow);
			driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();

		}
	}
 	driver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
	driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Hrushikesh Khopade");
	driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("9922326792");
	driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("hrushikeshkhopade@gmail.com");
	driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("hrushi7020$");


  }
}
