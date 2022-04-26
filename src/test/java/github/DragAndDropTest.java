package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {
    /*
    3. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
     - Откройте https://the-internet.herokuapp.com/drag_and_drop
     - Перенесите прямоугольник А на место В
     - Проверьте, что прямоугольники действительно поменялись
    P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
    (раньше не работала из-за ошибки в ChromeDriver, но может быть уже починили? :-)).
    Если работает - сообщите в группе курса.
     */
    SelenideElement leftBlock = $("#column-a");
    SelenideElement rightBlock = $("#column-b");
    SelenideElement leftBlockCaption = leftBlock.$("header");
    SelenideElement rightBlockCaption = rightBlock.$("header");

    @BeforeAll
    static void setUpAll() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    final void setUpEach() {
        open("/drag_and_drop");
    }

    @Test
    public void dragAndDropTest() {
        //check block captions
        leftBlockCaption.shouldHave(text("A"));
        rightBlockCaption.shouldHave(text("B"));
        //drag and drop block from the left to the right
        leftBlock.dragAndDropTo($("#column-b"));
        //check block captions
        leftBlockCaption.shouldHave(text("B"));
        rightBlockCaption.shouldHave(text("A"));

    }
}
