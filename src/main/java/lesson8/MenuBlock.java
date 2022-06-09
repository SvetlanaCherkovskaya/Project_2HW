package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MenuBlock {

    private SelenideElement cart = $(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]"));

    private SelenideElement clothes = $(By.xpath("//a[contains(text(),'Одежда')]"));

    public static SelenideElement cartiframe = $(By.id("cartiframe"));

    @Step("Переходим на страницу Корзина")
    public CartPage clickCart() {
        cart.click();
        return page(CartPage.class);
    }

    @Step("Переходим на странцу Одежда")
    public ClothesPage clickClothes() {
        clothes.click();
        return page(ClothesPage.class);
    }

}
