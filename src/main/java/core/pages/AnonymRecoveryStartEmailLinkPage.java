package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryStartEmailLinkPage extends BasePage {

    private SelenideElement emailInputField = $("[name='email']");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElement() {
        emailInputField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Кликаем на поле mail@mail.ru")
    public void clickEmailInput() {
        emailInputField.shouldBe(visible).click();
    }

    @Step("Кликаем на поле mail@mail.ru")
    public void clickCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }
}
