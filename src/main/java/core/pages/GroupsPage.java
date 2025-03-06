package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage {

    // Локаторы для разделов
    private SelenideElement userMain = $("[data-l='t,userMain']");
    private SelenideElement userHobbies = $("[name='18/ico_hobbies_18']");
    private SelenideElement userVideo = $("[data-l='t,video']");
    private SelenideElement userGroups = $("[data-l='t,userAltGroup']");
    private SelenideElement userSearch = $("[data-l='t,anonym.userSearch']");
    private SelenideElement contentSearch = $("[data-l='t,contentSearch']");
    private SelenideElement appsShowcase = $("[data-l='t,appsShowcaseHD']");
    private SelenideElement giftsFront = $("[data-l='t,giftsFront']");
    private SelenideElement help = $("[data-l='t,help']");
    private SelenideElement switchLanguage = $("[data-l='t,switchLanguage']");

    {
        verifyPageElement();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElement() {
        userMain.shouldBe(visible);
        userHobbies.shouldBe(visible);
        userVideo.shouldBe(visible);
        userGroups.shouldBe(visible);
        userSearch.shouldBe(visible);
        contentSearch.shouldBe(visible);
        appsShowcase.shouldBe(visible);
        giftsFront.shouldBe(visible);
        help.shouldBe(visible);
        switchLanguage.shouldBe(visible);
    }
}
