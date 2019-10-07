package Steps;

import Pages.ResultPage;
import io.cucumber.java.ru.Когда;

public class ResultStep extends ResultPage {

    @Когда("Ввести верхнюю границу цены: (.+)")
    public void inputPrice(String text){
        new ResultPage().insertPrice(text);
    }
    @Когда("Добавить в корзину товары")
    public void addBasket(){
        new ResultPage().addToBasket();
    }
    @Когда("Перейти на страницу корзины")
    public void openBasket(){
        new ResultPage().openBasket();
    }
}
