package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By MAKE_ORDER_AT_TOP_OF_PAGE_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g']");
    private static final By MAKE_ORDER_AT_BOTTOM_OF_PAGE_BUTTON = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void openOrderAtTopOfPage() {
        driver.findElement(MAKE_ORDER_AT_TOP_OF_PAGE_BUTTON).click();
    }

    public void openOrderAtBottomOfPage() {
        driver.findElement(MAKE_ORDER_AT_BOTTOM_OF_PAGE_BUTTON).click();
    }

    public void visibilityOfOrderButton() {
        WebElement element = driver.findElement(MAKE_ORDER_AT_BOTTOM_OF_PAGE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void visibilityOfDropDownList() {
    WebElement element = driver.findElement(getQuestionLocator(0));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
}

    public void clickOnQuestion(int questionIndex) {
        driver.findElement(getQuestionLocator(questionIndex)).click();
    }

    public By getQuestionLocator(int index) {
        return By.xpath(".//div[@id = 'accordion__heading-" + index + "']");
    }

    private String getExpectedText(int questionIndex) {
        String[] expectedTexts = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области."
        };
        return expectedTexts[questionIndex];
    }
}
