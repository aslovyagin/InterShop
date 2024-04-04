package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutorizationPage extends BaseView {

    public AutorizationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement errorUnknowNameNotification;

    @Step("Ввод имени в форму авторизации")
    public AutorizationPage sendUsername(String name) {
        username.sendKeys(name);
        return this;
    }

    @Step("Ввод пароля в форму авторизации")
    public AutorizationPage sendPassword(String pass) {
        password.sendKeys(pass);
        return this;
    }

    @Step("Отправка формы авторизации")
    public MainPage submit() {
        submitButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(MainPage.catalogButtonXpath)));
        return new MainPage(driver);
    }

}
