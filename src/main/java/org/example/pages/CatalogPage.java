package org.example.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BaseView {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> availableProduct;

    @FindBy(xpath = "//li[@id='menu-item-29']//a[text()='Корзина'] ")
    public WebElement cartButton;

    @Step("Клик на доступный товар")
    public CatalogPage clickAvailableProduct() throws InterruptedException {
        availableProduct.get(0).click();
        return this;
    }

    @Step("Клик на корзина")
    public OrderPage clickCart() {
        cartButton.click();
        return new OrderPage(driver);
    }
}
