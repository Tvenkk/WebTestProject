package tests.mob;

import core.base.BaseMobPage;
import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobPage;
import core.pages.mob.LoginMobPage;
import core.pages.mob.RecoveryStartByPhoneMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryByPhoneMobTest extends MobileBaseTest {

    private static BaseMobPage baseMobPage;
    private static LoginMobPage loginMobPage;
    private static AnonymRecoveryMobPage anonymRecoveryMobPage;
    private static RecoveryStartByPhoneMobPage recoveryStartByPhoneMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        baseMobPage = new BaseMobPage();
        baseMobPage.clickLoginButton();
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void testRecoveryByPhoneMob() {
        loginMobPage.openForgotPasswordPage();
        anonymRecoveryMobPage = new AnonymRecoveryMobPage();
        anonymRecoveryMobPage.goToRecoveryByPhone();
        recoveryStartByPhoneMobPage = new RecoveryStartByPhoneMobPage();
        String countryCode = recoveryStartByPhoneMobPage.selectCountryByName("Перу");
        assertEquals("+51", countryCode, "Код страны не совпадает с ожидаемым");

        recoveryStartByPhoneMobPage.clickGetCodeButton();
        assertTrue(recoveryStartByPhoneMobPage.isErrorMessageVisible(), "Сообщение об ошибке не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введен неверный номер телефона";
        String actualErrorMessage = recoveryStartByPhoneMobPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
