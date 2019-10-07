package Steps;

import Pages.BasketPage;
import io.cucumber.java.ru.Когда;

public class BasketStep {
    @Когда("Проверка наличия добавленных товаров в корзине")
    public void checkItem() {
        new BasketPage().checkCountItems();
    }

    @Когда("Проверка стоимости корзины с суммой всех добавленных товаров")
    public void checkSum() {
        new BasketPage().checkSumBasket();
    }

    @Когда("Отчистить корзину")
    public void clearBasket() {
        new BasketPage().deleteItems();
    }
}
