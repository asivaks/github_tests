package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    @Test
    void solntsevShouldBeFirstContributor() {
        //open repo page
        open("https://github.com/selenide/selenide");

        //bring mouse over the 1st avatar on contributors tab
        $(".Layout-sidebar").$(byText("Contributors")).ancestor("div").$$("ul li").first().hover();

        //check: popup is showing Andrei Solnsev
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
