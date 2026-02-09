package SauceDemo;




import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class StandardUserTests {

	WebDriver driver = new SafariDriver();
	String TheWebSite = "https://www.saucedemo.com/";
	String inventorypageString="https://www.saucedemo.com/inventory.html";
	 String UserName= "standard_user";
     String PASSWORD = "secret_sauce";
	
@BeforeTest
public void setup(){
	
	driver.get(TheWebSite);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	
}
@Test(priority = 1)
public void loginStandardUser() throws InterruptedException { 
	
	WebElement usernameinput=driver.findElement(By.id("user-name"));
	usernameinput.sendKeys(UserName);
	WebElement passwordinput=driver.findElement(By.id("password"));
	passwordinput.sendKeys(PASSWORD);
	WebElement loginbutton=driver.findElement(By.id("login-button"));
	loginbutton.click();
	
	String currentUrl = driver.getCurrentUrl();
	Assert.assertEquals(currentUrl, inventorypageString);
	Thread.sleep(2000);
	
}

@Test(priority = 2)
public void sortProductsByPriceLowToHigh() throws InterruptedException {
	
	WebElement sortDropdown=driver.findElement(By.className("product_sort_container"));
	Select MySelector=new Select(sortDropdown );
	MySelector.selectByValue("lohi");
	Thread.sleep(2000);
	
    List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));

    
    double prev = 0.0;
    for (WebElement price : prices) {
        double current = Double.parseDouble(price.getText().replace("$", ""));
        Assert.assertTrue(current >= prev, "Products not sorted correctly!");
        prev = current;
    }
           
}


@Test(priority = 3)
public void addRandomItemsToCart() throws InterruptedException {
	Random rand=new Random();
	List <WebElement> AddToCartButtons=driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
	int randomItem1 = rand.nextInt(AddToCartButtons.size());

	
	int randomItem2 = rand.nextInt(AddToCartButtons.size());
	if (randomItem2 == randomItem1) {
	    randomItem2 = (randomItem2 + 1) % AddToCartButtons.size();
	}

	AddToCartButtons.get(randomItem1).click();
	AddToCartButtons.get(randomItem2).click();
	Thread.sleep(2000);

	WebElement cartBadge=driver.findElement(By.className("shopping_cart_badge"));
	Assert.assertEquals(cartBadge.getText(),"2" );

}
@Test(priority = 4)

public void removeItemFromCart() throws InterruptedException {
	driver.navigate().to("https://www.saucedemo.com/cart.html");
	 Thread.sleep(1000);
	List <WebElement> removeButtons=driver.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
	removeButtons.get(0).click();
	
	WebElement cartBadge=driver.findElement(By.className("shopping_cart_badge"));
	Assert.assertEquals(cartBadge.getText(),"1" );
	 
}
@Test(priority = 5)
public void checkoutWithValidInformationt() throws InterruptedException {
	WebElement checkoutButton=driver.findElement(By.id("checkout"));
	checkoutButton.click();
	
	String firstName="Ali";
	String lastName="Salem";
	int PostalCode=1234;
	
	WebElement firstNameinput=driver.findElement(By.id("first-name"));
	firstNameinput.sendKeys(firstName);
	
	WebElement lastNameinput=driver.findElement(By.id("last-name"));
   lastNameinput.sendKeys(lastName);
	
	WebElement postalCodeinput=driver.findElement(By.id("postal-code"));
	postalCodeinput.sendKeys(Integer.toString(PostalCode));
	
	WebElement continueCheckOutButton=driver.findElement(By.id("continue"));
	continueCheckOutButton.click();
	
	Thread.sleep(1000);
	WebElement finishCheckOutButton=driver.findElement(By.id("finish"));
	finishCheckOutButton.click();
	Thread.sleep(1000);
 boolean actualValueforCheckout=driver.getPageSource().contains("Thank you for your order!");
	Assert.assertEquals(actualValueforCheckout, true);
	WebElement BackToProductButton=driver.findElement(By.id("back-to-products"));
	BackToProductButton.click();
	

}

@Test(priority = 6)
public void Logout() throws InterruptedException {
	WebElement BurgerMenue=driver.findElement(By.id("react-burger-menu-btn"));
	BurgerMenue.click();
	Thread.sleep(1000);
	WebElement logout=driver.findElement(By.id("logout_sidebar_link"));
	logout.click();
	Thread.sleep(1000);
}

@Test(priority = 7)
public void loginWithInvalidPassword() throws InterruptedException {
	
	WebElement usernameinput=driver.findElement(By.id("user-name"));
	usernameinput.sendKeys(UserName);
	WebElement passwordinput=driver.findElement(By.id("password"));
	passwordinput.sendKeys("wrongpassword");
	WebElement loginbutton=driver.findElement(By.id("login-button"));
	loginbutton.click();
	Thread.sleep(1000);
	String currentUrl = driver.getCurrentUrl();
	Assert.assertEquals(currentUrl, inventorypageString);
	
	
	Thread.sleep(2000);
	
	
}

@Test(priority = 8)
public void checkoutWithMissingInformation() throws InterruptedException {

	driver.get("https://www.saucedemo.com/");
	

	WebElement usernameinput=driver.findElement(By.id("user-name"));
	usernameinput.sendKeys(UserName);
	WebElement passwordinput=driver.findElement(By.id("password"));
	passwordinput.sendKeys(PASSWORD);
	WebElement loginbutton=driver.findElement(By.id("login-button"));
	loginbutton.click();

    Thread.sleep(1000);

    
   List<WebElement>  addItemElement=driver.findElements(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
    addItemElement.get(0).click();
   WebElement cart= driver.findElement(By.className("shopping_cart_link"));
   cart.click();

    Thread.sleep(1000);

    
    WebElement checkoutButton=driver.findElement(By.id("checkout"));
    checkoutButton.click();

    
    WebElement continueButton=driver.findElement(By.id("continue"));
    continueButton.click();

    Thread.sleep(1000);

    WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
    Assert.assertTrue(
        errorMessage.getText().contains("First Name is required"),
        "Validation message for missing first name not displayed"
    );
}

@AfterTest
public void AFTER() {
	
	driver.quit();
}


	
	
	
	
	
}
