package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class TextBox {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void FillForm() {
        // Открыть сайт с формой
        open("https://demoqa.com/text-box");
        $(".body-height").shouldHave(text("Text Box"));
        // В поле "Full Name" ввести ФИО
        $("#userName").setValue("Full Name test");
        // В поле "Email" ввести корректный email
        $("#userEmail").setValue("test@gmail.com");

        $("#currentAddress").setValue("Current Address");
        $("#permanentAddress").setValue("Permanent Address");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Full Name test"));
        $("#output").$("#email").shouldHave(text("test@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Current Address"));
        $("#output").$("#permanentAddress").shouldHave(text("Permanent Address"));
    }
}
