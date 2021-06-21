package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

@Feature("Issue")
@Owner("@MaxModern")

public class CheckIssueAutotestAnnotationSteps {
    private WebSteps steps = new WebSteps();

    @Test
    @Story("Check Issue visible")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Test to check the presence of a issue in the list")
    public void checkIssueAnnotatedTest() {
        steps.openMainPage("https://github.com");
        steps.searchingRepository("eroshenkoam/allure-example");
        steps.goToRepository("eroshenkoam/allure-example");
        steps.goToIssueTab();
        steps.checkIssueVisible("#68");
        steps.makeScreenshot();
    }
}
