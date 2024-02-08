package Day_8_Select_Alert_popupa;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert_handlingDemo {

	public static void main(String[] args) {
		
		alertDemo();
//		alertAfter_5_second();
	}
	
	
	
   public static void alertDemo()
   {
	   
	   WebDriver driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	   //go to https://demoqa.com/alerts
	   
	   driver.get("https://demoqa.com/alerts");
	   
	   //Click on the first 'Click me'  button and Accept the alert.
	   driver.findElement(By.id("alertButton")).click();
	   
	   
	// let's wait the alert to be present first, then interact with it
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.alertIsPresent());
	   
	   
	// now it's time to handle the aler
	   Alert al=driver.switchTo().alert();
	   al.accept();
	   
	   
   }
	
   public static void alertAfter_5_second()
   {
	   
	   WebDriver driver =new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
	   //go to https://demoqa.com/alerts 
	   driver.get("https://demoqa.com/alerts");
	   
	 //Click on the second 'Click me' button and get the text of it. 
	   driver.findElement(By.id("timerAlertButton")).click();
	   
   
//		// we wait for the alert to be present before we interact with it
	   WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(3));
	   wait.until(ExpectedConditions.alertIsPresent());
	   
	   
	   
	 //Then verify if the text equals to "This alert appeared after 5 seconds" 
	   Alert handel =driver.switchTo().alert();
	   String alrtText=handel.getText();
	   
	   if(alrtText.equals("This alert appeared after 5 seconds"))
		   
	   {  System.out.println("MATCH");}
	   else {System.out.println("NO...MATCH");}
	   
	   
	// then Accept the alert.
	   handel.accept();
	   
	 

	   
	   
   }

}
