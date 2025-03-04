package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryStartEmailLinkPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryByEmailTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static AnonymRecoveryStartEmailLinkPage anonymRecoveryStartEmailLinkPage;

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

        anonymRecoveryPage.goToRecoveryByEmail();
        anonymRecoveryStartEmailLinkPage = new AnonymRecoveryStartEmailLinkPage();
    }
}
