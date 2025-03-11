package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwitchingToTheHelpdeskTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void testSwitchingToTheHelpdesk() {
        // Нажимаем на кнопку "Не получается войти?"
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        // Нажимаем на кнопку "Обратиться в службу поддержки"
        anonymRecoveryPage.goToSupport();
        // Проверяем отображение окна чата поддержки
        assertTrue(anonymRecoveryPage.isSupportChatVisible(), "Диалоговое окно не отображается");
        // Закрываем чат
        anonymRecoveryPage.clickCloseChatButton();
        // Нажимаем на кнопку подтверждения выхода из чата
        anonymRecoveryPage.clickConfirmButton();
    }
}
