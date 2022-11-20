package testcases;

import org.testng.annotations.Test;

import config.TestData;
import pages.DashboardPageOne;
import pages.LoginPage;
import pages.PIMPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MyInfoTest {
	
		WebDriver dr;
		TestBase tb;
		LoginPage lp;
		DashboardPageOne dp;
		PIMPage pp;
	  @Test
	  public void getRecordCountItem_009() throws IOException {
		  
		  TestUtility.attachScreenshot(dr);
		  pp.clickOnPIMItemInList();
		  int act = pp.getRecordCount();
		  Assert.assertEquals(act, 41);
		  
	  }
	  
	  @Test
	  public void getRecordItem_010() throws IOException {
		  
		  TestUtility.attachScreenshot(dr);
		  pp.clickOnPIMItemInList();
		  String act = pp.getRequestedData("Anthony");
		  TestUtility.attachScreenshot(dr);
		  Assert.assertEquals(act.trim(), "Anthony");
	  }
	  @BeforeClass
	  public void beforeClass() throws IOException {
		  tb = new TestBase();
		  dr = tb.getInstanceForParallel();
		  lp = new LoginPage(dr);
		  dp = new DashboardPageOne(dr);
		  pp = new PIMPage(dr);
		  lp.loginToApp(TestData.userId, TestData.pass);
		  boolean act = dp.isDashboardHeaderDisplayed();
		  Assert.assertEquals(act, true);
	  }

	  @AfterClass
	  public void afterClass() {
		  dr.quit();
	  }

}
