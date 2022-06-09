package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ClothesPage {

    private SelenideElement goodButton = $(By.xpath("(//span[contains(text(),'ВЫБРАТЬ')])[1]"));



    @Step("Переходим на страницу товара")
    public GoodPage clickgoodButton() {
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(goodButtonXpathLocator)));
        goodButton.click();
        return page(GoodPage.class);
    }

    public MenuBlock menuBlock;
}
