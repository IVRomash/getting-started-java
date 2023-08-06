package demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class TextBox {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void FillForm() {
        // Открыть сайт с формой
        open("/text-box");
        $(".body-height").shouldHave(text("Text Box"));
        // В поле "Full Name" ввести ФИО
        $("#userName").setValue("Full Name test");
        // В поле "Email" ввести email
        $("#userEmail").setValue("test@gmail.com");
        // Заполнить поля "Current Address" и "Permanent Address" произвольными значениями
        $("#currentAddress").setValue("Current Address");
        $("#permanentAddress").setValue("Permanent Address");
        // Нажать кнопку "submit"
        $("#submit").click();
        // Выполнить проверку на совпадение введенных данных с данными в появившейся форме
        $("#output").$("#name").shouldHave(text("Full Name test"));
        $("#output").$("#email").shouldHave(text("test@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Current Address"));
        $("#output").$("#permanentAddress").shouldHave(text("Permanent Address"));
    }
}
