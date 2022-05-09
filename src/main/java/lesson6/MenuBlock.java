package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuBlock extends BaseView {
    public MenuBlock(WebDriver driver) {
        super(driver);
    }

    private final static String cartXpathLocator = "//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]";
    @FindBy(xpath = cartXpathLocator)
    public WebElement cart;

    private final static String clothesXpathLocator = "//a[contains(text(),'Одежда')]";
    @FindBy(xpath = clothesXpathLocator)
    private WebElement clothes;

    @FindBy(id = "cartiframe")
    public static WebElement cartiframe;

    @Step("Переходим на страницу Корзина")
    public CartPage clickCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartXpathLocator)));
        cart.click();
        return new CartPage(driver);
    }

    @Step("Переходим на странцу Одежда")
    public ClothesPage clickClothes() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clothesXpathLocator)));
        clothes.click();
        return new ClothesPage(driver);
    }
}
