package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Votonia2Test {

    static WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    private final static String VotoniaSrartURL = "https://www.votonia.ru/";

    @BeforeAll
    static void registrDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver();
    }

    @Test
    void addGoodToCartTest() throws InterruptedException{
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

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
