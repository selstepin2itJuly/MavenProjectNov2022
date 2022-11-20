package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	public static void scrollToElementJS(WebElement ele)
	{
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].scrollIntoView(false);", ele); //true by default
		jr.executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void clickOnElementJS(WebElement ele)
	{
		JavascriptExecutor jr = (JavascriptExecutor) driver;
		jr.executeScript("arguments[0].click();", ele); 
	}
	
	public static void captureScreen() throws IOException
	{
		File f1 = new File("c:\\Screenshot");
		if(!f1.isDirectory())
		{
			f1.mkdir();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f1+"/"+getDate()+"_image.jpg"));
	}
	public static void captureScreen(WebDriver driver) throws IOException
	{
		File f1 = new File("c:\\Screenshot");
		if(!f1.isDirectory())
		{
			f1.mkdir();
		}
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File(f1+"/"+getDate()+"_image.jpg"));
	}
	
	public static void attachScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		Reporter.log(image);
	}
	public static void attachScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		Reporter.log(image);
	}
	
	public static String getDate()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String s = sdf.format(dt);
		return s;
	}
	
	//Explicit
	public static void waitForElementClickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementVisible(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	//Fluent
	public static void waitFluentElementVisible(WebElement ele)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
