package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryMobPage extends BaseMobPage {

    private SelenideElement recoveryByPhoneButton = $("a[data-log-click='{\"target\":\"phone\"}']");
    private SelenideElement recoveryByEmailButton = $("a[data-log-click='{\"target\":\"email\"}']");
    private SelenideElement goToSupportButton = $("a[data-log-click='{\"target\":\"support\"}']");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElement() {
        recoveryByPhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        goToSupportButton.shouldBe(visible);
    }


    @Step("Нажимаем на кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByPhoneButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }

    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        goToSupportButton.shouldBe(visible).click();
    }
}
