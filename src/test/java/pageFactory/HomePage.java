package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	@FindBy(id = "myAccount")
	private WebElement myAccountButton;

	private By loginButton = By.id("login");
	private By searchBox = By.className("desktopOldAutosuggestTheme-input");

	public HomePage(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);
	}
	
	public void GetLoginPage(){
		myAccountButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
	}
	
	public void CheckDriverWhereIs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
	}
	
	public void Search(String prod) throws InterruptedException {
		driver.findElement(searchBox).sendKeys(prod);
		Thread.sleep(1000);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
}
