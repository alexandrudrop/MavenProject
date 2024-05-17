package curs22;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class CssSelectorExample extends BaseTest{
	
	//@Test
	public void cssExample1() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//direct child
		driver.findElement(By.cssSelector("li[class='menu_user_login']>a[href='#popup_login']")).click();
		
		//descendant -> intre elementul parinte si elementul descendant punem un caracter spatiu
		WebElement username = driver.findElement(By.cssSelector("ul[id='menu_user'] input[name='log']"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				username);
		
		WebElement pass = driver.findElement(By.cssSelector("ul#menu_user form.login_form>div>input[name='pwd']"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				pass);
		
		//NOT
		WebElement submitButton = driver.findElement(By.cssSelector("ul form[name='login_form'] input:not([type='text'],"
				+ "[type='password'],[type='hidden'],[type='checkbox'])"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				submitButton);
	}
	
	//@Test
	public void cssExample2() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//first-of-type
		WebElement newReleaseMenu = driver.findElement(By.cssSelector("ul[class*='sc_tabs_titles']>li:first-of-type"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				newReleaseMenu);
		
		//nth-of-type
		WebElement commingSoonMenu = driver.findElement(By.cssSelector("ul[class*='sc_tabs_titles']>li:nth-of-type(2)"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				commingSoonMenu);
		
		WebElement bestSellersMenu = driver.findElement(By.cssSelector("ul[class*='sc_tabs_titles']>li:nth-of-type(3)"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				bestSellersMenu);
		
		//last-of-type
		WebElement awardWinnersMenu = driver.findElement(By.cssSelector("ul[class*='sc_tabs_titles']>li:last-of-type"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				awardWinnersMenu);
	}
	
	
	@Test
	public void cssExample3() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.findElement(By.cssSelector("div[class='menu_main_wrap'] a[href*='shop/']")).click();
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 1200).perform();
		
		//first-child
		WebElement category1 = driver.findElement(By.cssSelector("ul[class='product-categories']>li:first-child"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				category1);
		
		//last-child
		WebElement category11 = driver.findElement(By.cssSelector("ul[class='product-categories']>li:last-child"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				category11);
		
		//nth-child
		WebElement category4 = driver.findElement(By.cssSelector("ul[class='product-categories']>li:nth-child(4)"));
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow ;border:10px solid green')", 
				category4);
		
		//selectez din n in n (n=ce nr vreau eu)
		//--> ul[class='product-categories']>li:nth-child(3n)
		
		
		//selectez din n in n pornind de la un anumit nr (in ex. de mai jos pornesc cu 
		//numaratoarea de la elementul nr 5 si selectez din 3 in 3)
		//-->ul[class='product-categories']>li:nth-child(3n+5)
		
		for(int i =0; i<10; i++) {
			
			driver.findElement(By.cssSelector("ul[class='product-categories']>li:nth-child(3n"+i+")"));
			driver.findElement(By.cssSelector("ul[class='product-categories']>li:nth-child("+i+"n"+i+")"));
		}
	}
}
