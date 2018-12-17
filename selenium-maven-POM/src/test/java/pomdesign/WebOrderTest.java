package pomdesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.ProductsPage;
import pages.WebOrderLoginPage;

public class WebOrderTest {

	WebDriver driver;
	WebOrderLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ProductsPage productsPage;
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
	  
	  @Ignore
	  @Test
	  public void loginUsingPOM2() {
		
		loginPage = new WebOrderLoginPage(driver);
	    allOrdersPage = new AllOrdersPage(driver);
	    
	    Assert.assertEquals(driver.getTitle(), "Web Orders Login");
	    
	    loginPage.username.sendKeys(userId);
	    loginPage.password.sendKeys(pass);
	    loginPage.loginButton.click();
	    
	    Assert.assertEquals(allOrdersPage.webOrders.getText(),"Web Orders");
	    Assert.assertEquals(allOrdersPage.listOf.getText(),"List of All Orders");
	    Assert.assertEquals(allOrdersPage.welcome.getText(),"Welcome, Tester! | Logout");
	    Assert.assertEquals(allOrdersPage.orders.getText(),"View all orders");
	    Assert.assertEquals(allOrdersPage.products.getText(),"View all products");
	    Assert.assertEquals(allOrdersPage.order.getText(),"Order");
	    
	    allOrdersPage.logout();
 
	  }
	 
	  @Test
	  public void ProductsTest() {
		
		loginPage = new WebOrderLoginPage(driver);
	    allOrdersPage = new AllOrdersPage(driver);
	    productsPage = new ProductsPage(driver);
	    Assert.assertEquals(driver.getTitle(), "Web Orders Login");
	    
	    loginPage.username.sendKeys(userId);
	    loginPage.password.sendKeys(pass);
	    loginPage.loginButton.click();
	    
	    allOrdersPage.products.click();
	    
	    List <String> expectedProducts = Arrays.asList("MyMoney","FamilyAlbum","ScreenSaver");
	    List <String> actProducts = new ArrayList<String>();
	    
	    Assert.assertEquals(actProducts, expectedProducts);

	    for(WebElement prod: productsPage.productNames) {
	    	actProducts.add(prod.getText());
	    }
	    
	    Assert.assertEquals(actProducts, expectedProducts);
	    
	    for(WebElement row: productsPage.productsRow) {
	    	String[] prodData = row.getText().split(" ");
	    	
	    	switch (prodData[0]) {
	    	case "MyMoney":
	    		Assert.assertEquals(prodData[1], "$100");
	    		Assert.assertEquals(prodData[2], "8%");
	    	case "FamilyAlbum":
	    		Assert.assertEquals(prodData[1], "$80");
	    		Assert.assertEquals(prodData[2], "15%");
	    	case "ScreenServer":
	    		Assert.assertEquals(prodData[1], "$20");
	    		Assert.assertEquals(prodData[2], "10%");
	    	}
	    }
	    
	   
	    
	  
	  
	  
	  
	  
	  
	  }	  
	
}
























