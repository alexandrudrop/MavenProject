package curs23;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class AlertJsExample extends BaseTest{
	
	@Test(priority=1)
	 public void simpleJsAlert() throws InterruptedException {
		
		driver.navigate().to("https://keybooks.ro/events_calendar/");

		driver.findElement(By.cssSelector("div[id='simpleBtn']>button")).click();
		Thread.sleep(3000);
		
		//driver.switchTo().alert().accept();
		
		Alert alertaJs = driver.switchTo().alert();
		alertaJs.accept(); //accept() --> da click pe butonul OK din alerta
		
		WebElement resultText = driver.findElement(By.id("demo"));
		assertEquals(resultText.getText(), "You did it.....!");
	}
	
	@Test(priority=2)
	public void confirmJSAlert() throws InterruptedException {
		
		driver.navigate().to("https://keybooks.ro/events_calendar/");

		driver.findElement(By.cssSelector("div[id='confirmBtn']>button")).click();
		Thread.sleep(3000);
		
		//driver.switchTo().alert().accept();
		
		Alert alertaJs = driver.switchTo().alert();
		System.out.println(alertaJs.getText());
		alertaJs.dismiss(); //accept() --> da click pe butonul cancel din alerta
		
		WebElement resultText = driver.findElement(By.id("demo"));
		assertEquals(resultText.getText(), "You pressed Cancel!");
	}
	
	@Test(priority=3)
	public void promptJSAlert() throws InterruptedException {
		
		driver.navigate().to("https://keybooks.ro/events_calendar/");

		driver.findElement(By.cssSelector("div[id='promptBtn']>button")).click();
		Thread.sleep(3000);
		
		//driver.switchTo().alert().accept();
		
		Alert alertaJs = driver.switchTo().alert();
		System.out.println(alertaJs.getText());
		
		alertaJs.sendKeys("Harry Potter"); //scrie in interiorul ei si da accept
		alertaJs.accept(); 
		
		WebElement resultText = driver.findElement(By.id("demo"));
		assertEquals(resultText.getText(), "Hello Harry Potter! How are you today?");
	}
}
