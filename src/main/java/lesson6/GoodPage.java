package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoodPage extends BaseView {
    private static String goodName;

    public static String getGoodName() {
        return goodName;
    }

    public GoodPage(WebDriver driver) {

        super(driver);
        menuBlock = new MenuBlock(driver);
    }

    private final static String nameButtonXpathLocator = "//h1";
    @FindBy(xpath = nameButtonXpathLocator)
    private WebElement nameButton;

    private final static String addToCartButtonXpathLocator = "(//span[contains(text(),'КОРЗИНУ')])[1]";
    @FindBy(xpath = addToCartButtonXpathLocator)
    private WebElement addToCartButton;

    @Step("Запоминаем название товара")
    public GoodPage rememberGoodName() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nameButtonXpathLocator)));
        goodName = driver.findElement(By.xpath("//h1")).getText();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public GoodPage addToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addToCartButtonXpathLocator)));
        addToCartButton.click();
        return this;
    }

    public MenuBlock menuBlock;

}
