package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.example.pages.AutorizationPage;
import org.example.pages.OrderInfoPage;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Оформление заказа")
public class BuyProductTest extends BaseTest {

    private static final String BASE_URL = "https://intershop5.skillbox.ru/my-account/";

    @Test
    @Description("Оформление заказа")
    public void checkProductBuyingWithValidData() throws InterruptedException {
        driver.get(BASE_URL);
        new AutorizationPage(driver).
                sendUsername("aleksey").
                sendPassword("aleksey").
                submit().
                clickCatalog()
                .clickAvailableProduct().
                clickCart().
                clickmakeOrderButton().
                nameInpit("Aleksey").
                phoneInput("+79313616277").
                surNameInput("vict")
                .addressInput("1232424")
                .stateInput("12345")
                .postCodeInput("12345")
                .cityInput("adadsaaf")
                .submitOrder();
        assertThat(new OrderInfoPage(driver).successOrderTitle, isDisplayed());
    }
}
