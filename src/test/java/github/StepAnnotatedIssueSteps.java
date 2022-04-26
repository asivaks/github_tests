package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepAnnotatedIssueSteps {

    SelenideElement searchFiledSelector = $(".header-search-input");

    @Step("Open main page")
    public StepAnnotatedIssueSteps openMainPage() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        open("");
        return this;
    }

    @Step("search for the repo {repoName}")
    public StepAnnotatedIssueSteps testGithubIssue(String repoName) {
        searchFiledSelector.click();
        searchFiledSelector.sendKeys(repoName);
        searchFiledSelector.submit();
        return this;
    }

    @Step("click on the repo {repoName}")
    public StepAnnotatedIssueSteps clickOnTheRepoName(String repoName) {
        $(linkText(repoName)).click();
        return this;
    }

    @Step("click on the Issues")
    public StepAnnotatedIssueSteps clickOnIssues() {
        $(partialLinkText("Issues")).click();
        return this;
    }


    @Step("check if the issue {issueName} exists")
    public void checkIssueExists(String issueName) {
        $$("div[aria-label=Issues]").find(text(issueName)).should(exist);
    }
}
