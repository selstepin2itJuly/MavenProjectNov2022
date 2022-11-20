package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {

	private WebDriver dr;
	public PIMPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[text()='PIM']")
	private WebElement pim;
	
	@FindBy(xpath="//div[@class='oxd-table-body']/div")
	private List<WebElement> RecordRows;
	
	public void clickOnPIMItemInList()
	{
		pim.click();
	}
	
	public int getRecordCount()
	{
		return RecordRows.size();
	}
	
	public String getRequestedData(String str)
	{
		String name = null;
		int row = dr.findElements(By.xpath("//div[@class='oxd-table-body']/div")).size();
		int col = dr.findElements(By.xpath("//div[@class='oxd-table-body']/div[1]/div/div/div")).size();
		for(int i=1;i<=row;i++)
		{
			for(int j=1;j<=col;j++)
			{
				name=dr.findElement(By.xpath("//div[@class='oxd-table-body']/div["+i+"]/div/div["+j+"]/div")).getText();
				if(name.contains(str))
				{
					return name;
				}
			}
		}
		//return name;
		return name;
	}
}
