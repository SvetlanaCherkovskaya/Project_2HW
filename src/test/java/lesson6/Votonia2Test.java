package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Votonia2Test {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    private final static String VotoniaSrartURL = "https://www.votonia.ru/";

    @BeforeEach
    void registerDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver(chromeOptions));
        WebDriverManager.chromedriver();
    }

    @Test
    @Feature("Работа с корзиной")
    @Story("Добавление товара в козину")
    void addGoodToCartTest() throws InterruptedException {
        driver.get(VotoniaSrartURL);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        new MainPage(driver)
                .menuBlock
                .clickCart()
                .cleanCart()
                .menuBlock
                .clickClothes()
                .clickgoodButton()
                .rememberGoodName()
                .addToCart()
                .menuBlock
                .clickCart()
                .checkAddToCart();
    }

    @Test
    @Feature("Работа с корзиной 2")
    @Story("Добавление товара в козину")
    void addGoodToCartTest2() throws InterruptedException {
        driver.get(VotoniaSrartURL);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        new MainPage(driver)
                .menuBlock
                .clickCart()
                .cleanCart()
                .menuBlock
                .clickClothes()
                .clickgoodButton()
                .rememberGoodName()
                .addToCart()
                .menuBlock
                .clickCart()
                .checkAddToCart();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
