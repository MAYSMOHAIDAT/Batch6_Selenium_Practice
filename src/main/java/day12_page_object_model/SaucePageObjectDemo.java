package day12_page_object_model;

import Utiles.BrowserUtils;
import Utiles.DataReader;
import Utiles.Driver;
import pages.SauceDemoLoginPage;

public class SaucePageObjectDemo {

	public static void main(String[] args) throws InterruptedException {
		SauceLoginDemo();

	}
	
	
	
	
	
	
	public static void SauceLoginDemo() throws InterruptedException {
		
		
		SauceDemoLoginPage loginpage= new SauceDemoLoginPage();
		
		BrowserUtils utils=new BrowserUtils();
		
		
		
		// go to website 
		Driver.getDriver().get(DataReader.getProperty("sauce_url"));
		
		
		// wait for the username field
		utils.waitForElementToBeVisible(loginpage.loginUserName);
		
		// type username 
		utils.highlightElement(loginpage.loginUserName);
		loginpage.loginUserName.sendKeys(DataReader.getProperty("sauce_username"));
		
		
		
	
		
		
		// type password
		loginpage.loginPassword.sendKeys(DataReader.getProperty("sauce_password"));
		
		
		// click signin
		loginpage.LoginBtn.click();
		
		
		Driver.quitDriver();
		
	
		
		
	}

}
