package curs19.tema;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class IsElementVisible extends BaseTest{
	
    @Test(priority=1)

    public void linkTextLocatorLogin() {

         WebElement username1 = driver.findElement(By.id("log"));
         WebElement password1 = driver.findElement(By.id("password"));

         assertFalse(username1.isDisplayed());
         assertFalse(password1.isDisplayed());

         driver.findElement(By.linkText("Login")).click();
         
         WebElement username2 = driver.findElement(By.id("log"));
         WebElement password2 = driver.findElement(By.id("password"));

         assertTrue(username2.isDisplayed());
         assertTrue(password2.isDisplayed());

    }
}