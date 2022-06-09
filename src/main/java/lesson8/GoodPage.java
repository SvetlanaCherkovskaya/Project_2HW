package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoodPage {

    private static String goodName;

    public static String getGoodName() {
        return goodName;
    }

    private SelenideElement nameButton = $(By.xpath("//h1"));

    private SelenideElement addToCartButton = $(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]"));

    @Step("Запоминаем название товара")
    public GoodPage rememberGoodName() {
        goodName = $(By.xpath("//h1")).getText();
        return page(GoodPage.class);
    }

    @Step("Добавляем товар в корзину")
    public GoodPage addToCart() {
        addToCartButton.click();
        return page(GoodPage.class);
    }

    public MenuBlock menuBlock;
}
