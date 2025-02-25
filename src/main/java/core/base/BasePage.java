package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    // Примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    // Метод для клика на логотип ОК
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    // Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    // Метод для клика на Сервисы VK
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }
}
