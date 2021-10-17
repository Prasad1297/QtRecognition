package Academy.Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SendKudosPage;
import PageObjects.activityPage;
import resources.base;

public class SendKudos extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
	public void sendKudos(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("prasad.bembde@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		activityPage aP = new activityPage(driver);
		aP.clickSendkudos().click();
		SendKudosPage kudos = new SendKudosPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kudos.getEmailInKudosSearch().sendKeys("harshini.iyli@qualitestgroup.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		kudos.getWriteAppreciationMsg().click();
		kudos.getComment().sendKeys("Goood Work");;
		kudos.getSendButton().click();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();	
	}
	/*Robot r = new Robot();
	r.delay(1000);
	r.keyPress(KeyEvent.VK_DOWN);
	r.delay(1000);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.delay(1000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.delay(1000);
	r.keyRelease(KeyEvent.VK_ENTER);
	r.delay(1000);*/
}
