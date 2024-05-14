package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests {
    @BeforeAll
    static void stayAwhileAndListen(){
        System.out.println("### stayAwhileAndLister\n");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void fillFormSubmitTest(){
        open("/automation-practice-form");

        //Simple stuff
        $("#firstName").setValue("Pupa");
        $("#lastName").setValue("Lupa");
        $("#userEmail").setValue("lupa@mail.hr");
        $(by("for","gender-radio-1")).click();
        $("#userNumber").setValue("9005001234");

        //Calendar struggles
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").press(Keys.chord(Keys.CONTROL, "a"));
        $("#dateOfBirthInput").press("1","7", Keys.SPACE, "M","a", "r", Keys.SPACE, "1","9","8","8");
        $("#dateOfBirthInput").pressEnter();

        //Autocomplete input
        $("#subjectsContainer").click();
        $("#subjectsInput").press("m");
        $("#subjectsInput").pressEnter();

        //Only imaginary test-person might have enough time for all these activities
        $(by("for","hobbies-checkbox-1")).click();
        $(by("for","hobbies-checkbox-2")).click();
        $(by("for","hobbies-checkbox-3")).click();

        //Загрузка файла из ресурсов проекта
        $("#uploadPicture").uploadFromClasspath("ProfilePicture.jpeg");

        $("#currentAddress").setValue("Middle-earth, near big lidless Eye");

        //Выбор региона
        $("#stateCity-wrapper .css-1wa3eu0-placeholder").click();
        $("#react-select-3-input").pressEnter();
        $("#stateCity-wrapper .css-1wa3eu0-placeholder:nth-child(1)").click();
        $("#react-select-4-input").pressEnter();

        $("#submit").click();

        //check the result
        $(".modal-content").shouldHave(text("Pupa Lupa"));
        $(".modal-content").shouldHave(text("lupa@mail.hr"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9005001234"));
        $(".modal-content").shouldHave(text("17 March,1988"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("ProfilePicture.jpeg"));
        $(".modal-content").shouldHave(text("Middle-earth, near big lidless Eye"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
    }
}
