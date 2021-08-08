package pageFactoryLogin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(className = "product")
	List<WebElement> products;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void CheckProducts() {
		// if ile prdocts listesini size() ile kontrol etmem gerekiyor.
		// Ancak testin devam etmemesi icin kontrole almiyorum.
		products.get(0).click();

	}
}
