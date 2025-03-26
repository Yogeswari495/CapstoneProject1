package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Applying_discount_couponsPageFactory {
	WebDriver driver;

	// constructor
	public Applying_discount_couponsPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// mandatory
	}

	// locators
	@FindBy(css = "a[href='/gift-cards']")
	WebElement giftcardlink;
	@FindBy(id = "products-orderby")
	WebElement product_order;
	@FindBy(id = "products-viewmode")
	WebElement product_view;
	@FindBy(id = "products-pagesize")
	WebElement product_page_size;
	@FindBy(xpath = "//a[.='$25 Virtual Gift Card']")
	WebElement giftcard;
	@FindBy(id = "giftcard_2_RecipientName")
	WebElement ReceiptName;
	@FindBy(className = "recipient-email")
	WebElement Receiptemail;
	@FindBy(xpath="//input[@id='giftcard_2_SenderName']")
	WebElement senderName;
	@FindBy(id = "giftcard_2_SenderEmail")
	WebElement email;
	@FindBy(className = "message")
	WebElement message;
	@FindBy(id = "add-to-cart-button-2")
	WebElement cart;
	@FindBy(xpath = "//span[.='Shopping cart']")
	WebElement ShoppingCart_Link;
	@FindBy(xpath = "//input[@name='discountcouponcode']")
	WebElement coupon;
	@FindBy(name = "applydiscountcouponcode")
	WebElement coupon_click;

	public void giftcard() {
		giftcardlink.click();
	}

	public void order() {
		product_order.sendKeys(Keys.ARROW_DOWN,"Name:A-Z",Keys.ENTER);
	}

	public void view() {
		product_view.sendKeys(Keys.ARROW_DOWN,"List",Keys.ENTER);
	}

	public void size() {
		product_page_size.sendKeys(Keys.ARROW_DOWN, "4", Keys.ENTER);
	}

	public void selectgiftcard() {
		giftcard.click();
	}
	public void rec_name() {
		ReceiptName.sendKeys("Yogeswari");
	}

	public void rec_email() {
		Receiptemail.sendKeys("Yogeswari1234@gmail.com");
	}

	public void sender_name() {
		senderName.sendKeys("jyothsna");
	}

	public void sender_email() {
		email.sendKeys("Jyothsna123@gmail.com");
	}
	public void message() {
		message.sendKeys("All the best");
	}
	public void addtocart() {
		cart.click();
	}
	public void shoping_links() {
		ShoppingCart_Link.click();
	}
	public void  entercoupons() {
		coupon.sendKeys("123ADC67");
	}
	public void click_coupon() {
		coupon_click.click();
	}
}
