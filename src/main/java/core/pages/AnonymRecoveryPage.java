package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByPhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement goToSupportButton = $("[data-l='t,support']");

    // Локатор для окна чата поддержки
    private SelenideElement supportChat = $(".h-mod.support-chat.h-mod");

    // Локатор для закрытия чата поддержки
    private SelenideElement closeChatButton = $(".button__tndfc.button-icon__tndfc");

    // Локатор для подтверждения выхода из окна чата поддержки
    private SelenideElement confirmButton = $x("//span[text()='Да']");

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

    @Step("Проверяем видимость окна чата поддержки")
    public boolean isSupportChatVisible() {
        return supportChat.shouldBe(visible).exists();
    }

    @Step("Нажимаем на кнопку Закрыть чат со службой поддержки")
    public void clickCloseChatButton() {
        closeChatButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на кнопку Да")
    public void clickConfirmButton() {
        confirmButton.shouldBe(visible).click();
    }
}
