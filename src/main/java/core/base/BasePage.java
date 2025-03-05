package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BasePage {

    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptCookieButton = $(".cb_accept");
    protected SelenideElement acceptPrivacyButton = $(".cmptxt_btn_yes");

    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Вводим в поле значение: {query}")
    public void enterValue(String query) {
        searchField.shouldBe(visible).click();
        searchField.shouldBe(visible).setValue(query);
        SelenideElement valueList = $x(String.format("//a[text()='%s']", query));
        valueList.click();
    }

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Принимаем куки")
    public void acceptCookie() {
        acceptCookieButton.shouldBe(visible).click();
    }

    @Step("Принимаем политику конфид конфиденциальности")
    public void acceptPrivacyButton() {
        acceptPrivacyButton.shouldBe(visible).click();
    }
}
