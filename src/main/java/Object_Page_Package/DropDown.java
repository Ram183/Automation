package Object_Page_Package;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BasePage;

public class DropDown extends BasePage {

	public DropDown() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id=\'dropdown1\']")
	public WebElement DropDown1;
	@FindBys(@FindBy(xpath="//select[@id=\'dropdown1\']/option"))
	public List<WebElement> DropDown11;
	
	@FindBy(xpath="//*[@id=\"contentblock\"]/section/div[6]/select")
	public WebElement Multi1;
	
	

	
	@FindBys(@FindBy(xpath="//*[@id=\"contentblock\"]/section/div[6]/select/option"))
	public List<WebElement> Multi11;
	
	@FindBy(xpath="//button[@id='size']")
	public WebElement Button;
	
	@FindBy(xpath="//*[@id=\"contentblock\"]/section/div[3]/div/div/a")
	public WebElement link;
	
	@FindBy(xpath="//*[@id=\"contentblock\"]/section/div[2]/div/div/img")
	public WebElement Image;
	
	
}
