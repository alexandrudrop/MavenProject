package curs23.tema;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import selenium.utils.BaseTest;

public class SingleAuthor extends BaseTest{
	
	@Test(priority=1)
	public void navigateToMargaretRobins () {
		
		driver.get("https://keybooks.ro/team/margaret-robins/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
			(By.cssSelector("div[class*='odd first inited'] div[class='sc_skills_total']"), "95%"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
			(By.cssSelector("div[class*='even inited'] div[class='sc_skills_total']"), "75%"));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
			(By.cssSelector("div[class*='odd inited'] div[class='sc_skills_total']"), "82%"));
		}
	
	
	@Test(priority=2)
	public void confirmDramaSkillProcentageValue() {
		
		WebElement dramaProcentage = driver.findElement
				(By.cssSelector("div[class*='odd first inited'] div[class='sc_skills_total']"));
		assertEquals(dramaProcentage.getText(), "95%");
		}
	
		
	@Test(priority=3)
	public void confirmBiographySkillProcentageValue() {
		
		WebElement biographyProcentage = driver.findElement
				(By.cssSelector("div[class*='even inited'] div[class='sc_skills_total']"));
		assertEquals(biographyProcentage.getText(), "75%");
		}
		
	
	@Test(priority=4)
	public void confirmCookbooksSkillProcentageValue() {
		WebElement cookbooksProcentage = driver.findElement
				(By.cssSelector("div[class*='odd inited'] div[class='sc_skills_total']"));
		assertEquals(cookbooksProcentage.getText(), "82%");
		}
}	
