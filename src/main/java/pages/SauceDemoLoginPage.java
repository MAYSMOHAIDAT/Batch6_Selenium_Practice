package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utiles.Driver;


//how do we create a page class

	// 1. we need a class for a page of the application 
	// 2. we need to create a constructor with page factory of selenium
	// 3. then collect the webElements
public class SauceDemoLoginPage {

public 	SauceDemoLoginPage()
{
	
	
	PageFactory.initElements(Driver.getDriver(), this);
}



//how do we collect webElements?

@FindBy (id = "user-name")
public WebElement loginUserName;



@FindBy (id="password")
public WebElement loginPassword;


@FindBy (xpath = "//input[@id='login-button']")
public WebElement LoginBtn;


@FindBy(css="h3[data-test='error']")
public WebElement LoginEmptyError;






	
}
