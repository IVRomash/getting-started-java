package search_selenide_on_google;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class successfulSearchTest {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $(byName("q")).setValue("selenide").pressEnter();
        $("#rso").shouldHave(text("Selenide.org"));
    }
}
