package Pages;

import Steps.BaseStep;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    WebDriver driver = BaseStep.getDriver();
    @FindBy(xpath = "//input[@class='search-input']")
    public WebElement searchFill;
    @FindBy(xpath = "//div[@class='search-button-wrap']")
    WebElement searchButton;

    public void findProduct(String text) {
        searchFill.sendKeys(text);
        searchFill.sendKeys(Keys.ENTER);
    }
}
