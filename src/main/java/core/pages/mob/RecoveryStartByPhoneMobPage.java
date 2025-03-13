package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RecoveryStartByPhoneMobPage extends BaseMobPage {

    // Локаторы для основных элементов на странице
    private SelenideElement phoneField = $("[name='rfr.phone']");
    private SelenideElement getCodeButton = $("[name='getCode']");

    // Локаторы для элементов выпадающего списка
    private SelenideElement countryDropdown = $("#countryFlag");

    // Локатор для ошибки
    private SelenideElement errorMessage = $(".field_error-descr");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице")
    private void verifyPageElement() {
        phoneField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }


    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $(String.format(".choose-list_i-cnt.wbr[data-model='{\"name\":\"%s\"}']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".reg_choose_prefix").text();
        countryItem.click();
        return countryCode;
    }


    @Step("Кликаем на кнопку Получить код")
    public void clickGetCodeButton() {
        getCodeButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}
