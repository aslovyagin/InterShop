package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseView {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "reg_username")
    public WebElement regUsername;
    @FindBy(id = "reg_email")
    public WebElement regEmail;
    @FindBy(id = "reg_password")
    public WebElement regPass;
    @FindBy(xpath = "//*[@value='Зарегистрироваться']")
    public WebElement submitReg;

    @FindBy(xpath = "//*[@id=\"post-141\"]/div/div/div/div/ul/li/strong")
    public WebElement error;

    @Step("Ввод имени в форму регистрации")
    public RegistrationPage sendUsername(String name) {
        regUsername.sendKeys(name);
        return this;
    }

    @Step("Ввод почты в форму регистрации")
    public RegistrationPage sendRegEmail(String name) {
        regEmail.sendKeys(name);
        return this;
    }

    @Step("Ввод почты в форму регистрации")
    public RegistrationPage sendRegPass(String name) {
        regPass.sendKeys(name);
        return this;
    }

    @Step("Отправка формы регистрации")
    public MainPage submit() {
        submitReg.click();
        return new MainPage(driver);
    }

}
