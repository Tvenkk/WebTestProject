package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryStartPhoneLinkPage extends BasePage {

    private SelenideElement phoneInputField = $("[name='st.r.phone']");
    private SelenideElement countryField = $("#country");
    private SelenideElement getCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElement() {
        phoneInputField.shouldBe(visible);
        countryField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Кликаем на поле Номер телефона")
    public void clickPhoneInput() {
        phoneInputField.shouldBe(visible).click();
    }

    @Step("Кликаем на поле Страна/регион")
    public void clickCountryField() {
        countryField.shouldBe(visible).click();
    }

    @Step("Кликаем на кнопку Получить код")
    public void clickCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }
}
