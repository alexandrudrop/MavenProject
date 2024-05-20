package curs22.tema;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class BuyABook extends BaseTest{
	
	@Test(priority=1)
	public void buyABook() throws InterruptedException {
		
		driver.findElement(By.cssSelector("button[type='submit'][class*='search_submit']")).click();
		
		driver.findElement(By.cssSelector("input[type='text'][class='search_field']")).sendKeys("the story about me");
		Thread.sleep(700);
		driver.findElement(By.cssSelector("a[class*='post_more']")).click();
		
		driver.findElement(By.id("viewmore_link")).click();
		Thread.sleep(700);
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1200).perform();
		
		driver.findElement(By.id("viewmore_link")).click();
		Thread.sleep(1000);
		
		Actions action2 = new Actions(driver);
		action2.scrollByAmount(0, 900).perform();
		
		driver.findElement(By.cssSelector("a[href='https://keybooks.ro/shop/the-story-about-me/']")).click();
		driver.getCurrentUrl();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/"); 
		
		driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();
        WebElement addedToCartMessage = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(addedToCartMessage.isDisplayed());
		
		driver.findElement(By.cssSelector("div[class*='woocommerce-message']>a[href='https://keybooks.ro/cart/']")).click();
		driver.getCurrentUrl();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/"); 
	}
	
	@Test(priority=2)
	public void cart() throws InterruptedException {
		
		driver.findElement(By.cssSelector("span[class='q_inc']")).click();
		
		driver.findElement(By.cssSelector("button[name='update_cart']")).click();
		Thread.sleep(1000);
	    WebElement cartUpdatedMessage = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(cartUpdatedMessage.isDisplayed());
		
		driver.findElement(By.cssSelector("a[href='https://keybooks.ro/checkout/']")).click();
		driver.getCurrentUrl();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		WebElement billingDetailsText = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields'] h3"));
		assertTrue(billingDetailsText.isDisplayed());
		
		WebElement additionalInformationText = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields'] h3"));
		assertTrue(additionalInformationText.isDisplayed());
	}
}
