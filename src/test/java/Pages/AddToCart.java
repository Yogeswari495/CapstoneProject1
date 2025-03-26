package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCart {
     WebDriver driver;
	 public AddToCart(WebDriver driver) {
		this.driver=driver;
	}
	//locators
	By link=By.cssSelector("a[href='/gift-cards']");
	By Positions =By.id("products-orderby");
	By Grid =By.id("products-viewmode");
	By view =By.id("products-pagesize");
	By Giftcard =By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[3]");
	By name=By.name("giftcard_2.RecipientName");
	By email=By.name("giftcard_2.RecipientEmail");
	By sendername=By.name("giftcard_2.SenderName");
	By  senderemail=By.id("giftcard_2_SenderEmail");
	By Message=By.className("message");
	By AddTocart=By.id("add-to-cart-button-2");
 
//action methods
	public WebElement link() {
		return driver.findElement(link);
	}
	public WebElement Positions () {
		return driver.findElement(Positions);
	}
	public WebElement  Grid() {
		return driver.findElement(Grid);
	}
	public WebElement  view() {
		return driver.findElement(view);
	}
	public WebElement  Giftcard() {
		return driver.findElement(Giftcard);
	}
	public WebElement  name() {
		return driver.findElement(name);
	}
	public WebElement  email() {
		return driver.findElement(email);
	}
	public WebElement  sendername() {
		return driver.findElement(sendername);
}
	public WebElement  senderemail() {
		return driver.findElement(senderemail);
}
	public WebElement  Message() {
		return driver.findElement(Message);
}
	public WebElement  AdToCart() {
		return driver.findElement(AddTocart);
}
}
