package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;

public class MainPage {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By MAKE_ORDER_AT_TOP_OF_PAGE_BUTTOM = By.xpath(".//button[@class = 'Button_Button__ra12g']"); //кнопка Заказать наверху экрана
    private static final By MAKE_ORDER_AT_BUTTOM_OF_PAGE_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка Заказать внизу экрана
    private static final By FIRST_QUESTOIN = By.xpath(".//div[@id = 'accordion__heading-0']"); //Первый вопрос в выпадающем списке
    private static final By SECOND_QUECTION = By.xpath(".//div[@id = 'accordion__heading-1']"); //Второй вопрос в выпадающем списке
    private static final By THIRD_QUECTION = By.xpath(".//div[@id = 'accordion__heading-2']"); //Третий вопрос в выпадающем списке
    private static final By FOURTH_QUECTION = By.xpath(".//div[@id = 'accordion__heading-3']"); //Четвертый вопрос в выпадающем списке
    private static final By FIFTH_QUECTION = By.xpath(".//div[@id = 'accordion__heading-4']"); //Пятый вопрос в выпадающем списке
    private static final By SIXTH_QUECTION = By.xpath(".//div[@id = 'accordion__heading-5']"); //Шестой вопрос в выпадающем списке
    private static final By SEVENTH_QUECTION = By.xpath(".//div[@id = 'accordion__heading-6']"); //Седьмой вопрос в выпадающем списке
    private static final By EIGHTH_QUECTION = By.xpath(".//div[@id = 'accordion__heading-7']"); //Восьмой вопрос в выпадающем списке
    private static final By FIRST_TEXT = By.xpath(".//div[@id = 'accordion__panel-0']/p"); //Первый текстответа в выпадающем списке
    public static final By SECOND_TEXT = By.xpath(".//div[@id = 'accordion__panel-1']/p"); //Второй текстответа в выпадающем списке
    public static final By THIRD_TEXT = By.xpath(".//div[@id = 'accordion__panel-2']/p"); //Третий текстответа в выпадающем списке
    public static final By FOURTH_TEXT = By.xpath(".//div[@id = 'accordion__panel-3']/p"); //Четвертый текстответа в выпадающем списке
    public static final By FIFTH_TEXT = By.xpath(".//div[@id = 'accordion__panel-4']/p"); //Пятый текстответа в выпадающем списке
    public static final By SIXTH_TEXT = By.xpath(".//div[@id = 'accordion__panel-5']/p"); //Шестой текстответа в выпадающем списке
    public static final By SEVENTH_TEXT = By.xpath(".//div[@id = 'accordion__panel-6']/p"); //Седьмой текстответа в выпадающем списке
    public static final By EIGHTH_TEXT = By.xpath(".//div[@id = 'accordion__panel-7']/p"); //Восьмой текстответа в выпадающем списке
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void openOrderAtTopOfPage() {
        driver.findElement(MAKE_ORDER_AT_TOP_OF_PAGE_BUTTOM).click();
    }
    public void openOrderAtBottomOfPage() {
        driver.findElement(MAKE_ORDER_AT_BUTTOM_OF_PAGE_BUTTON).click();
    }
    public void visibilityOfOrderButton() {
        WebElement element = driver.findElement(MAKE_ORDER_AT_BUTTOM_OF_PAGE_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void visibilityOfDropDownList() {
        WebElement element = driver.findElement(FIRST_QUESTOIN);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickOnQuestion(int questionIndex) {
        By questionLocator = getQuestionLocator(questionIndex);
        driver.findElement(questionLocator).click();
    }
    public void checkQuestionText(int questionIndex) {
        String expectedText = getExpectedText(questionIndex);
        By questionTextLocator = getQuestionTextLocator(questionIndex);
        assertEquals(expectedText, driver.findElement(questionTextLocator).getText());
    }
    private String getExpectedText(int questionIndex) {
        switch (questionIndex) {
            case 0:
                return "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
            case 1:
                return "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
            case 2:
                return "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
            case 3:
                return "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
            case 4:
                return "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
            case 5:
                return "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
            case 6:
                return "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
            case 7:
                return "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
            default:
                throw new IllegalArgumentException("Invalid question index");
        }
    }
    private By getQuestionLocator(int questionIndex) {
        switch (questionIndex) {
            case 0:
                return FIRST_QUESTOIN;
            case 1:
                return SECOND_QUECTION;
            case 2:
                return THIRD_QUECTION;
            case 3:
                return FOURTH_QUECTION;
            case 4:
                return FIFTH_QUECTION;
            case 5:
                return SIXTH_QUECTION;
            case 6:
                return SEVENTH_QUECTION;
            case 7:
                return EIGHTH_QUECTION;
            default:
                throw new IllegalArgumentException("Invalid question index");
        }
    }
    private By getQuestionTextLocator(int questionIndex) {
        switch (questionIndex) {
            case 0:
                return FIRST_TEXT;
            case 1:
                return SECOND_TEXT;
            case 2:
                return THIRD_TEXT;
            case 3:
                return FOURTH_TEXT;
            case 4:
                return FIFTH_TEXT;
            case 5:
                return SIXTH_TEXT;
            case 6:
                return SEVENTH_TEXT;
            case 7:
                return EIGHTH_TEXT;
            default:
                throw new IllegalArgumentException("Invalid question index");
        }
    }
}
