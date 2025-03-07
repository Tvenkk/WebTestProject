package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayQrCodeTest extends BaseTest {
    private static LoginPage loginPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void testDisplayQrCode() {
        // Переключаемся на вкладку QR-код
        loginPage.switchToQrCode();
        // Проверяем отображение QR-кода
        assertTrue(loginPage.isQrCodeVisible(), "QR-код не отображается");
    }
}
