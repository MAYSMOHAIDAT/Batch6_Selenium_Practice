package TestCases_Homeworks;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases {

	public static void main(String[] args) throws InterruptedException {
//    	TestCase1();
		TestCase2();
//		TestCase3();
//		TestCase4();

	}

	
	public static void TestCase1() throws InterruptedException
	{
		
		//Test case 1:
	   // go to amazon.com 
	   // get all the options in the departments select dropdown
	   //verify there are total 58 departments. And print them out.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// go to amazon.com 
		driver.get("https://amazon.com");
		
		
		
		
		// get all the options in the departments select dropdown
		WebElement alloptions=driver.findElement(By.id("searchDropdownBox"));
		Select m=new Select ( alloptions);
		Thread.sleep(1000);
		
		
		List <WebElement> all=m.getOptions();
		System.out.println("Nubmer of options is = "+all.size() );
		
		
		for (WebElement a:all)
		{
			System.out.println(a.getText());
		}	
	}
	
	
	
	
	
	
	public static void TestCase2() throws InterruptedException
	{
	//Test case 2
	   //go to amazon.com
	   //verify that you are on the amazon home page. (verify with title). 
	   //verify dropdown value is by default "All Departments"
	   //select department Home & Kitchen, and search coffee mug.
	   //verify you are on coffee mug search results page (use title).
	   //verify you are in Home & Kitchen department.
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://amazon.com");
		
		//verify that you are on the amazon home page. (verify with title).
		String expeted="Amazon.com. Spend less. Smile more.";
		if(driver.getTitle().equals(expeted))
		{System.out.println("good");}
		
		
		 //verify dropdown value is by default "All Departments"

		Select m=new Select ( driver.findElement(By.id("searchDropdownBox")));
		if(m.getFirstSelectedOption().getText().equals("All Departments"));
		System.out.println("all departments is defult selected");
		
	
	//select department Home & Kitchen, and search coffee mug.
		System.out.println("Titel is : " +driver.getTitle());
   	   m.selectByVisibleText("Home & Kitchen");
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug" +Keys.ENTER);
//	   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[text()='\"coffee mug\"]'")));
	  Thread.sleep(1000);
	 //verify you are on coffee mug search results page (use title).
	   String Expected="Coffee mug";
	   String actual =driver.getTitle();
	   
	   
	   if (actual.contains(Expected))
	   {
		   System.out.println("PASS");
	   }
	   
	   
	   
	 //verify you are in Home & Kitchen department.
		   
	Select letsSelects = new Select(driver.findElement(By.id("searchDropdownBox")));
		
    if(letsSelects.getFirstSelectedOption().getText().equals("Home & Kitchen"))
      {
	System.out.println("match");}
    
    
    
    //another way for test case2 :
    
    /*public static void amazonSelectHw() throws InterruptedException {
		//Test case 2
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	     //go to amazon.com
		driver.get("https://amazon.com");
		
	     //verify that you are on the amazon home page. (verify with title). 
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		if (driver.getTitle().equals(expectedTitle)) {
			System.out.println("Title is good.");
		}else {
			System.out.println("Title is NOT good.");
		}
		
		
	     //verify dropdown value is by default "All Departments"
		Select letsSelect = new Select(driver.findElement(By.id("searchDropdownBox")));
		if (letsSelect.getFirstSelectedOption().getText().equals("All Departments")) {
			System.out.println("All department is the defalt selected option.");
		}else {
			System.out.println("All department is Not the defalt selected option.");
		}
		
		
		
	     //select department Home & Kitchen, and search coffee mug.
		letsSelect.selectByVisibleText("Home & Kitchen");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug" + Keys.ENTER);
		Thread.sleep(1000);
		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Results']")));
		
	     //verify you are on coffee mug search results page (use title).
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Coffee mug")) {
			
			System.out.println("Title is verified");
		}else {
			System.out.println("Title is NOT verified");
		}
		Select letsSelects = new Select(driver.findElement(By.id("searchDropdownBox")));
		
		
	     //verify you are in Home & Kitchen department.
		if (letsSelects.getFirstSelectedOption().getText().equals("Home & Kitchen")) {
			System.out.println("Home and Kitcken is selected");
		}else {
			System.out.println("Home and Kitcken is NOT selected");
		}
	}
	
	*/
	}
	
	
	
	
	public static void TestCase3()
	{
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Test case 3
		//go to https://demoqa.com/alerts
		driver.get("https://demoqa.com/alerts");
		
		//Click on the third 'Click me' button
		driver.findElement(By.id("confirmButton")).click();
		
        //and get the text of it, Then verify if the text equals to 
		//"Do you confirm action?",  if true, dismiss the Alert, 
		
		Alert alert=driver.switchTo().alert();
		String Alert_content=alert.getText();
		
		if(Alert_content.equals("Do you confirm action?"))
		{alert.dismiss();}
		
	  //then verify You selected Cancel" text displayed.
		WebElement check=driver.findElement(By.id("confirmResult"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(check));
		String s=check.getText();
		if (s.contains("You selected Cancel"))
			
		{System.out.println("YOU DID ALL THINGS RIGHT");}
		else
		{System.out.println("we have an error");}
		
		}
		
	
	
	
	
		
		public static void TestCase4()
		{
			WebDriver driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//Test case 4
			//go to https://demoqa.com/alerts 
			driver.get("https://demoqa.com/alerts ");
			
			//Click on the 'Prompt Alert' button and type PrimeTech. Then accept the Alert.
			driver.findElement(By.id("promtButton")).click();
			Alert a=driver.switchTo().alert();
			a.sendKeys("PrimeTech");
			a.accept();
			
			
			// Verify that "You entered PrimeTech" text displays.
			WebElement d=driver.findElement(By.id("promptResult"));
			if(d.isDisplayed())
			{System.out.println("Yes thats true");}
				
		}
		
		}
		
				
		
		
			
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

