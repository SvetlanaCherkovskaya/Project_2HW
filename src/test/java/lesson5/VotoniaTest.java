package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
    static void registrDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver();
        driver.get(VotoniaSrartURL);
    }

    @BeforeEach
    void setupDriver(){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test
            void clearCartTest() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'pj_basket')]" +
                "/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        if (driver.findElements(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).size() > 0) {
            driver.findElement(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).click();
        }

    Thread.sleep(5000);
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'cart__empty')]")).isDisplayed());


    }





}
