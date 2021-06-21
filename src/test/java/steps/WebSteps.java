package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.impl.Screenshot;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {
    @Step("open main page")
    public void openMainPage(String mainPage){
        open((mainPage));
    }

    @Step("Searching repository {repository}")
    public void searchingRepository(String repository){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Go to the repository {repository}")
    public void goToRepository(String repository){
        $(By.linkText(repository)).click();
    }
    @Step("Go to issue tab")
    public void goToIssueTab(){
        $(withText("Issue")).click();
    }
    @Step("Check that the issue with the number {number} visible")
    public void checkIssueVisible(String number){
        $(withText(number)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "Image/png")
    public byte[] makeScreenshot(){
        return screenshot(OutputType.BYTES);
    }
}
