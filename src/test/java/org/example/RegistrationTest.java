package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.example.pages.MainPage;
import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Регистрация")
public class RegistrationTest extends BaseTest {
    private static final String BASE_URL = "https://intershop5.skillbox.ru/register/";

    @Test
    @Description("Регистрация нового пользователя")
    public void checkAutorizationWithInvalidData() throws InterruptedException {
        driver.get(BASE_URL);
        String email = String.valueOf(new Random().nextInt(900000) + 100000) + "@gmail.com";
        new RegistrationPage(driver).sendUsername(String.valueOf(new Random().nextInt(900000) + 100000)).sendRegEmail(email).sendRegPass("1234").submit();
        Thread.sleep(5000);
        assertThat(new MainPage(driver).successRegister, isDisplayed());
    }

    @Test
    @Description("Регистрация пользователя с зарегестрированным login пользователя")
    public void checkAutorizationWithUsedLogin() throws InterruptedException {
        driver.get(BASE_URL);
        new RegistrationPage(driver).sendUsername("Aleksey").sendRegEmail("aleksey@slovyagin.com").sendRegPass("1234").submit();
        Thread.sleep(5000);
        assertThat(new RegistrationPage(driver).error, isDisplayed());
    }

}
