import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.JsonOutput;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Mike");
        $("#lastName").setValue("Solovyov");
        $("#userEmail").setValue("contact@mikeysoll.ru");
        $$(".custom-control-label").findBy(text("Male")).click();
        $("#userNumber").setValue("9853612907");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2002");
        $("#userNumber").setValue("9853612907");
        $(".react-datepicker__day.react-datepicker__day--015").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
//        $$("#hobbies-checkbox-1, #hobbies-checkbox-2, #hobbies-checkbox-3").click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pic.jpg");
        $("#currentAddress").setValue("Moscow, Red Square")        ;
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();
        sleep(3000);
        $("#closeLargeModal").click();


    }

}
