package curs23;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class ShadowDomeExample extends BaseTest{
	
	@Test
	public void shadowDomeExample() throws InterruptedException {
		
		driver.navigate().to("https://keybooks.ro/events_calendar/");
		
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("div[class='shadow-element']>button")).click();
		
        WebElement button = driver.findElement(By.cssSelector("div[id='shadow-host']")).getShadowRoot().
        		findElement(By.cssSelector("div[class='shadow-element']>button"));
        button.click();
		
        WebElement bookPictureDay = driver.findElement(By.id("shadow-host")).getShadowRoot().
        		findElement(By.cssSelector("img[src*='www.keybooks.ro_.png']"));
        assertTrue(bookPictureDay.isDisplayed());
	}
}