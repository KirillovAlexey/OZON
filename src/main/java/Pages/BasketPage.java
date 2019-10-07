package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-item']")
    List<WebElement> itemBasket;

    @FindBy(xpath = "//div[@class='total-middle m-last']//div[2]//span[@class='total-middle-block-text']")
    WebElement totalPrice;

    @FindBy(xpath = "//span[contains(text(),'Удалить выбранные')]")
    WebElement remove;

    @FindBy(xpath = "//button[@data-test-id=\"checkcart-confirm-modal-confirm-button\"]")
    WebElement confirm;

    int sumItem = 0;

    public void checkCountItems() {
        assertEquals(new ResultPage().strings.size(), itemBasket.size());
    }

    public void checkSumBasket() {
        for (String s : new ResultPage().strings) {
            sumItem += Integer.parseInt(s);
        }
        int priceBasket = Integer.parseInt(totalPrice.getText().replaceAll("\\s|\\W", ""));
        Assert.assertEquals("Суммы не равны", sumItem, priceBasket);
    }

    public void deleteItems() {
        remove.click();
        confirm.click();
    }
}
