package tests.mob;

import core.base.BaseMobPage;
import core.base.MobileBaseTest;
import core.pages.mob.LoginMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithPasswordMobTest extends MobileBaseTest {

    private static BaseMobPage baseMobPage;
    private static LoginMobPage loginMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        baseMobPage = new BaseMobPage();
        baseMobPage.clickLoginButton();
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void testLoginWithPasswordMob() {
        loginMobPage.loginWithOnlyPassword("incorrect");
        loginMobPage.clickLogin();

        assertTrue(loginMobPage.isLoginErrorMessageVisible(), "Сообщение об ошибке не отображается");

        // Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Укажите логин";
        String actualErrorMessage = loginMobPage.getLoginErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }
}
