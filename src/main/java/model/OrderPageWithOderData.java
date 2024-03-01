package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
//import static org.junit.Assert.assertTrue;


public class OrderPageWithOderData {
    private static final By INPUT_DATA_FIELD = By.xpath(".//input[@placeholder = '* Когда привезти самокат']"); //Поле ввода для даты
    private static final By INPUT_DAYS_TO_RENT_FIELD = By.xpath(".//div[text() = \"* Срок аренды\"]"); //Поле ввода для срока аренды
    private static final By CHECKBOX_BLACK = By.xpath(".//label[@for = 'black']"); //Чекбокс для выыбора цвета самоката
    private static final By BUTTON_ORDER = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка Заказать
    private static final By BUTTON_SAY_YES = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']/div/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка Да для подтверждения заказа
    private static final By CHOOSE_DAYS_OF_RENT = By.xpath(".//div[text() = \"трое суток\"]"); //выбор количества дней из выпадающего списка
    private static final By MODAL_SUCSESS_ORDER = By.xpath(".//div[@class='Order_Modal__YZ-d3']"); //модалка успешного заказа
    private WebDriver driver;

    public OrderPageWithOderData(WebDriver driver) {

        this.driver = driver;
    }
    public void waitUntilPageIsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_DATA_FIELD));
    }
    public void inputData(String data) {
        WebElement inputData = driver.findElement(INPUT_DATA_FIELD);
        inputData.clear();
        inputData.sendKeys(data);
    }

    public void inputDaysToRent() {
        driver.findElement(INPUT_DAYS_TO_RENT_FIELD).click();
        driver.findElement(CHOOSE_DAYS_OF_RENT).click();
    }
    public void clickBlackCheckbox() {

        driver.findElement(CHECKBOX_BLACK).click();
    }
    public void clickOnButtonOrder() {
        driver.findElement(BUTTON_ORDER).click();
    }
    public void clickOnYesButton() {

        driver.findElement(BUTTON_SAY_YES).click();
    }
//    public void checkModaleIsVisible() {
//        assertTrue(driver.findElement(MODAL_SUCSESS_ORDER).isDisplayed());
//
//    }
    public void checkModaleIsVisible() {
    WebElement modal = driver.findElement(MODAL_SUCSESS_ORDER);
    if (!modal.isDisplayed()) {
        throw new AssertionError("Modal is not visible");
    }
}
}
