package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

//1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
//Если может - приведите пример, когда.

/*
$("h1 div") найдёт 1ый элемент div вложенный в любой h1
найдёт элемент
  <div>
    Some text under Header2
  </div>

$("h1").$("div") найдёт 1ый элемент h1 и будет искать в нём и только в нём вложенный элемент h1
не найдёт элемент
  <div>
    Some text under Header2
  </div>

<h1>
  Header 1
</h1>
<p>
  Text block 1
</p>
<h1>
  Header2
  <div>
    Some text under Header2
  </div>
</h1>
<p>
  Text block 2
</p>

*/

public class OnAssertionsPageJunit5ExampleTest {

// 2. Разработайте следующий автотест:
// - Откройте страницу Selenide в Github
// - Перейдите в раздел Wiki проекта
// - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    @BeforeAll
    static void setUpAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    final void setUpEach () {
        open("");
    }

    @Test
    public void onAssertionsPageJunit5ExampleTest() {
        //search for "selenide"
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //click on "selenide/selenide" repo
        $$("ul.repo-list li a").find(text("selenide/selenide")).click();
        //click on Wiki
        $$("nav li").find(text("Wiki")).click();
        // check if "Soft Assertions" page exists
        $("div.markdown-body").$(linkText("Soft assertions")).shouldBe(visible);
        // click on "Soft Assertions"
        $("div.markdown-body").$(linkText("Soft assertions")).click();
        //header containg "JUnit5" is visible
        $("div.markdown-body").$(withText("Using JUnit5")).shouldBe(visible);
        //next element should contain code i.e. code class
        $("div.markdown-body").$(withText("3. Using JUnit5 extend test class")).sibling(0).should(cssClass("highlight-source-java"));

    }
}
