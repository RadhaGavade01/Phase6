package com.icinbank;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;


public class RequestChequebook {
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
	
	
	@Test(priority = 10)
	public void requestcheque() throws InterruptedException {
		driver.findElement(By.id("request")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkbook")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("description")).sendKeys("test chequebook request");
		Thread.sleep(3000);
		driver.findElement(By.id("submitRequestChequeBook")).click();
		
		Thread.sleep(2000);
		System.out.println("cheque book request... successful");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
