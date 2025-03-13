package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginMobPage extends BaseMobPage {

    // Локаторы окна входа
    private SelenideElement usernameField = $("[name='fr.login']");
    private SelenideElement passwordField = $("[name='fr.password']");
    private SelenideElement loginButton = $("[name='button_login']");
    private SelenideElement forgotPasswordLink = $(".base-button.__plain.__modern.__full-width");
    private SelenideElement registrationButton = $(".base-button.__default.__modern.__full-width");

    // Локаторы для авторизации через другие сервисы
    private SelenideElement vkButton = $("[data-func='initVkConnect']");
    private SelenideElement mailButton = $(".base-button_target.__oauth-mailru");
    private SelenideElement yandexButton = $(".base-button_target.__oauth-yandex");

    // Локаторы для ошибок
    private SelenideElement loginErrorMessage = $x("//label[@class='field_error-descr'][@for='field_login']");
    private SelenideElement passwordErrorMessage = $x("//label[@class='field_error-descr'][@for='field_password']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    // Методы для входа
    @Step("Входим на сайт только с логином: {username}")
    public void loginWithOnlyUsername(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
    }

    @Step("Входим на сайт только с паролем: {password}")
    public void loginWithOnlyPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    // Методы для ошибок
    @Step("Проверяем видимость сообщения об ошибке Логина")
    public boolean isLoginErrorMessageVisible() {
        return loginErrorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getLoginErrorMessageText() {
        return loginErrorMessage.shouldBe(visible).getText();
    }

    @Step("Проверяем видимость сообщения об ошибке Логина")
    public boolean isPasswordErrorMessageVisible() {
        return passwordErrorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getPasswordErrorMessageText() {
        return passwordErrorMessage.shouldBe(visible).getText();
    }

    // Метод для перехода к восстановлению пароля
    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }
}
