package day11_Framework_driver_utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utiles.BrowserUtils;

public class Utility_Usage_demo {

	public static void main(String[] args) {
		AlertUtilsDemo();

	}
public static void AlertUtilsDemo() {
	
	
	BrowserUtils utils=new BrowserUtils();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Test case 1
		//go to https://demoqa.com/alerts
		driver.get("https://demoqa.com/alerts");
		
		//Click on the first ‘Click me’  button and Accept the alert.
		driver.findElement(By.id("alertButton")).click();
		
		// let's wait the alert to be present first, then interact with it
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// now it's time to handle the alert
		
		
		// accept is for anything confirmative like: Yes, Okay, Confirm, Accept etc....
		utils.alert_accept(driver);
		
		driver.quit();
		
	}
}
