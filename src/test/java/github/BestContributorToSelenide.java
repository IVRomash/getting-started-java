package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void HoverOnIconFirstContributor() {
        // открыть сайта гита с репозиторием селенида
        open("https://github.com/selenide/selenide");
        // наводим на первого контрибьютора
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row").$$("ul li").first().hover();
        //выполняем проверку
        $$(".Popover").findBy(Condition.visible).shouldHave(Condition.text("Andrei Solntsev"));
    }
}
