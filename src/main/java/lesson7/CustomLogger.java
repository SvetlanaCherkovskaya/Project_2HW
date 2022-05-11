package lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverListener {

     public void beforeFindElement(WebDriver driver, By locator){
        //Allure.addAttachment("Скриншот конечного результата",
                //new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
        Allure.step("Ищем элемент по локатору" + locator);
    }

    public void beforeQuit(WebDriver driver){
       Allure.addAttachment("Скриншот конечного результата",
        new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
    }
}
