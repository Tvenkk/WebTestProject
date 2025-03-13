package tests.mob;

import core.base.BaseMobPage;
import core.base.MobileBaseTest;
import core.pages.mob.AnonymRecoveryMobPage;
import core.pages.mob.LoginMobPage;
import core.pages.mob.RecoveryStartByEmailMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class RecoveryByEmailMobTest extends MobileBaseTest {

    private static BaseMobPage baseMobPage;
    private static LoginMobPage loginMobPage;
    private static AnonymRecoveryMobPage anonymRecoveryMobPage;
    private static RecoveryStartByEmailMobPage recoveryStartByEmailMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        baseMobPage = new BaseMobPage();
        baseMobPage.clickLoginButton();
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void testRecoveryByEmailMob() {
        loginMobPage.openForgotPasswordPage();
        anonymRecoveryMobPage = new AnonymRecoveryMobPage();
        anonymRecoveryMobPage.goToRecoveryByEmail();
        //recoveryStartByEmailMobPage = new RecoveryStartByEmailMobPage();
        System.out.println("");
    }
}
