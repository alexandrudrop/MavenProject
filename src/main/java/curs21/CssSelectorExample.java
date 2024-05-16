package curs21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class CssSelectorExample extends BaseTest{
	
	//@Test
	public void cssSelectorExample() {
		
		/*
		 * Element html <li class="menu_user_login">
		 * 
		 * sintaxa: tagname[atribut = valoare_atribut]
		 * tagname = li
		 * atribut = class
		 * valoare_atribut = menu_user_login
		 * 
		 * css --> li[class='menu_user_login']
		 * 
		 * 
		 * Css selector pt atribut CLASS este .
		 * .menu_user_login e acelasi lucru cu [class="menu_user_login"]
		 * li.menu_user_login e acelasi lucru cu li[class='menu_user_login']
		 * 
		 * Css selector pt atribut ID este #
		 * Ex:2
		 * ul[id="menu_user"]
		 * #menu_user e acelasi lucru cu [id="menu_user"]
		 * ul#menu_user e acelasi lucru cu ul[id="menu_user"]
		 */
	
		
		driver.findElement(By.cssSelector("li[class='menu_user_login']")).click();
		
		//AND
		driver.findElement(By.cssSelector("input[name='log'][placeholder='Login or Email']")).sendKeys("Test");
		
		//OR
		driver.findElement(By.cssSelector("input[type='password'],[name='pwd']")).sendKeys("Test");
		
	}
	
	@Test
	public void cssSelectorExample2() {  //a[href='its-a-really-strangestory']
		
		//* --> contains (valoarea contine)
		//Ex: a[href='its-a-really-strange-story']
		// a[href*='really']
		WebElement book1 = driver.findElement(By.cssSelector("a[href*='really']"));
		System.out.println(book1.getText());
		
		//^ --> starts with
		WebElement book2 = driver.findElement(By.cssSelector("a[href^='life']"));
		System.out.println(book2.getText());
		
		//$ ends with
		WebElement book3 = driver.findElement(By.cssSelector("a[href$='orest']"));
		System.out.println(book3.getText());
		
		//~ --> contains word
		WebElement book4 = driver.findElement(By.cssSelector("a[href~='the-forest']"));
		System.out.println(book4.getText());
	}

}
