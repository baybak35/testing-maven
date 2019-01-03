package com.cybertek;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


	public class sauceTest {
	
		//3 codes needed to connect SauceLabs
		
		public static final String USERNAME = "baybak355";
	    public static final String ACCESS_KEY = "8e1a3d82-ffa4-44c4-8a98-e2f5bb664bb5";
	    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
		
		@Test
		public void login() throws MalformedURLException {
			
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 7");
			caps.setCapability("version", "66.0");
			
			  RemoteWebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		        driver.get("https://www.cnn.com");
		        System.out.println(driver.getTitle());
		        driver.close();
		        driver.quit();
	}
	
}
