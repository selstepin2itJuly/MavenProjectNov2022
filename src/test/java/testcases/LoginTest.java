package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.DashboardPageOne;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPageOne dp;
	private TestBase tb;
	
	@Test(priority=-1, description="Sucessful Login")
  public void loginSuccess_001() throws IOException {
	  
	  //lp.loginToApp("Admin", "admin123");
		TestUtility.attachScreenshot(dr);
		lp.enterUsername(TestData.userId);
		lp.enterPassword(TestData.pass);
		lp.clickOnLoginButton();
		Reporter.log("Username:"+"Admin");
	  boolean act = dp.isDashboardHeaderDisplayed();
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(act, true);
	  dp.logout();
	  
  }
	
	@Test(priority=1, description="Unsuccessful Login")
	  public void LoginUnsuccessful_002() throws IOException {
		  
		  	TestUtility.attachScreenshot(dr);
			lp.enterUsername(TestData.invalidUserId);
			lp.enterPassword(TestData.invalidPass);
			lp.clickOnLoginButton();
			Reporter.log("Username:"+TestData.invalidUserId);
			Reporter.log("Password:"+TestData.invalidPass);
		  boolean act = dp.isDashboardHeaderDisplayed();
		  TestUtility.attachScreenshot(dr);
		  Assert.assertEquals(act, false);
		  
	  }
  
  //Pre-Condition
  @BeforeMethod
  public void beforeMethod() throws IOException {
	 tb = new TestBase();
	 dr = tb.getInstanceForParallel();
	
	 lp = new LoginPage(dr);
	 dp = new DashboardPageOne(dr);
	// TestUtility.attachScreenshot();
  }

  
  //Post Condition
  @AfterMethod
  public void afterMethod() {
	 
	  dr.quit();
  }

}
