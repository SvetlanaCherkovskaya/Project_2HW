package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
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

        //Заходим в корзину
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"basket_prod_text_desktop\"]")));
        //driver.findElement(By.xpath("//span[@id=\"basket_prod_text_desktop\"]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'pj_basket')]" +
                "/div[contains(@data-href,'cart')]")));
        driver.findElement(By.xpath("//div[contains(@id,'pj_basket')]/div[contains(@data-href,'cart')]")).click();

        Thread.sleep(10000);



        //Поверяем лежит ли в Корзине наш товар

        //List <WebElement> goods = driver.findElements(By.xpath("//tr[@class='cart__item']"));
        driver.findElement(By.xpath("//span[contains(text()," + goodName + ")]")).click();

        driver.quit();

    }
}
