package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void autoTests() {

        open("/automation-practice-form");

        //Простые поля
        $("#firstName").setValue("Sasha");
        $("#lastName").setValue("Mario");
        $("#userEmail").setValue("email@mail.ru");
        $("#userNumber").setValue("8800555353");
        $(".custom-radio").click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("www leningrad");

        //Выбор объекта
        $(By.id("subjectsInput")).setValue("M").pressEnter();

        //Загрузка
        $("#uploadPicture").uploadFromClasspath("images/test2.png");

        //Государство и город
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        //День рождения
        $("#dateOfBirthInput").click();
        $(By.className("react-datepicker__day--001")).doubleClick();

        $("#submit").click();

        //Проверка формы
        $(".table-responsive").shouldHave(text("Sasha Mario")) ;
        $(".table-responsive").shouldHave(text("email@mail.ru")) ;
        $(".table-responsive").shouldHave(text("8800555353")) ;
        $(".table-responsive").shouldHave(text("Male")) ;
        $(".table-responsive").shouldHave(text("Music")) ;
        $(".table-responsive").shouldHave(text("01 March,2024")) ;
        $(".table-responsive").shouldHave(text("Maths")) ;
        $(".table-responsive").shouldHave(text("test2.png")) ;
        $(".table-responsive").shouldHave(text("www leningrad")) ;
        $(".table-responsive").shouldHave(text("NCR Delhi")) ;

    }
}
