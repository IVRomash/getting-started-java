package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void GitRepository() {
        //открыть главную страницу
        open("https://github.com");
        //нажать на поле поиска
        $(".input-button").pressEnter();
        //ввести в поле "selenide"
        $("#query-builder-test").setValue("selenide").pressEnter();
        //Кликнуть на первый репозиторий
        $("[data-testid=results-list] h3 a").click();
        //выполнить проверку на совпадение заголовка: selenide / selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));
    }
}
