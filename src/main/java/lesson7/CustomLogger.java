package lesson7;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.openqa.selenium.OutputType.BYTES;
import static org.openqa.selenium.OutputType.FILE;

public class CustomLogger implements WebDriverListener {

    public void beforeFindElement(WebDriver driver, By locator) {
        //Allure.addAttachment("Скриншот конечного результата",
        //new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
        Allure.step("Ищем элемент по локатору" + locator);
    }
//
//    OutputType<File> LOCAL_FILE = new OutputType<File>() {
//        public File convertFromBase64Png(String base64Png) {
//            return this.save((byte[])BYTES.convertFromBase64Png(base64Png));
//        }
//
//        public File convertFromPngBytes(byte[] data) {
//            return this.save(data);
//        }
//
//        private File save(byte[] data) {
//            try {
//                Path tmpFilePath = Files.createFile(Paths.get("./screenshot.png"));
//                File tmpFile = tmpFilePath.toFile();
//                Files.write(tmpFilePath, data, new OpenOption[0]);
//                return tmpFile;
//            } catch (IOException var4) {
//                throw new WebDriverException(var4);
//            }
//        }
//
//        public String toString() {
//            return "OutputType.FILE";
//        }
//    };

    @Override
    public void beforeQuit(WebDriver driver) {
        //((TakesScreenshot) driver).getScreenshotAs(LOCAL_FILE);

        Allure.addAttachment("Скриншот конечного результата",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));
    }
}
