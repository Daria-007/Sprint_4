package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageWihtYourData {
    private static final By INPUT_NAME_FIELD = By.xpath(".//input[@placeholder = '* Имя']"); //Поле ввода для имени
    private static final By INPUT_SURNAME_FIELD = By.xpath(".//input[@placeholder = '* Фамилия']"); //Поле ввода для фамилии
    private static final By INPUT_ADRESS_FIELD = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']"); //Поле ввода для адреса
    private static final By INPUT_TELEPHONE_NUMBER_FIRLD = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']"); //Поле ввода для номера телефона
    private static final By INPUT_SUBWAY_FIELD = By.xpath(".//input[@class ='select-search__input']"); //Поле ввода для станции метро
    private static final By BUTTON_NEXT = By.xpath(".//button[text() = \"Далее\"]"); //Кнопка Далее

    private WebDriver driver;

    public OrderPageWihtYourData(WebDriver driver) {

        this.driver = driver;
    }
    public void inputName(String name) {
        WebElement inputName = driver.findElement(INPUT_NAME_FIELD);
        inputName.clear();
        inputName.sendKeys(name);
    }
    public void inputSurname(String surname) {
        WebElement inputSurname = driver.findElement(INPUT_SURNAME_FIELD);
        inputSurname.clear();
        inputSurname.sendKeys(surname);
    }
    public void inputAdress(String address) {
        WebElement inputAdress = driver.findElement(INPUT_ADRESS_FIELD);
        inputAdress.clear();
        inputAdress.sendKeys(address);
    }
    public void inputSubwayStation(String subway) {
        WebElement inputSubway = driver.findElement(INPUT_SUBWAY_FIELD);
        inputSubway.clear();
        inputSubway.sendKeys(subway);
        driver.findElement(By.xpath("//li[1]")).click();
    }
    public void inputTelephone(String telephone) {
        WebElement inputTelephone = driver.findElement(INPUT_TELEPHONE_NUMBER_FIRLD);
        inputTelephone.clear();
        inputTelephone.sendKeys(telephone);
    }
    public void clickNextButton() {
        driver.findElement(BUTTON_NEXT).click();
    }
    }