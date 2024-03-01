import model.MainPage;
import model.OrderPageWihtYourData;
import model.OrderPageWithOderData;
import model.OrderType;
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
    private final OrderType orderType;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String telephone;
    private final String data;
    private WebDriver driver;
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
                {OrderType.TOP_OF_PAGE, "Дарья", "Ермолаева", "Москва, пр. Металлистов, д. 110, кв. 70", "Площадь Ильича", "89991112233", "02.03.2024"},
                {OrderType.BOTTOM_OF_PAGE, "Иван", "Иванов", "Москва, ул. Ленина, д. 10", "Сокольники", "89992223344", "03.03.2024"}
        });
    }

    public MakeOrder(OrderType orderType, String name, String surname, String address, String subway, String telephone, String data) {
        this.orderType = orderType;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.telephone = telephone;
        this.data = data;
    }

    @Test
    public void makeAnOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        if (orderType == OrderType.TOP_OF_PAGE) {
            mainPage.openOrderAtTopOfPage();
        } else {
            mainPage.visibilityOfOrderButton();
            mainPage.openOrderAtBottomOfPage();
        }

        OrderPageWihtYourData orderPageWihtYourData = new OrderPageWihtYourData(driver);
        orderPageWihtYourData.inputName(name);
        orderPageWihtYourData.inputSurname(surname);
        orderPageWihtYourData.inputAdress(address);
        orderPageWihtYourData.inputSubwayStation(subway);
        orderPageWihtYourData.inputTelephone(telephone);
        orderPageWihtYourData.clickNextButton();

        OrderPageWithOderData orderPageWithOderData = new OrderPageWithOderData(driver);
        orderPageWithOderData.waitUntilPageIsVisible();
        orderPageWithOderData.inputData(data);
        orderPageWithOderData.waitUntilPageIsVisible();
        orderPageWithOderData.clickBlackCheckbox();
        orderPageWithOderData.inputDaysToRent();
        orderPageWithOderData.clickOnButtonOrder();
        orderPageWithOderData.clickOnYesButton();
        orderPageWithOderData.checkModaleIsVisible();
    }
}