package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckIssueAutotestCleanSelenide {

    @Test

    public void checkIssueCleanSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");
        $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.cssSelector("[data-content=\"Issues\"]")).click();
        $(withText("#68")).should(Condition.visible);
    }
}
