package day11_Framework_driver_utilities;

import org.openqa.selenium.By;

import Utiles.DataReader;
import Utiles.Driver;

public class DriverUtilsDemo {

	public static void main(String[] args) {
		
		sauceDemoTest();
	}
public static void sauceDemoTest() {
		
		// go to saucedemo website 
		Driver.getDriver().get("https://saucedemo.com");
		Driver.getDriver().findElement(By.id("user-name")).sendKeys(DataReader.getProperty("sauce_username"));
		Driver.getDriver().findElement(By.id("password")).sendKeys(DataReader.getProperty("sauce_password"));
		Driver.getDriver().findElement(By.id("login-button")).click();
		
		
		
	}
}
