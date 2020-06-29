package Object_Page_Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BasePage;

public class TexBox extends BasePage {

	public TexBox() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\'post-153\']/div[2]/div/ul/li[1]/a")
	public WebElement Button;
	@FindBy(xpath="//input[@id='email']")
	public WebElement TextBox;
	@FindBy(xpath="//input[@disabled='true']")
	public WebElement Disable;
	@FindBy(xpath="//*[@id=\"text-2\"]/a")
	public WebElement Home;
	
	

}
