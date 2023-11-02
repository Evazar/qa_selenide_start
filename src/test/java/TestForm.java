import java.time.Duration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



public class TestForm {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1620x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = true;
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ev");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Testmail@gmail.com");
        $("#userNumber").setValue("1234569888");
        $("#genterWrapper").$(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day.react-datepicker__day--007").click();
        $("#subjectsInput").setValue("phy").pressEnter();
        $("#subjectsInput").setValue("art").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1test.png");
        $("#currentAddress").setValue("Russia, SPB Nevskiy 99");
        $("#react-select-3-input").val("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").val("Merrut").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(visible, Duration.ofSeconds(6)).shouldHave(text("Thanks for submitting the form"));

        $$(".table thead").get(0).shouldHave(text("Label Values"));
        $$(".table tbody tr").get(0).shouldHave(text("Student Name Ev Ivanov"));
        $$(".table tbody tr").get(1).shouldHave(text("Student Email Testmail@gmail.com"));
        $$(".table tbody tr").get(2).shouldHave(text("Gender Male"));
        $$(".table tbody tr").get(3).shouldHave(text("Mobile 1234569888"));
        $$(".table tbody tr").get(4).shouldHave(text("Date of Birth 07 June,1997"));
        $$(".table tbody tr").get(5).shouldHave(text("Subjects Physics, Arts"));
        $$(".table tbody tr").get(6).shouldHave(text("Hobbies Sports, Music"));
        $$(".table tbody tr").get(7).shouldHave(text("Picture 1test.png"));
        $$(".table tbody tr").get(8).shouldHave(text("Address Russia, SPB Nevskiy 99"));
        $$(".table tbody tr").get(9).shouldHave(text("State and City Uttar Pradesh Merrut"));
    }
}