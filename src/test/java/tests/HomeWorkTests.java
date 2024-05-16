package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

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
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Pupa");
        $("#lastName").setValue("Lupa");
        $("#userEmail").setValue("lupa@mail.hr");
        $(by("for","gender-radio-1")).click();
        $("#userNumber").setValue("9005001234");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1991");
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__day--003").click();

        $("#subjectsContainer").click();
        $("#subjectsInput").press("m");
        $("#subjectsInput").pressEnter();


        $(by("for","hobbies-checkbox-1")).click();
        $(by("for","hobbies-checkbox-2")).click();
        $(by("for","hobbies-checkbox-3")).click();


        $("#uploadPicture").uploadFromClasspath("ProfilePicture.jpeg");

        $("#currentAddress").setValue("Middle-earth, near big lidless Eye");


        $("#stateCity-wrapper .css-1wa3eu0-placeholder").click();
        $("#react-select-3-input").pressEnter();
        $("#stateCity-wrapper .css-1wa3eu0-placeholder:nth-child(1)").click();
        $("#react-select-4-input").pressEnter();

        $("#submit").click();


        $(".modal-content").shouldHave(text("Pupa Lupa"));
        $(".modal-content").shouldHave(text("lupa@mail.hr"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9005001234"));
        $(".modal-content").shouldHave(text("3 May,1991"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("ProfilePicture.jpeg"));
        $(".modal-content").shouldHave(text("Middle-earth, near big lidless Eye"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
    }
}
