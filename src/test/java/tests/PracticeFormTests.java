package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Solovyov");
        $("#userEmail").setValue("contact@mikeysoll.ru");
        $$(".custom-control-label").findBy(text("Male")).click();
        $("#userNumber").setValue("9853612907");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__day.react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/pic.jpg");
        $("#currentAddress").setValue("Moscow, Red Square")        ;
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Mike Solovyov"));
        $(".table-responsive").shouldHave(text("contact@mikeysoll.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9853612907"));
        $(".table-responsive").shouldHave(text("15 October,2002"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Reading, Music, Sports"));
        $(".table-responsive").shouldHave(text("pic.jpg"));
        $(".table-responsive").shouldHave(text("Moscow, Red Square"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

        $("#closeLargeModal").click();
    }

}