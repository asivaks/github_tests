package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepsIssueTest {

    SelenideElement searchFiledSelector = $(".header-search-input");
    String repoName = "eroshenkoam/allure-example";
    String issueName = "С Новым Годом  (2022)";

    @BeforeAll
    static void setUpAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    final void setUpEach() {
        open("");
    }

    @Test
    public void testGithubIssue() {
        step("search for the repo", () -> {
                    searchFiledSelector.click();
                    searchFiledSelector.sendKeys(repoName);
                    searchFiledSelector.submit();
                });

        step("click on the repo", () -> {
        $(linkText(repoName)).click();
        });


        step("click on the Issues", () -> {
        $(partialLinkText("Issues")).click();
        });

        step("check if the issue exists", () -> {
        $$("div[aria-label=Issues]").find(text(issueName)).should(exist);
        });
    }
}
