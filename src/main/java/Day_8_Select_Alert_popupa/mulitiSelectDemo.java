package Day_8_Select_Alert_popupa;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
public class mulitiSelectDemo {

	private static final String WebDriverWait = null;







	public static void main(String[] args) throws InterruptedException {
		
		
//		deselectDemo();
//		selectMultiDeselectDemo();
		WebDriverWiteDemo();
		

	}

	
	
	public static void deselectDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// go to https://demoqa.com/select-menu
		driver.get("https://demoqa.com/select-menu");
		
		driver.findElement(By.xpath("//div[text()='Select...']")).click();
		Thread.sleep(2000);
		
		// find the green and click
		driver.findElement(By.xpath("//div[text()='Green']")).click();
		
		// select green, blue and black from multi select dropdown
		driver.findElement(By.xpath("//div[text()='Blue']")).click();
		
		driver.findElement(By.xpath("//div[text()='Black']")).click();
		Thread.sleep(1000);
	    // deselect the black
		//*[@id="selectMenuContainer"]/div[7]/div/div/div/div[1]/div[3]/div/div[2]
		
		driver.findElement(By.xpath("(//div[@class='css-xb97g8'])[3]")).click();
		
		
	}
	
	
	public static void selectMultiDeselectDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// go to https://demoqa.com/select-menu
		
		driver.get("https://demoqa.com/select-menu");
		
		// select all the options one by one 
		
		WebElement multiCarSelect = driver.findElement(By.id("cars"));
		
		Select select = new Select(multiCarSelect);
		select.selectByVisibleText("Volvo");
		select.selectByVisibleText("Saab");
		select.selectByVisibleText("Opel");
		select.selectByVisibleText("Audi");
		
		
		// deselect Opel from it
		select.deselectByVisibleText("Saab");
		
		
		Thread.sleep(3000);
		
		select.deselectAll();
		
	}
	
	
	
	
	
	
	
	public static void WebDriverWiteDemo()
	{
	
		WebDriver drive =new ChromeDriver();
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		// go to ebay.com
		drive.get("https://ebay.com");
		
		// click on Motors
		drive.findElement(By.linkText("Motors")).click();
		
		
		// wait until the Add Vehicle text is visible
		// create an object of webDriverWait
		    WebDriverWait wait =new WebDriverWait(drive,Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add a vehicle']")));
		    
		
		 // once it's, then print it's visible
		    System.out.println("Element is visiable");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
