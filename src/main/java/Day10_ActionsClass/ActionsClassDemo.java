package Day10_ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDemo {

	public static void main(String[] args) {
//		actionsHoverOver();
		dragAndDropDemo();

	}

	
	
	public static void actionsHoverOver()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		
		// go to https://demoqa.com/menu
		driver.get("https://demoqa.com/menu");
		
		
		 // mouse hover over to the menu item 2 
		Actions act= new Actions(driver);
		
		WebElement item_2=driver.findElement(By.linkText("Main Item 2"));
		act.moveToElement(item_2).build().perform();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SUB SUB LIST »")));
		
		
		
		WebElement Sub_Sub_list=driver.findElement(By.linkText("SUB SUB LIST »"));
		act.moveToElement(Sub_Sub_list).build().perform();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sub Sub Item 1")));
		
	
		WebElement Sub_Sub_Item_1=driver.findElement(By.linkText("Sub Sub Item 1"));
		act.moveToElement(Sub_Sub_Item_1).build().perform();
		
		
		
	}
	
	public static void dragAndDropDemo()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		Actions act =new Actions (driver);
		
		// go to https://demoqa.com/droppable
		driver.get("https://demoqa.com/droppable");
		
		
		// drag the drag me box into drop here box
		Actions act_1=new Actions(driver);
		
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		act_1.dragAndDrop(drag, drop).build().perform();
		
		
	}
	
	
	}
	
	
	

