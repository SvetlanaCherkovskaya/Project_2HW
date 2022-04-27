package lesson6;

import org.openqa.selenium.WebDriver;

public class MainPage extends BaseView {


    public MainPage(WebDriver driver) {
        super(driver);
        menuBlock = new MenuBlock(driver);
    }

    public MenuBlock menuBlock;
}
