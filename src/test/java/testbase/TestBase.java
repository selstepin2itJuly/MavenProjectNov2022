package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver pdriver;
	public Properties propP=new Properties();
	public String browserP;
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static String browser;
	public static String parallel;
	
	
	public static WebDriver getInstance() throws IOException
	{
		
		String configFile="./src/main/java/config/config.properties";
		FileInputStream inStream = new FileInputStream(new File(configFile));
		prop.load(inStream);
		
		browser = prop.getProperty("browser");
		
		/*if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			driver = new ChromeDriver();
		}*/
		
		switch(browser)
		{
		case "chrome"	:	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
							driver = new ChromeDriver();
							break;
							
		case "edge"		:	System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
							driver = new EdgeDriver();
							break;
			
		case "firefox"	:	System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoagent"));
							driver = new FirefoxDriver();
							break;
		default:			Throwable thr = new Throwable();
							thr.initCause(null);
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver getInstanceForParallel() throws IOException
	{
		String configFile="./src/main/java/config/config.properties";
		FileInputStream inStream = new FileInputStream(new File(configFile));
		propP.load(inStream);
		
		browserP = propP.getProperty("browser");
		
		/*if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
			driver = new ChromeDriver();
		}*/
		
		switch(browserP)
		{
		case "chrome"	:	System.setProperty("webdriver.chrome.driver", propP.getProperty("chromeagent"));
							pdriver = new ChromeDriver();
							break;
							
		case "edge"		:	System.setProperty("webdriver.edge.driver", propP.getProperty("edgeagent"));
							pdriver = new EdgeDriver();
							break;
			
		case "firefox"	:	System.setProperty("webdriver.gecko.driver", propP.getProperty("geckoagent"));
							pdriver = new FirefoxDriver();
							break;
		default:			Throwable thr = new Throwable();
							thr.initCause(null);
		}
		pdriver.get(propP.getProperty("url"));
		pdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		pdriver.manage().window().maximize();
		return pdriver;
	}
}
