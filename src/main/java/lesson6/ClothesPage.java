package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClothesPage extends BaseView {

    public ClothesPage(WebDriver driver) {
        super(driver);
    }

    private final static String goodButtonXpathLocator = "(//span[contains(text(),'ВЫБРАТЬ')])[1]";
    @FindBy(xpath = goodButtonXpathLocator)
    private WebElement goodButton;

    public GoodPage clickgoodButton() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(goodButtonXpathLocator)));
        goodButton.click();
        return new GoodPage(driver);
    }

    public MenuBlock menuBlock;
}
