package BasePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
			driver.get("http://leafground.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
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
}
