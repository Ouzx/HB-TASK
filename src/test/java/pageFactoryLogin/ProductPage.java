package pageFactoryLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class ProductPage {

	WebDriver driver;

	@FindBy(id = "addToCart")
	WebElement addToCart;

	By recommendationButton = By.className("checkoutui-Modal-2iZXl");

	By addDifferent = By.cssSelector(".button.small");

	int prodCounter = 0;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void AddToCart() {
		addToCart.click();
		prodCounter++;
	}

	public void closeRecommendation() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(recommendationButton)).click();
		} catch (TimeoutException e) {
		}

	}

	public void FromDifferentStore() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(addDifferent)).click();
			prodCounter++;
		} catch (TimeoutException e) {
			System.out.println("! There is no different seller for this product.");
		}
	}

	public void CheckCart() {
		if (prodCounter == 0)
			throw new RuntimeException("No products have been added.");
	}

}
