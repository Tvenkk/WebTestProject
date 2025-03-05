package tests;

import core.base.BaseTest;
import core.pages.GroupsPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchForGroupsTest extends BaseTest {
    private static LoginPage loginPage;
    private static GroupsPage groupsPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void testSearchForGroups() {
        loginPage.enterValue("Тестировщик");
        groupsPage = new GroupsPage();
        assertTrue(groupsPage.isTitleGroupListVisible(), "Переход к списку групп не был осуществлен");
    }
}
