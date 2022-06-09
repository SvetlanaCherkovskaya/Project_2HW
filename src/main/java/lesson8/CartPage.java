package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static lesson8.GoodPage.getGoodName;


public class CartPage {

    private SelenideElement cleanCartButton = $(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]"));


    private SelenideElement good = $(By.xpath("//td/div[contains(@class,'title')]/a/span"));


    public CartPage cleanCart() {
        if ($$(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).size() > 0) {
            cleanCartButton.click();
        }
        return page(CartPage.class);
    }

    @Step("Проверяем наличие товара в корзине")
    public void checkAddToCart() throws InterruptedException {
        switchTo().frame(MenuBlock.cartiframe);
  good.shouldHave(Condition.text(getGoodName().substring(0, 10)));

    }

    public MenuBlock menuBlock;

}
