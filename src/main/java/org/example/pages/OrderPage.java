package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BaseView {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement makeOrderButton;

    @Step("Клик на кнопку оформления заказа")
    public OrderInfoPage clickmakeOrderButton() throws InterruptedException {
        makeOrderButton.click();
        return new OrderInfoPage(driver);
    }
}
