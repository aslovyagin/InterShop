package org.example;


import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.example.pages.AutorizationPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Авторизация")
public class AutorizationTest extends BaseTest {

    private static final String BASE_URL = "https://intershop5.skillbox.ru/my-account/";

    @Test
    @Description("Авторизация с незарегистрированными данными")
    public void checkAutorizationWithInvalidData() throws InterruptedException {
        driver.get(BASE_URL);
        new AutorizationPage(driver).sendUsername("fsafsa").sendPassword("fsafasfsa").submit();
        assertThat(new AutorizationPage(driver).errorUnknowNameNotification, isDisplayed());
    }

    @Test
    @Description("Авторизация с зарегистрированными данными")
    public void checkAutorizationWithValidData() throws InterruptedException {
        driver.get(BASE_URL);
        new AutorizationPage(driver).sendUsername("aleksey").sendPassword("aleksey").submit();
        assertThat(new MainPage(driver).articleMyAccount, isDisplayed());
    }

    @Test
    @Description("Авторизация с зарегестрированным логином и без пароля")
    public void checkAutorizationWithoutPassword() throws InterruptedException {
        driver.get(BASE_URL);
        new AutorizationPage(driver).sendUsername("aleksey").sendPassword("").submit();
        assertThat(new AutorizationPage(driver).errorUnknowNameNotification, isDisplayed());
    }
}