package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderInfoPage extends BaseView {
    public OrderInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "billing_first_name")
    public WebElement nameInput;

    @FindBy(id = "billing_last_name")
    public WebElement surnameInput;

    @FindBy(id = "billing_address_1")
    public WebElement addressInput;

    @FindBy(id = "billing_city")
    public WebElement cityInput;

    @FindBy(id = "billing_state")
    public WebElement stateInput;

    @FindBy(id = "billing_postcode")
    public WebElement postCodeInput;

    @FindBy(id = "billing_phone")
    public WebElement phoneInput;

    @FindBy(id = "place_order")
    public WebElement sumbitButton;

    @FindBy(xpath = "//*[text()='Спасибо! Ваш заказ был получен.']")
    public WebElement successOrderTitle;

    @Step("Ввод имени")
    public OrderInfoPage nameInpit(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    @Step("Ввод фамилии")
    public OrderInfoPage surNameInput(String surName) {
        surnameInput.sendKeys(surName);
        return this;
    }

    @Step("Ввод адреса")
    public OrderInfoPage addressInput(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    @Step("Ввод области")
    public OrderInfoPage stateInput(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    @Step("Ввод индекса")
    public OrderInfoPage postCodeInput(String post) {
        postCodeInput.sendKeys(post);
        return this;
    }

    @Step("Ввод индекса")
    public OrderInfoPage phoneInput(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    @Step("Ввод города")
    public OrderInfoPage cityInput(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    @Step("Отправка формы оформления заказа")
    public void submitOrder() throws InterruptedException {
        sumbitButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[text()='Спасибо! Ваш заказ был получен.']")));
    }
}