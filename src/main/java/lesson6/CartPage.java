package lesson6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson6.GoodPage.getGoodName;
import static org.openqa.selenium.By.xpath;

public class CartPage extends BaseView {
    public CartPage(WebDriver driver) {
        super(driver);
        menuBlock = new MenuBlock(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'cart__bottom-info__buttons-clean')]")
    private WebElement cleanCartButton;

    @FindBy(xpath = "//td/div[contains(@class,'title')]/a/span")
    private WebElement good;

    public CartPage cleanCart() {
        if (driver.findElements(xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).size() > 0) {
            cleanCartButton.click();
        }
        return this;
    }

    @Step("Проверяем наличие товара в корзине")
    public void checkAddToCart() throws InterruptedException {
        driver.switchTo().frame(MenuBlock.cartiframe);
        webDriverWait.until(ExpectedConditions.visibilityOf(good));
        Assertions.assertEquals(driver.findElement(xpath("//td/div[contains(@class,'title')]/a/span")).getText()
                .substring(0, 10), getGoodName().substring(0, 10));
    }

    public MenuBlock menuBlock;
}
