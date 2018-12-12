package pomdesign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.WebOrderLoginPage;

public class WebOrderTest {

	WebDriver driver;
	WebOrderLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	String userId = "Tester";
	String pass = "test";
	
	

	  @BeforeTest
	  public void setUp() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	  }
	  
	  @AfterTest
	  public void closeUp() {
	    driver.quit();
	  }
	  
	  @Test
	  public void loginUsingPOM2() {
		
		loginPage = new WebOrderLoginPage(driver);
	    allOrdersPage = new AllOrdersPage(driver);
	    
	    Assert.assertEquals(driver.getTitle(), "Web Orders Login" + 
	    		"");
	    
	    loginPage.username.sendKeys(userId);
	    loginPage.password.sendKeys(pass);
	    loginPage.loginButton.click();
	    
	    Assert.assertEquals(allOrdersPage.webOrders.getText(),"Web Orders");
	    Assert.assertEquals(allOrdersPage.listOf.getText(),"List of All Orders");
	    Assert.assertEquals(allOrdersPage.welcome.getText(),"Welcome, Tester! | Logout");
	    Assert.assertEquals(allOrdersPage.orders.getText(),"View all orders");
	    Assert.assertEquals(allOrdersPage.products.getText(),"View all products");
	    Assert.assertEquals(allOrdersPage.order.getText(),"Order");
	    
	   

	    
	  }
	  
	  
	  
	
}
