import model.MainPage;
import model.OrderPageWihtYourData;
import model.OrderPageWithOderData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class MakeOrder {
    private WebDriver driver;
    private int orderType;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0}, // Заказ сверху
                {1}  // Заказ снизу
        });
    }

    public MakeOrder(int orderType) {
        this.orderType = orderType;
    }

    @Test
    public void makeAnOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        // В зависимости от типа заказа вызываем соответствующий метод
        if (orderType == 0) {
            mainPage.openOrderAtTopOfPage();
        } else {
            mainPage.visibilityOfOrderButton();
            mainPage.openOrderAtBottomOfPage();
        }

        OrderPageWihtYourData orderPageWihtYourData = new OrderPageWihtYourData(driver);
        orderPageWihtYourData.inputName();
        orderPageWihtYourData.inputSurname();
        orderPageWihtYourData.inputAdress();
        orderPageWihtYourData.inputSubwayStation();
        orderPageWihtYourData.inputTelephone();
        orderPageWihtYourData.clickNextButton();

        OrderPageWithOderData orderPageWithOderData = new OrderPageWithOderData(driver);
        orderPageWithOderData.waitUntilPageIsVisible();
        orderPageWithOderData.inputData();
        orderPageWithOderData.waitUntilPageIsVisible();
        orderPageWithOderData.clickBlackCheckbox();
        orderPageWithOderData.inputDaysToRent();
        orderPageWithOderData.clickOnButtonOrder();
        orderPageWithOderData.clickOnYesButton();
        orderPageWithOderData.checkModaleIsVisible();
    }
}