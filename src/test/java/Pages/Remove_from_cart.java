package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Remove_from_cart {
	WebDriver driver;

	public Remove_from_cart(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	By link = By.cssSelector("a[href='/gift-cards']");
	By Positions = By.id("products-orderby");
	By Grid = By.id("products-viewmode");
	By view = By.id("products-pagesize");
	By Giftcard = By.xpath("//a[.='$5 Virtual Gift Card']");
	By name = By.id("giftcard_1_RecipientName");
	By email = By.className("recipient-email");
	By sendername = By.className("sender-name");
	By senderemail = By.id("giftcard_1_SenderEmail");
	By Message = By.className("message");
	By AddTocart = By.xpath("//input[@id='add-to-cart-button-1']");
	By shoppingLink = By.xpath("//span[.='Shopping cart']");
	By revome_checkBox = By.xpath("(//input[@name='removefromcart'])[1]");
	By update = By.name("updatecart");


	// action methods
	public WebElement link() {
		return driver.findElement(link);
	}

	public WebElement Positions() {
		return driver.findElement(Positions);
	}

	public WebElement Grid() {
		return driver.findElement(Grid);
	}

	public WebElement view() {
		return driver.findElement(view);
	}

	public WebElement Giftcard() {
		return driver.findElement(Giftcard);
	}

	public WebElement name() {
		return driver.findElement(name);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement sendername() {
		return driver.findElement(sendername);
	}

	public WebElement senderemail() {
		return driver.findElement(senderemail);
	}

	public WebElement Message() {
		return driver.findElement(Message);
	}

	public WebElement AdToCart() {
		return driver.findElement(AddTocart);
	}

	public WebElement shoppingLink() {
		return driver.findElement(shoppingLink);
	}

	public WebElement remove() {
		return driver.findElement(revome_checkBox);
	}

	public WebElement update() {
		return driver.findElement(update);
	}

	
}
