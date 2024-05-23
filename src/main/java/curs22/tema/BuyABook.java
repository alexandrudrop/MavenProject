package curs22.tema;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
		
        WebElement loadMore = driver.findElement(By.id("viewmore_link")); 

        while(loadMore.isDisplayed()) {  
        	Thread.sleep(2000);
        	Actions action = new Actions(driver);
        	action.scrollToElement(loadMore).perform();
        	loadMore.click();
        	try{
        		WebElement theStoryAboutMeBook = driver.findElement(By.cssSelector("article>h4>a[href*='the-story-about-me/']"));
        		action.scrollToElement(theStoryAboutMeBook).perform();
        		break;
        		}catch (NoSuchElementException e){
        			
        		}
        	}
        
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("article>h4>a[href*='the-story-about-me/']")).click();
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
