package com.icinbank;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.*;

@RunWith(SpringRunner.class)
public class LoginForm {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chrome\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.navigate().to("http://localhost:8080/index");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	
	@Test
	public void loginTest() throws InterruptedException {
		 driver.findElement(By.name("username")).sendKeys("test123");
		 driver.findElement(By.name("password")).sendKeys("test123");
		 driver.findElement(By.id("login")).click();
		 
		  String actualUrl="http://localhost:8080/ICINBank";
		  String expectedUrl= driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl))
		     {
		    	 System.out.println("login successfull");
		     }
		     else
		     {
		         System.out.println("login failed");
		     
		     }
		  Thread.sleep(3000);
		  
	}
	
	
	@Test
	public void invalidLoginTest() throws InterruptedException {
		 driver.findElement(By.name("username")).sendKeys("test123");
		 driver.findElement(By.name("password")).sendKeys("errortest123");
		 driver.findElement(By.id("login")).click();
		 
		  String actualUrl="http://localhost:8080/ICINBank";
		  String expectedUrl= driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl))
		     {
		    	 System.out.println("login successfull");
		     }
		     else
		     {
		         System.out.println("login failed...please check the username and password");
		     
		     }
		  Thread.sleep(3000);
		  
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
