package Academy.Assignment;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class Login extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{

		 driver =initializeDriver();
	}
	
	@Test
	public void userLogin() {
		driver.get(prop.getProperty("url"));
//Checking Gold Color
		String colourGold = driver.findElement(By.xpath("//div[@class='myHeading']")).getCssValue("background-color");
		String c = Color.fromString(colourGold).asHex(); 
		System.out.println(c);
//Checking Navy Blue color
		String colourNavyBlue = driver.findElement(By.xpath("//button[@type='submit']")).getCssValue("background-color");
		String c1 = Color.fromString(colourNavyBlue).asHex(); 
		System.out.println(c1);
		
		LoginPage lp = new LoginPage(driver);
//Login with valid user credentials
		lp.getUsername().sendKeys("prasad.bembde@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		assertEquals("QTRecognition", driver.getTitle());
		//System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
}
