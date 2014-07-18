import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class SanityTest {
	
	WebDriver driver = null;
	@BeforeSuite
	public void setup() throws MalformedURLException, InterruptedException
	{
		File app = new File("/Users/qa/AuctionAppFile/Auction.com.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.VERSION, "7.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPad");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
	}
	
	@Test
	public void loginValidTest() throws InterruptedException
	{	
//		driver.findElement(By.name("Commercial")).click();
//		driver.findElement(By.name("Residential")).click();
		driver.findElement(By.name("preferences")).click();		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).click();		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).sendKeys("nbangale@auction.com");		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).sendKeys("Auction7688");		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("Log Out")).click();
		driver.findElement(By.name("Yes")).click();
		driver.findElement(By.name("Close")).click();
	}
	
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.name("preferences")).click();		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).click();		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).sendKeys("nbangale@auction.com");		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).sendKeys("test");		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")).click();		
		driver.findElement(By.name("OK")).click();
		driver.findElement(By.name("Close")).click();
	}
	
	@Test
	public void sampleSearch() throws InterruptedException
	{
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]")).sendKeys("San Jose");
		Thread.sleep(1000);
		driver.findElement(By.name("Commercial")).click();
	}
}
