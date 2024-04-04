package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='post-22 page type-page status-publish hentry']")
    public WebElement articleMyAccount;
    @FindBy(xpath = "//*[text()='Регистрация завершена']")
    public WebElement successRegister;

    @FindBy(xpath = "//li[@id='menu-item-46']//a[text()='Каталог']")
    public WebElement catalogButton;

    @FindBy(xpath = "//li[@id='menu-item-29']//a[text()='Корзина'] ")
    public WebElement cartButton;

    public static String catalogButtonXpath = "//li[@id='menu-item-46']//a[text()='Каталог']";


    @Step("Клик на каталог")
    public CatalogPage clickCatalog() {
        catalogButton.click();
        return new CatalogPage(driver);
    }


}
