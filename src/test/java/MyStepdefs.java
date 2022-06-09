import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;


public class MyStepdefs {
    @Given("Get Votonia")
    public void getURL() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized”);
        //Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    open("http://www.votonia.ru/");

    }

    @And("Scroll to top of page")
    public void scrollToTopOfPage() {
        Selenide.executeJavaScript("window.scrollTo(0, 0);");

    }

    @When("Click to Cart")
    public void clickToCart() {
        new MainPage()
                .menuBlock
                .clickCart();
    }

    @And("Clean Cart")
    public void cleanCart() {
        new CartPage().cleanCart();
    }

    @And("Click to  Clothes")
    public void clickToClothes() {
        new MenuBlock().clickClothes();
    }

    @And("Choose good")
    public void chooseGood() {
        new ClothesPage().clickgoodButton();
    }

    @And("Remember good's name")
    public void rememberGoodSName() {
        new GoodPage().rememberGoodName();
    }

    @And("Add good to Cart")
    public void addGoodToCart() {
        new GoodPage().addToCart();
    }

    @Then("Check good in Cart")
    public void checkGoodInCart() throws InterruptedException {
        new CartPage().checkAddToCart();
    }
}
