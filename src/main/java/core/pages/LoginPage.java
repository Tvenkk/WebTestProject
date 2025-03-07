package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");

    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement mailButton = $("[data-l='t,mailru']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $(".input-e.login_error");

    // Локатор для восстановления пароля
    private SelenideElement goToRecoveryButton = $("[value='st.go_to_recovery']");

    // Локатор для переключения на вход по QR-коду
    private SelenideElement qrCode = $("[data-l='t,qr_tab']");

    // Локатор для отображения QR-кода
    private SelenideElement qrCodeImg = $(".qr_code_image");

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
        qrCode.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином и паролем: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    // Два метода для ввода отдельно Логина и отдельно Пароля
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

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    // Методы для перехода на страницы авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMail() {
        mailButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    public void loginWithYandex() {
        yandexButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Восстановить пароль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Переключаемся на вкладку QR-код")
    public void switchToQrCode() {
        qrCode.shouldBe(visible).click();
    }

    @Step("Проверяем видимость QR-кода")
    public boolean isQrCodeVisible() {
        return qrCodeImg.shouldBe(visible).exists();
    }
}
