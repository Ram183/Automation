package Test_Package;

import org.testng.annotations.Test;

import BasePackage.BasePage;
import Object_Page_Package.DropDown;

public class DropDownTest {
BasePage b;
DropDown d;
	public DropDownTest() {
		
		b=new BasePage();
		d=new DropDown();
		
	}

	@Test
	public void Link()
	{
	
	b.Image(d.Image);	
	b.Image_Broken_in_Page();
	
	}
	
	
	
}
