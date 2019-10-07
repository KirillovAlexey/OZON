package Steps;

import Pages.MainPage;
import io.cucumber.java.ru.Когда;

public class MainStep extends MainPage{
    @Когда("Найти указанный товар: (.+)")
    public void findProduct(String text) {
        new MainPage().findProduct(text);
    }
}
