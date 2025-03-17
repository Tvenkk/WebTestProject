package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BaseMobPage {

    // Локаторы на начальной странице
    protected SelenideElement loginButton = $("[name='loginButton']");
    protected SelenideElement registerButton = $("[name='registerButton']");

    // Общие локаторы на всех страницах
    protected SelenideElement sideMenu = $("[data-func='openSidebar']");
    protected SelenideElement headerLogo = $("#lgo");
    protected SelenideElement searchIcon = $(".base-button.__plain.__modern.__without-text.__has-icon.ic24.portal-search.base-button.__plain.__modern.__without-text.__has-icon.ic24.__show");
    protected SelenideElement searchField = $("[name='mfr.search']");

    @Step("Кликаем на кнопку Войти")
    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Кликаем на кнопку Регистрация")
    public void clickRegisterButton() {
        registerButton.shouldBe(visible).click();
    }

    //
    @Step("Кликаем на боковое меню")
    public void clickBurgerMenu() {
        sideMenu.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchIcon.shouldBe(visible).click();
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }
}
