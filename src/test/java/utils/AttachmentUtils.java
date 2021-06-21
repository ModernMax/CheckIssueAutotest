package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.screenshot;

public class AttachmentUtils {
    public static void makeScreenshot() {
        InputStream steam = new ByteArrayInputStream(screenshot(OutputType.BYTES));
        Allure.attachment("Screenshot", steam);
    }
}
