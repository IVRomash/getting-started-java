package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class PracticeForm {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void PricticeForm(){
        // Тестовые данные
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "ivanov@gmail.com";
        String mobileNumber = "9999999999";
        String gender = "Male";
        String month  = "January";
        String year = "2001";
        String day = "11";
        String subject = "Computer Science";
        String currentAddress = "Current Address";
        String hobbies_1 = "Sports";
        String hobbies_2 = "Music";
        String nameFile = "Img.jpg";
        String state =  "Rajasthan";
        String city = "Jaipur";

        // открыть страницу с формой
        open("/automation-practice-form");
        // Изменить маштаб страницы, чтобы отображалась вся форма
        zoom(0.75);
        // Заполнить поля "Name" и "Email"
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        // Активировать radio buttons "Male"
        $(byText(gender)).click();
        // Заполнить поле "Mobile"
        $("#userNumber").setValue(mobileNumber);
        // Заполнить "Date of Birth"
        $("#dateOfBirthInput").click();
        $(".react-datepicker").shouldHave(visible);
        // Выбираем месяц
        $(".react-datepicker__month-select").click();
        $(byText(month)).click();
        // Выбираем год
        $(".react-datepicker__year-select").click();
        $(byText(year)).click();
        // Выбираем дату
        $(byText(day)).click();
        // Заполнить поле "Subject"
        $("#subjectsInput").setValue(subject).pressEnter();
        // Проставить чек-боксы "Sports" и "Music"
        $(byText(hobbies_1)).click();
        $(byText(hobbies_2)).click();
        // Загрузить файл
        File file = new File("src/test/resources/" +nameFile);
        $("#uploadPicture").uploadFile(file);
        // Проверить, что файл загрузился
        $("#uploadPicture").shouldHave(value(nameFile));
        // Заполнить поле "Current Address"
        $("#currentAddress").setValue(currentAddress);
        // Заполнить "State and City"
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        // Нажать на кнопку "submit"
        $("#submit").click();
        $(".modal-content").shouldHave(visible);
        // Убедиться, что отобразилось окно с текстом: "Thanks for submitting the form"
        $(".modal-content").$(".modal-header").shouldHave(text("Thanks for submitting the form"));
        // Убедиться, что значения в таблице совпадают с введенными значениями
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text(mobileNumber));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text(day + " " + month + "," + year));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text(subject));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text(hobbies_1 + ", " + hobbies_2));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text(nameFile));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));

    }
}
