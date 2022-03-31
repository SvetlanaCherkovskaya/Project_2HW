package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver();
        driver.get("https://www.votonia.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(50));

        //Очищаю корзину
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'pj_basket')]" +
                "/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        if (driver.findElements(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).size() > 0) {
            driver.findElement(By.xpath("//div[contains(@class,'cart__bottom-info__buttons-clean')]")).click();
        }

        //Заходим во вкладку Акции
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Акции')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Акции')]")).click();

        //Кидаем товар в корзину
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]")));
        driver.findElement(By.xpath("(//span[contains(text(),'КОРЗИНУ')])[1]")).click();

        //Получаем и запоминаем название товара
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'added-to-basket')]")));
        String goodName = driver.findElement(By.xpath("//div[contains(@class,'added-to-basket')]")).getAttribute("data-shop");
        System.out.println(goodName);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        //Заходим в корзину
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'pj_basket')]" +
                "/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        //Поверяем лежит ли в Корзине наш товар
        driver.switchTo().frame(driver.findElement(By.id("cartiframe")));
        driver.findElement(By.xpath("//span[contains(text(),'" + goodName.substring(0, 10) + "')]")).click();

        driver.quit();

    }
}
