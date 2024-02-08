package Day7_SelectAlertPopups;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class SelectAlertPopups {
	
	public static void main(String[]args) throws InterruptedException
	{
//		SelectDemo();
		chooseOptionFromNonSelectDropdown();
	}





public static void SelectDemo() throws InterruptedException

{
	
	//Select colors:
	WebDriver driv =new ChromeDriver();
	driv.manage().window().maximize();
	driv.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	
	
	driv.get("https://demoqa.com/select-menu");
	
	WebElement colors =driv.findElement(By.id("oldSelectMenu"));
	
	Select m=new Select(colors);
	
	
	Thread.sleep(500);
	
	//select by visible text:
	m.selectByVisibleText("Black");
	
	Thread.sleep(2000);
	
	//select by index:
	m.selectByIndex(4);

	Thread.sleep(1000);
	
	//select by value:
	m.selectByValue("10");
	
	
	//what is default select item in list:
	String defultSelectColors=m.getFirstSelectedOption().getText();
	System.out.println(defultSelectColors);
	
	
	//get all  options:
	List <WebElement> allColors=m.getOptions();
	System.out.println(allColors.size());
	
	for(WebElement color:allColors)
	{
		System.out.println(color.getText());
	}
	
	//get all selected options:
	List<WebElement> allSelectedOptions=m.getAllSelectedOptions();
	
	System.out.println(allSelectedOptions.size());
	
}	




public static void chooseOptionFromNonSelectDropdown() throws InterruptedException

{
	//Select alegeria:
	WebDriver drive= new ChromeDriver();
	drive.manage().window().maximize();
	drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	drive.get("https://semantic-ui.com/modules/dropdown.html");
	
	drive.findElement(By.xpath("(//input[@class='search'])[1]")).click();
	Thread.sleep(1000);
	
	//Anothr xpath:(//div[@class='ui fluid search selection dropdown'])[1]
	drive.findElement(By.xpath("(//div[text()='Algeria'])[1]")).click();
	
	
	}


}