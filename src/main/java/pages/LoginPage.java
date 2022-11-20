package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver dr;
	public LoginPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	//FindBy
	//FindBys
	//FindAll
	
	@FindBy(name="username")
	private WebElement username; 
	
	@FindBy(css="[type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void loginToApp(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickOnLoginButton();
	}
}
