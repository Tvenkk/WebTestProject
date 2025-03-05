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

    private SelenideElement errorMessage = $(".input-e.js-ph-vl-hint");

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

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryField.click(); // Открываем список стран
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName)); // Находим нужную страну по названию
        countryItem.scrollTo(); // Скроллим до нужной страны
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode; // Возвращаем код страны
    }

    @Step("Проверяем видимость сообщения об ошибке номера телефона")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}
