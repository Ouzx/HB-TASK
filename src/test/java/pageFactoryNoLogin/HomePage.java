package pageFactoryNoLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Kitap, Müzik, Film, Hobi')]")
	private WebElement category;

	private By subCategory = By.xpath("//span[contains(text(),'Uzaktan')]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void SelectCategory() {
		category.click();
	}

	public void SelectSubCategory() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(subCategory)).click();
	}
}
