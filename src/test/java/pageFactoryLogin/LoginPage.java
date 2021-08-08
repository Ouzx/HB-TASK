package pageFactoryLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "txtUserName")
	WebElement usernameText;

	@FindBy(id = "txtPassword")
	WebElement passwordText;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login(String username, String password) throws InterruptedException {
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		Thread.sleep(2000);
		loginButton.click();
		Thread.sleep(500);
		if (driver.getPageSource().contains("Beklenmeyen bir hata oluştu."))
			throw new RuntimeException("Hepsiburada did not accept login request.");

	}
}
