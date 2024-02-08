package Day9_WindowHandels;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorks_WindowHandels {

	public static void main(String[] args)  {
		
//    	switch_window();
//		switch_window1();
    	Nested_FramDemo();
	}

	
	public static void switch_window()
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		/*
		 
       Test case 2 
          go to https://demoqa.com/browser-windows
          1. Get the main window ID and store it in a String called mainWindowId, 
          2. Click on the 'New Tab' button
          3. Get window IDs and store it into a Set
          4. Get the first window ID from the Set and Verify it matches with the main window id in step 1.  Then get the second window id and store it in variable called secondWindowId.
          5. Switch to the second window
          6. Verify that there is a text called 'This is a sample page'
          7. Close the window,  Switch back to the main window, Verify you are on the main window. 
           (verify with page title or page url)*/
		
		
		
		
		driver.get("https://demoqa.com/browser-windows");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		
		String mainWindowId=driver.getWindowHandle();
		System.out.println("main Window Id = "+mainWindowId);
		
		driver.findElement(By.id("tabButton")).click();
		
		
		Set <String>  window_IDs= driver.getWindowHandles();
		for(String single_id :window_IDs)
		{
			System.out.println(single_id);
			if(!single_id.equals(mainWindowId))
			{
				System.out.println(single_id);
				driver.switchTo().window(single_id);
			}
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));
		
	   String w=driver.findElement(By.id("sampleHeading")).getText();
		
		if(w.contains("This is a sample page"))
		{
			System.out.println("Yes..you ara verifying...");
		}
		driver.close();
		driver.switchTo().window(mainWindowId);
		
		
		String s=driver.getTitle();
		if(s.contains("DEMOQA"))
		{
			System.out.println("You Are In right side...");
		}
		
	}
	
	
	public static void switch_window1()
	{
		
  /*
  go to http://demo.guru99.com/popup.php
  Get title and store it in a variable.
  Click on Click Here button and switch over to next window, provide an email click Submit. 
  Get text of the user ID and password and store them in variables, print them out. 
  Then verify the text "This access is valid only for 20 days."
  Close the window.
  Go back to main window, and get title then verify it equals to your stored title.
  Quit driver.
   */
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("http://demo.guru99.com/popup.php");
		String titel=driver.getTitle();
		System.out.println(titel);
		
      //Click on Click Here button and switch over to next window, provide an email click Submit. 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Click Here']")));
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		
		Set <String> wind_IDs=driver.getWindowHandles();
		Iterator<String> it=wind_IDs.iterator();
		
		String firstwind=it.next();
		String secondwind=it.next();
		
		
		driver.switchTo().window(secondwind);
		
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("mays@yahoo.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
		
		
		
		
		String User_ID=driver.findElement(By.xpath("(//td[@align='center'])[3]")).getText();
		String Pass=driver.findElement(By.xpath("(//td[@align='center'])[5]")).getText();
		System.out.println("User_ID :"+ User_ID);
		System.out.println("Pass :"+ Pass);
		
		
		
		String text=driver.findElement(By.tagName("h3")).getText();
		if (text.contains("This access is valid only for 20 days."));
		
    	{System.out.println("Yes..Verify");}
		
		
		driver.switchTo().window(firstwind);
		String new_titel=driver.getTitle();
		System.out.println(new_titel);
		
		
		if(titel.equals(new_titel))
			
		{System.out.println("Yes..Same titel so it is match");}
		else 
		{System.out.println("NO .. NO match");
		}
		
		driver.quit();
		
	}
	
	
	
	
	
	
	public static void Nested_FramDemo() 
	{
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		// go to https://demoqa.com/nestedframes
		driver.get("https://demoqa.com/nestedframes");
		
		
		// get the main content text
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("framesWrapper")));
		String Defualt_text=driver.findElement(By.id("framesWrapper")).getText();
		System.out.println("Defualt_text :"+ Defualt_text);
		
		
	

		
		// switch to parent frame and get the text 
	
		driver.switchTo().frame("frame1");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[text()='Parent frame']")));
		WebElement parent=driver.findElement(By.xpath("//body[text()='Parent frame']"));
		String parentText =parent.getText();
		System.out.println("Parent_text: "+ parentText );
		
		
//		// switch to child frame and get the text 
//		driver.switchTo().frame(driver.findElement(By.xpath("html/body/p")));
////		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/p")));
//		WebElement child=driver.findElement(By.xpath("//html/body/p"));
//		String child_text=child.getText();
//		System.out.println("child_text : "+ child_text );
		
		
		
	}
	

	
}
	
	
	
	

