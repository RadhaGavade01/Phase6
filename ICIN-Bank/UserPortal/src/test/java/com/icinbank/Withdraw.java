package com.icinbank;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;


public class Withdraw {
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
	
	
	@Test(priority = 14)
	public void primaryWithdraw() throws InterruptedException {
		driver.findElement(By.id("withdrawin")).click();
		driver.findElement(By.id("accountType")).click();
		driver.findElement(By.id("primarywithdraw")).click();
		driver.findElement(By.name("amount")).sendKeys("130");
		Thread.sleep(3000);
		driver.findElement(By.id("withdrawsubmit")).click();
		Thread.sleep(3000);
		System.out.println("primary account withdraw operation... successful");
		
		driver.findElement(By.id("viewprimary")).click();
		Thread.sleep(6000);
	}
	
	
	
	@Test(priority = 15)
	public void savingsWithdraw() throws InterruptedException {
		driver.findElement(By.id("withdrawin")).click();
		driver.findElement(By.id("accountType")).click();
		driver.findElement(By.id("savingswithdraw")).click();
		driver.findElement(By.name("amount")).sendKeys("130");
		Thread.sleep(3000);
		driver.findElement(By.id("withdrawsubmit")).click();
		Thread.sleep(3000);
		System.out.println("savings account withdraw operation... successful");
		
		driver.findElement(By.id("viewsavings")).click();
		Thread.sleep(6000);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
