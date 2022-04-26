package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenoidRepositoryTest {

    @Test
    void shouldFindSelenideAsFirstRepository() {
        Configuration.browser="firefox";
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("h2").shouldHave(text("selenide\n/\nselenide"));
    }
}
