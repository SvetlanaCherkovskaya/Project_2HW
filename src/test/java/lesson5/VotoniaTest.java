package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VotoniaTest {
    static WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String VotoniaSrartURL = "https://www.votonia.ru/";

    @BeforeAll
    static void registrDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver();
        driver.get(VotoniaSrartURL);
    }

    @BeforeEach
    void setupDriver() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test
    void addGoodToCartTest() throws InterruptedException {

        //Очищаем корзину
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'pj_basket')]" + "/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        if (driver.findElements(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).size() > 0) {
            driver.findElement(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).click();
        }
        driver.switchTo().frame(driver.findElement(By.id("cartiframe")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'cart__empty')]")).isDisplayed());

        //Заходим во вкладку Одежда
        driver.switchTo().defaultContent();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Одежда')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Одежда')]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Одежда')]")).isDisplayed());

        //Кидаем товар в корзину
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'ВЫБРАТЬ')])[1]")));
        driver.findElement(By.xpath("(//span[contains(text(),'ВЫБРАТЬ')])[1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]")));
        Assertions.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]")).isDisplayed());
        driver.findElement(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]")).click();

        //Получаем и запоминаем название товара
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
        String goodName = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(goodName);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        //Заходим в корзину
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        //Поверяем лежит ли в Корзине наш товар
        driver.switchTo().frame(driver.findElement(By.id("cartiframe")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/div[contains(@class,'title')]/a/span")));
        //driver.findElement(By.xpath("//span[contains(text(),'" + goodName.substring(0, 10) + "')]")).click();
        //Assertions.assertTrue(driver.findElement(By.xpath("\"//span[contains(text(),'\" + goodName.substring(0, 10) + \"')]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.xpath("//td/div[contains(@class,'title')]/a/span")).getText().substring(0, 10), goodName.substring(0, 10));
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

}
