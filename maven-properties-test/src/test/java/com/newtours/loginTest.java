package com.newtours;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
	
	final String file = "/Users/batuhanaybak/Desktop/HTML_JS_DOM/Selenium/testing-maven/maven-properties-test/src/test/resources/config.properties";
	WebDriver driver=null;
	Properties prop;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream(file);
		prop.load(ip);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void closeUp() {
		driver.quit();
	}
	
	@Test
	public void login() {
		driver.findElement(By.name("userName")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		
	}
	
	
}




























