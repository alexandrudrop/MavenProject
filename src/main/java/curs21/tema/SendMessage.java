package curs21.tema;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class SendMessage extends BaseTest{
	
	@Test
	public void testSendMessage() throws InterruptedException {
		
		driver.findElement(By.cssSelector("a[href='https://keybooks.ro/contacts/']")).click();
		
		driver.findElement(By.cssSelector("input[type='text'][name='your-name']")).sendKeys("Dumitru Olaru");
		driver.findElement(By.cssSelector("input[type='email'][name='your-email']")).sendKeys("dolaru@gmail.com");
		
		driver.findElement(By.cssSelector("input[type='text'][name='your-s']")).
		sendKeys("Will you bring 'The Witcher' series in your online bookstore?");
		
		driver.findElement(By.cssSelector("textarea[name='your-message']")).
		sendKeys("\n Hello,\n"
				
				+ "\n I was wondering if you plan to bring 'The Witcher' series in your online bookstore"
				+ "as I am a big fan of the series."
				+ "\n I anxiously await your response!\n"
				
				+ "\n Thank you,"
				+ "\n Have a great day,"
				+ "\n Dumitru.");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='submit'][value='Send Message']")).click();
		
		Thread.sleep(500);
		WebElement thankYouMessage = driver.findElement(By.cssSelector("div[class='wpcf7-response-output']"));
	    assertTrue(thankYouMessage.isDisplayed());
		
	}

}
