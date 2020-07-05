package BasePackage;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public BasePage() {
		if(driver==null)
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nataraj\\.m2\\repository\\webdriver"
					+ "\\chromedriver\\win32\\83.0.4103.39\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://leafground.com/home.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		
}
	//*Not Use//But Selectable can use
	public void SelectValueMultiSelectDropDownWithoutSelect1(List<WebElement> Location,int index)
	{
	
		Actions action=new Actions(driver);
		action.clickAndHold(Location.get(index)).build().perform();
		System.out.println(Location.get(index).getText());
	}
	public void SelectValuemultiDropDownWithoutSelect(List<WebElement> Location,int index,int index1)
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(Location.get(index)).click(Location.get(index1)).build().perform();;
		System.out.println(Location.get(index).getText());
		System.out.println(Location.get(index1).getText());
	}
	public void RitvalAllValueFromDropDownUsingSelect(WebElement Location)
	{
		Select select=new Select(Location);
		List<WebElement> list=select.getOptions();
		
		for(WebElement ret :list)
		{
			System.out.println(ret.getText());
		}
		
		
	}
	
	public void SelectDropDownUsingSelect(WebElement Location,int index,String ValText)
	{
		Select select=new Select(Location);
		if(ValText==null)
		{
			select.selectByIndex(index);
			System.out.println(select.getFirstSelectedOption().getText());
		}
		else if(Character.isDigit(ValText.charAt(0)))
		{
			select.selectByValue(ValText);
			System.out.println(select.getFirstSelectedOption().getText());
		}
		else
		{
			select.selectByVisibleText(ValText);
			System.out.println(select.getFirstSelectedOption().getText());	
		}
		
	}
	public void RetrivalSelectedValueInDropDown(WebElement Location)
	{
		Select select=new Select(Location);
	List<WebElement> list=select.getAllSelectedOptions();
	for(WebElement ret:list)
	{
	System.out.println(ret.getText());	
	}
		
	}
	
	public void RitrivalAllValueFromDropDownlWithoutSelect(List<WebElement> list)
	{
		for(WebElement ret :list)
		{
			System.out.println(ret.getText());
		}
	}
	
	
	public void TextBoxWithSendKey(WebElement Location,String Name)
	{
		if(Location.isEnabled())
		{
			Location.sendKeys(Name);
			System.out.println(Location.getAttribute("value"));
		}
		else
		{
			System.out.println("TextBox is nor writable");
		}
		
		
	}
	public void TextWithouSendKey(WebElement Location,String Name)
	{
		JavascriptExecutor obj=(JavascriptExecutor) driver;
		obj.executeScript("arguments[0].value='"+Name+"';", Location);
		System.out.println(Location.getAttribute("value"));
		
	}
	
	public void SurfaceSize(WebElement Location)
	{
		System.out.println("(Width,Length)="+Location.getSize());
	}
	public void Position(WebElement Location)
	{
		Point point=Location.getLocation();
		System.out.println("x,Y"+point);
	}
	
	
	public void NormalScrennShot(String Name) throws IOException
	{
		TakesScreenshot take=(TakesScreenshot)driver;
		File Temp=take.getScreenshotAs(OutputType.FILE);
		File per=new File("C:\\Users\\Nataraj\\eclipse-workspace\\Orange_Hotel_Booking\\ScreenShot\\"+Name+".png");    //File name=new File("Location");
		FileHandler.copy(Temp,per); //(or) Utile.copyFile(Temp,per);
	}
	
	public void ParticularScrennShot(String Name,WebElement Location) throws IOException
	{
		TakesScreenshot take=(TakesScreenshot)Location;
		File Temp=take.getScreenshotAs(OutputType.FILE);
		File per=new File("C:\\Users\\Nataraj\\eclipse-workspace\\Orange_Hotel_Booking\\ScreenShot\\"+Name+".png");    //File name=new File("Location");
		FileHandler.copy(Temp,per); //(or) Utile.copyFile(Temp,per);
	}
	
	public void ParticularScrennShotWithoutInterFace(String Name,WebElement Location) throws IOException
	{
		File Temp=Location.getScreenshotAs(OutputType.FILE);
		File per=new File("C:\\Users\\Nataraj\\eclipse-workspace\\Orange_Hotel_Booking\\ScreenShot\\"+Name+".png");    //File name=new File("Location");
		FileHandler.copy(Temp,per); //(or) Utile.copyFile(Temp,per);
	}
	
	public void fullScreenShot(String Name) throws AWTException, IOException
	{
		Robot robot=new Robot();
		Dimension Size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec=new Rectangle(Size);
		BufferedImage Temp=robot.createScreenCapture(rec);
		File per=new File("C:\\Users\\Nataraj\\eclipse-workspace\\Orange_Hotel_Booking\\ScreenShot\\"+Name+".png");
		ImageIO.write(Temp,"png" , per);
		
		}
	public void LastVelueFromDropDown(WebElement Location)
	{
		Select select =new Select(Location);
		List<WebElement> list=select.getOptions();
		int Size=list.size();
		
		select.selectByIndex(Size-1);  
		System.out.println(select.getFirstSelectedOption().getText());
	}
	public void ButtonSize(WebElement Location)
	{
		
		System.out.println("Width"+Location.getSize().getWidth());
		System.out.println("Hight"+Location.getSize().getHeight());
		
	}
	public void Button_Position(WebElement Location)
	{
		System.out.println("XPosition="+Location.getLocation().getX());
		System.out.println("YPosition="+Location.getLocation().getY());
		System.out.println("Color="+Location.getCssValue("background-color"));
		System.out.println("Font size="+Location.getCssValue("font-size"));
		System.out.println("Family="+Location.getCssValue("font-family"));
		System.out.println("line Hight="+Location.getCssValue("line-height"));
		
		
	}
	
	public void Link(WebElement Location)
	{
	System.out.println("Link"+Location.getAttribute("href")	);
	System.out.println("No of Link Presented in Page"+driver.findElements(By.tagName("a")).size());
	Location.click();
	if(driver.getTitle().contains("404"))
	{
	System.out.println("Link is broken");
	}
	else
	{
	System.out.println("Link is Not Broken");
	}
		

	
	}
	
	public void Image(WebElement Location)
	{
		if(Location.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println("Image is Broken");
		}
		else
		{
			System.out.println("Image not Broken");
		}
		
		
		
		
	}
	
	public void Image_Broken_in_Page()
	{
		List<WebElement>list=driver.findElements(By.tagName("img"));
		int size=list.size();
		int count=0;
		for(WebElement list1:list)
		{count++;
			if(list1.getAttribute("naturalWidth").equals("0"))
			{
				System.out.println("Image is Broken");
				count--;
			}
			
		
		}
		
		
		if(count==size)
		{
			System.out.println("No Broken image");
		}
		else
		{
			System.out.println("No of broken images="+(size-count));
		}
		
		
	}
}




