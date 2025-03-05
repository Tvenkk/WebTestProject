package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage {

    private SelenideElement titleGroupList = $("#hook_Block_UserGroupsSearchPortal");

    @Step("Проверяем видимость заголовка списка")
    public boolean isTitleGroupListVisible() {
        return titleGroupList.shouldBe(visible).exists();
    }
}
