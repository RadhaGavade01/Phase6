package com.icinbank;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;


public class TransferbtwAccounts {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.navigate().to("http://localhost:8080/index");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("username")).sendKeys("test123");
		 driver.findElement(By.name("password")).sendKeys("test123");
		 driver.findElement(By.id("login")).click();
		 Thread.sleep(3000);
		 
	}
	
	
	@Test(priority = 8)
	public void primaryTOsavings() throws InterruptedException {
		driver.findElement(By.id("transfer")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btwaccounts")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("transferFrom")).click();
		driver.findElement(By.id("primarytransfer")).click();
		driver.findElement(By.name("amount")).sendKeys("55");
		Thread.sleep(2000);
		driver.findElement(By.id("trnsfersubmit")).click();
		System.out.println("money transfer from primary to savings.......successful");
		driver.findElement(By.id("viewsavings")).click();
		Thread.sleep(6000);
	}
	
	
	@Test(priority = 9)
	public void savingsTOprimary() throws InterruptedException {
		driver.findElement(By.id("transfer")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btwaccounts")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("transferFrom")).click();
		driver.findElement(By.id("savingstransfer")).click();
		driver.findElement(By.name("amount")).sendKeys("100");
		Thread.sleep(2000);
		driver.findElement(By.id("trnsfersubmit")).click();
		System.out.println("money transfer from savings to primary.......successful");
		driver.findElement(By.id("viewprimary")).click();
		Thread.sleep(6000);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
