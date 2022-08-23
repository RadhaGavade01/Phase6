package com.icinbank;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;
@RunWith(SpringRunner.class)
@Test(priority = 1)
public class RegistrationForm {
	
	public void registrationTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chrome\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("http://localhost:8080/index");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		
		
		 driver.findElement(By.id("register")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.name("firstName")).sendKeys("test");
		 driver.findElement(By.name("lastName")).sendKeys("123");
		 driver.findElement(By.name("phone")).sendKeys("1234567890");
		 driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
		 driver.findElement(By.name("username")).sendKeys("test123");
		 driver.findElement(By.name("password")).sendKeys("test123");
		 driver.findElement(By.id("signup")).click();
		 Thread.sleep(5000);
		  System.out.println("Registration successful");
		  
		  String actualUrl="http://localhost:8080/index";
		  String expectedUrl= driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl))
		     {
		    	 System.out.println("registered");
		     }
		     else
		     {
		         System.out.println("already registered");
		     
		     }
		  
		  driver.close();
	}

}
