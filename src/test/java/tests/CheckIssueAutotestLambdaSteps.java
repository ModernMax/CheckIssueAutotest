package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Allure;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static utils.AttachmentUtils.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class CheckIssueAutotestLambdaSteps {

    private static final String base_url = "https://github.com";
    private static final String repository = "eroshenkoam/allure-example";
    private static final String number = "#68";

    @Test
    @DisplayName("Test to check the presence of a issue in the list")
    public void checkIssueLambdaSteps() {
        Allure.parameter("url", base_url);
        Allure.parameter("repository", repository);
        Allure.parameter("number", number);

        Allure.feature("Issue");
        Allure.label("owner", "@MaxModern");
        Allure.story("Check Issue visible");
        Allure.label("severity", SeverityLevel.BLOCKER.toString());
        Allure.link("Github", "https://github.com");


        step("open main page", (s) -> {
            s.parameter("url", base_url);
            open(base_url);
        });
        step("Searching repository " + repository, (s) -> {
            s.parameter("repository", repository);
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        });
        step("Go to the repository " + repository, (s) -> {
            s.parameter("repository", repository);
            $(By.linkText(repository)).click();
        });
        step("Go to issue tab", () -> {
            $(withText("Issue")).click();
        });
        step("Check that the issue with the " + number + " visible", (s) -> {
            s.parameter("number", number);
            $(withText(number)).should(Condition.visible);
        });
        makeScreenshot();
    }
}
