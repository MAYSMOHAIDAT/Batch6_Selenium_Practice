package Day9_WindowHandels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class IframDemo {

	public static void main(String[] args) {
		
//    	iFramDemo();
		Nested_FramDemo();
	
	}
	
	
	public static void iFramDemo()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		
		driver.get("https://demoqa.com/frames");
		//get defult content text and print it:
		String defult_context=driver.findElement(By.xpath("//*[contains(text(),'Sample Iframe page There are 2 Iframes')]")).getText();
		System.out.println("defult_context  :"+ defult_context);
		
		//switch to first frame and get text to verify its "This is a sample page"
		driver.switchTo().frame("frame1");
		
		String FrameText=driver.findElement(By.id("sampleHeading")).getText();
		if(FrameText.contains("This is a sample page"))
		{ System.out.println("Yes.. thats Match");
		}
		
		//switch back to parent and get text:
		driver.switchTo().parentFrame();
		
		String defult_context_second_time=driver.findElement(By.xpath("//*[contains(text(),'Sample Iframe page There are 2 Iframes')]")).getText();
		System.out.println("defult_context_second_time : "+ defult_context_second_time);
		}
		
		
	
	
	
	public static void Nested_FramDemo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		// go to https://demoqa.com/nestedframes
		driver.get("https://demoqa.com/nestedframes");
		
		
		// get the main content text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("framesWrapper")));
		String Defualt_text=driver.findElement(By.id("framesWrapper")).getText();
		System.out.println("Defualt_text :"+ Defualt_text);
		
		
		

		driver.switchTo().frame("frame1");
		// switch to parent frame and get the text 
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1Wrapper")));
		
		
		WebElement parent=driver.findElement(By.xpath("/html/body"));
		String parentText =parent.getText();
		System.out.println("Parent_text:    "+parentText );
		
		
		
		
		
		
		
		
	}
	
	}
	
	
	
	


	
	


