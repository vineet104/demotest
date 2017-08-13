package demoTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LogIn2 
{ public WebDriver driver= null;
	
	@Test
	public void LogIn1() throws IOException
	{   Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Alka\\git\\demotest\\Demo\\src\\login_details.properties");
		prop.load(fis);
		
		if(prop.getProperty("Browser").contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").contains("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Alka\\seljen\\seljen\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(prop.getProperty("userid"));
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(prop.getProperty("pass"));
		driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		driver.quit();
		
	}

}
