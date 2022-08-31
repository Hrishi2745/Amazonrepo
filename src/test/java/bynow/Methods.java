package bynow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods 
{
	WebDriver driver;
	String value =null;
	public void windowHandles(String xpath) throws InterruptedException
	  {
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
					driver.findElement(By.xpath(xpath)).click();

				}
			}
	  }
	public void implicitWait(int time)
	  {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	  }
	  public void ExplicitWait(int time)
	  {
		  	WebDriverWait wait = new WebDriverWait(driver,time);
		  	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[contains(text(),' We will send you a text to verify your phone.')]"))));
	  }
	  public void clearCache() throws InterruptedException
	  {
			driver.get("chrome://settings/clearBrowserData");
			Thread.sleep(3000);
			JavascriptExecutor js =(JavascriptExecutor)driver;
			String script ="return document.querySelector('settings-ui').shadowRoot.querySelector('settings-main').shadowRoot.querySelector('settings-basic-page').shadowRoot.querySelector('settings-section > settings-privacy-page').shadowRoot.querySelector('settings-clear-browsing-data-dialog').shadowRoot.querySelector('#clearBrowsingDataDialog').querySelector('#clearBrowsingDataConfirm')";
			WebElement cleardata= (WebElement)js.executeScript(script);
			cleardata.click();	
			Thread.sleep(4000);
	  }
	  public void ScreenShots() throws IOException
	  {
		  	String fileWithPath ="C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\ScreenShot\\";
		  	Date d = new Date();
		  	String FileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		  	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  	FileHandler.copy(screenshot, new File(fileWithPath + FileName));
	}
	  	/*String code = driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).getText();
		//System.out.println(code);
		if (code=="IN +91")
		{
			
			System.out.println("Checked");
		}
		else
		{
			Select drp = new Select(driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")));
			drp.selectByVisibleText("IN +91");
	
		}*/
	  public String ExcelReadMethod(String sheetname, int l,int m) throws IOException 
		{
			
			FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\Amazon\\Excel\\Information.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetname);
			//int rowcount = sheet.getLastRowNum();
			
			for(int i=0;i<l;i++)
			{
				//int colcount = sheet.getRow(i).getLastCellNum();
				XSSFRow currentrow = sheet.getRow(i);
				for(int j=0;j<m;j++)
				{
					value=currentrow.getCell(j).toString();
					System.out.print(" "+value);
				}
				System.out.println();		
			}
			return value;
		}

}
