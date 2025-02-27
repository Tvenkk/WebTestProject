package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentialsTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookie и политики
        loginPage = new LoginPage();
        /* loginPage.acceptCookie();
        loginPage.acceptPrivacyButton(); */
    }

    @Test
    public void testLoginWithWrongCredentials() {
        // Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
