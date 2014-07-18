import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SanityTest {
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	{	
		File app = new File("/Users/qa/AuctionAppFile/Auction.com.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.VERSION, "7.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPad");
		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Thread.sleep(5000);
		driver.findElement(By.name("Commercial")).click();
		
		driver.findElement(By.name("Residential")).click();
		;
		//driver.findElement(By.name("Starting Bid: TBD, Asset")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("preferences")).click();
//		Thread.sleep(2000);
		driver.findElement(By.name("preferences")).click();
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).click();
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIATextField[1]")).sendKeys("nbangale@auction.com");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).click();
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[2]/UIASecureTextField[1]")).sendKeys("");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[7]")).click();
//		driver.findElement(By.name("Terms of Use")).click();
		
		driver.findElement(By.name("Close")).click();
	}

}
