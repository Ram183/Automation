package Object_Page_Package;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BasePage;

public class Login_Page  extends BasePage{

	public Login_Page() {
	PageFactory.initElements(driver, this);	
	}

@FindBy(id="txtUsername")	
public WebElement txtUsername;
@FindBy(id="txtPassword")
public WebElement txtPassword;
@FindBy(id="btnLogin")
public WebElement btnLogin;

	
}
