package com.icinbank;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;


public class Profiledisplay {
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
	
	
	@Test(priority = 2)
	public void profileview() throws InterruptedException {
		driver.findElement(By.id("me")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("profile")).click();
		Thread.sleep(6000);
		System.out.println("profile view.....successful");
	}
	
	
	@Test(priority = 3)
	public void logoutTest() throws InterruptedException {
		driver.findElement(By.id("me")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout")).click();
		Thread.sleep(6000);
		System.out.println("profile view.....successful");
		
		String actualUrl="http://localhost:8080/index?logout";
		  String expectedUrl= driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl))
		     {
		    	 System.out.println("logout successfull");
		     }
		     else
		     {
		         System.out.println("logout failed");
		     
		     }
		  Thread.sleep(3000);
		  
	}
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
