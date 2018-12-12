package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllOrdersPage {
	
	public AllOrdersPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	  }
	
	@FindBy(css="tbody h1")
	public WebElement webOrders;
	
	@FindBy(css="tbody h2")
	public WebElement listOf;
	
	@FindBy(css=".login_info")
	public WebElement welcome;
	
	@FindBy(css="tbody li:nth-child(1)")
	public WebElement orders;
	
	@FindBy(css="tbody li:nth-child(2)")
	public WebElement products;
	
	@FindBy(css="tbody li:nth-child(3)")
	public WebElement order;
	
	
	
	
	}
