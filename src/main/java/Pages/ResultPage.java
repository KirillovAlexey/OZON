package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class ResultPage extends BasePage {


    @FindBy(xpath = "//div[@data-test-id=\"filter-block-price\"]//input[@data-test-id='range-filter-to-input']")
    WebElement price;

    @FindBy(xpath = "//span[contains(text(),'Корзина')]//..")
    WebElement goToBasket;

    static List<String> strings = new LinkedList<>();

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public void insertPrice(String text) {
        price.sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.HOME));
        price.sendKeys(text);
        price.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.attributeToBe(price, "value", "60000"));
    }

    public void addToBasket() {
        wait.until(ExpectedConditions.urlContains("60000"));
        List<WebElement> unitPrice = driver.findElements(By.xpath("//span[@data-test-id='tile-price']"));
        List<WebElement> listPhone = driver.findElements(By.xpath("//button[@data-test-id=\"tile-buy-button\"]"));

        List<WebElement> unit = driver.findElements(By.xpath("//button[@data-test-id=\"tile-buy-button\"]"));
        //price
        ////button[@data-test-id="tile-buy-button"]//..//..//..//span[@data-test-id="tile-price"]

        //clickBuy
        //////button[@data-test-id="tile-buy-button"]

        int count = 1;
        for (int i = 0; i < unit.size(); i++) {
            if (i % 2 == 0 && count <= 8) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                        , unit.get(i));
                wait.until(ExpectedConditions.elementToBeClickable(unit.get(i)));
                //strings.add(unitPrice.get(i).getText().replaceAll("\\s|\\W",""));
                //listPhone.get(i).click();
                strings.add(unit.get(i).findElement(By.xpath("//button[@data-test-id=\"tile-buy-button\"]//..//..//..//span[@data-test-id=\"tile-price\"]"))
                        .getText().replaceAll("\\s|\\W", ""));
                unit.get(i).click();
                count++;
                //wait.until(ExpectedConditions.invisibilityOf(unit.get(i)));
            }
        }
    }

    public void openBasket() {
        goToBasket.click();
    }
}
