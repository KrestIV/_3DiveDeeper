package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {
    @BeforeAll
    static void stayAwhileAndListen(){
        System.out.println("### stayAwhileAndLister\n");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
    @Test
    void fillFormSubmitTest(){
        open("/text-box");
        $("#userName").setValue("Pupa");
        $("#userEmail").setValue("lupa@mail.hr");
        $("#currentAddress").setValue("Neverland street, building #5");
        $("#permanentAddress").setValue("Middle-earth, near big lidless Eye");
        $("#submit").click();

        $("#output #name").shouldHave(text("Name:Pupa"));
        $("#output #email").shouldHave(text("Email:lupa@mail.hr\n"));
        $("#output #currentAddress").shouldHave(text("Current Address :Neverland street, building #5"));
        $("#output #permanentAddress").shouldHave(text("Permananet Address :Middle-earth, near big lidless Eye"));
    }
}
