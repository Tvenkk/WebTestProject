package tests.mob;

import core.base.BaseMobPage;
import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobPage;
import core.pages.mob.LoginMobPage;
import core.pages.mob.RecoveryStartByPhoneMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

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
    }
}
