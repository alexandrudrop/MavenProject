package curs19.tema;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class IsElementVisible extends BaseTest{
	
	@Test(priority=1)
	public void linkTextLocatorLogin() {
		
		driver.findElement(By.linkText("Login")).click();
		
		WebElement username = driver.findElement(By.id("log"));	
		assertTrue(username.isDisplayed());
		
		WebElement password = driver.findElement(By.id("password"));	
		assertTrue(password.isDisplayed());
	}

}
