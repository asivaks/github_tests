package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StepAnnotatedIssueTest {

    String repoName = "eroshenkoam/allure-example";
    String issueName = "С Новым Годом  (2022)";

    @BeforeAll
    static void setUpAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @Test
    public void testGithubIssue() {
        StepAnnotatedIssueSteps steps = new StepAnnotatedIssueSteps();
        steps.openMainPage()
             .testGithubIssue(repoName)
             .clickOnTheRepoName(repoName)
             .clickOnIssues()
             .checkIssueExists(issueName);
    }
}
