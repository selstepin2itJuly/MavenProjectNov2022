package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageOne {

	private WebDriver dr;
	public DashboardPageOne(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	//OR
	
	@FindBys({@FindBy(xpath="//h6[text()='Dashboard']"),
		@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/child::*")})
	 
	//@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardHeader;
	
	@FindBy(css="p[class='oxd-userdropdown-name']")
	private WebElement loginUser;
	//And
	@FindAll({@FindBy(linkText="Logout"),
				@FindBy(how = How.CSS, using="a[class='oxd-userdropdown-link'][href$='logout']")})
	private WebElement logout;
	
	public boolean isDashboardHeaderDisplayed()
	{
		boolean b =false;
		try {
			b=dashboardHeader.isDisplayed();
		}catch(Exception e)
		{
			e.getMessage();
		}
		return b;
	}
	
	public void logout()
	{
		loginUser.click();
		logout.click();
	}
}
