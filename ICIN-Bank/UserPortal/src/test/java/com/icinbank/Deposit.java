package com.icinbank;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.event.annotation.AfterTestMethod;


public class Deposit {
	WebDriver driver;
	
	
	@Before
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
	
	
	@Test(timeout = 4)
	public void primaryDeposit() throws InterruptedException {
		driver.findElement(By.id("depositin")).click();
		driver.findElement(By.id("accountType")).click();
		driver.findElement(By.id("primarydeposit")).click();
		driver.findElement(By.name("amount")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.id("depositsubmit")).click();
		Thread.sleep(3000);
		System.out.println("primary account deposit operation... successful");
		
		driver.findElement(By.id("viewprimary")).click();
		Thread.sleep(6000);
	}
	
	
	@Test(timeout = 5)
	public void savingsDeposit() throws InterruptedException {
		driver.findElement(By.id("depositin")).click();
		driver.findElement(By.id("accountType")).click();
		driver.findElement(By.id("savingsdeposit")).click();
		driver.findElement(By.name("amount")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.id("depositsubmit")).click();
		Thread.sleep(3000);
		System.out.println("savings account deposit operation... successful");
		
		driver.findElement(By.id("viewsavings")).click();
		Thread.sleep(6000);
	}
	
	
	
	@AfterTestMethod
	public void tearDown() {
		driver.close();
	}

}
