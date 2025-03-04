package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryStartPhoneLinkPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByPhoneTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static AnonymRecoveryStartPhoneLinkPage anonymRecoveryStartPhoneLinkPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void testAnonymRecoveryByPhone() {
        // Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.loginWithOnlyPassword("incorrectPassword");
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();

        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryStartPhoneLinkPage = new AnonymRecoveryStartPhoneLinkPage();

        String countryCode = anonymRecoveryStartPhoneLinkPage.selectCountryByName("Швейцария");
        assertEquals("+41", countryCode, "Код страны не совпадает с ожидаемым");

        // Кликаем на кнопку Получить код и проверяем отображение об ошибке
        anonymRecoveryStartPhoneLinkPage.clickCodeButton();
        assertTrue(anonymRecoveryStartPhoneLinkPage.isErrorMessageVisible(), "Сообщения об ошибке не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = anonymRecoveryStartPhoneLinkPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
