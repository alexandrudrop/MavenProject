package curs20.tema;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;


public class FindTheBook extends BaseTest{
	
	
	@Test
	public void testFindTheBook() {
		
		List<WebElement> menuElements = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']"));
		
		
        for (int i = 0; i < menuElements.size(); i++) {
            WebElement menuElement = menuElements.get(i);
            menuElement.click();
        }
        
        menuElements.get(0).click();
        WebElement forest = driver.findElement(By.cssSelector("img[src=\"https://keybooks.ro/wp-content/uploads/2016/04/book2.jpg\"]"));
		assertTrue(forest.isDisplayed());
		
        menuElements.get(1).click();
        WebElement forest1 = driver.findElement(By.cssSelector("img[src=\"https://keybooks.ro/wp-content/uploads/2016/04/book2.jpg\"]"));
		assertTrue(forest1.isDisplayed());
		
        menuElements.get(2).click();
        WebElement forest2 = driver.findElement(By.cssSelector("img[src=\"https://keybooks.ro/wp-content/uploads/2016/04/book2.jpg\"]"));
		assertTrue(forest2.isDisplayed());
		
        menuElements.get(3).click();
        WebElement forest3 = driver.findElement(By.cssSelector("img[src=\"https://keybooks.ro/wp-content/uploads/2016/04/book2.jpg\"]"));
		assertTrue(forest3.isDisplayed());
		driver.findElement(By.cssSelector("a[href='the-forest']")).click();
		driver.getCurrentUrl();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/"); 

	}
}
