package Test_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import BasePackage.BasePage;
import Object_Page_Package.TexBox;

public class TestText {

	TexBox t;
	BasePage b;
	
	public TestText() {
		t=new TexBox();
		b=new BasePage();
	}
	
	@DataProvider(name="Text")
	public Object[][] Datas()                      //int[][]                  int a[][]=new int[5][];
	{
		Object[][] Data=new Object[5][1];         // -Array Declaration
		Data[0][0]="Hai";
		Data[1][0]="Hai2";
		Data[2][0]="Hai3";                   // Object[][] Data=new Object[1][2];  
	                                         //Data[0][0]="User"
		Data[3][0]="Hai4";                   //Data[0][1]="Pass"
		Data[4][0]="Hai4";
		return Data;
		}
	
	@Test(dataProvider="Text")
	public void TextBox(String text)
	{
		t.Button.click();
		//b.TextBoxWithSendKey(t.TextBox, "RamGURUSenthil");
		//b.TextBoxWithSendKey(t.Disable, "Hai");
		b.TextWithouSendKey(t.TextBox,text);
		b.SurfaceSize(t.TextBox);
		b.Position(t.TextBox);
t.Home.click();
	}
	
	
	


}
