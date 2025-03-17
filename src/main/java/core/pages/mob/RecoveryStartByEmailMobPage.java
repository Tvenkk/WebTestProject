package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryStartByEmailMobPage extends BaseMobPage {

    private SelenideElement emailField = $("[name='email']");
    private SelenideElement getCodeButton = $("[name='getCode']");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElement() {
        emailField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Вводим в поле: {email}")
    public void enterValueEmail(String email) {
        emailField.shouldBe(visible).click();
        emailField.shouldBe(visible).setValue(email);
    }

    @Step("Кликаем на кнопку Получить код")
    public void clickGetCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }
}
