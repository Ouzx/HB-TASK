package pageFactoryNoLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage {

    Actions actions;
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Drone Yedek Parçaları')]/parent::*/div")
    WebElement filter;

    @FindBy(xpath = "//ul[@id='1']/li")
    WebElement product;

    By addCartButton = By.xpath("//div/button/div[contains(text(),'Sepet')]");

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver = driver;
    }

    public void SetFilter() {
        filter.click();
    }

    void HoverProduct() {
        actions.moveToElement(product).perform();
    }

    void ClickProduct() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(addCartButton)).click();
    }

    public void AddToCart() {
        HoverProduct();
        ClickProduct();
    }

}
