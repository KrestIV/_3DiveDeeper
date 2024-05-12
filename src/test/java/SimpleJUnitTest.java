import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
    int result;
    @Test
    void firstTest(){
        System.out.println("### firstTest");
        Assertions.assertTrue(result>2);
    }
    @Test
    void secondTest(){
        System.out.println("### secondTest");
        Assertions.assertTrue(result>2);
    }
    @Test
    void thirdTest(){
        System.out.println("### thirdTest");
        Assertions.assertTrue(result>1);
    }

    @BeforeAll
    static void stayAwhileAndLister(){
        System.out.println("### stayAwhileAndLister\n");
    }
    @BeforeEach
    void doItBabyEveryTime(){
        System.out.println("### doItBabyEveryTime");
        result = getResult();
    }

    @AfterEach
    void justOneMoreThing(){
        System.out.println("### justOneMoreThing\n");
        result = 0;
    }

    @AfterAll
    static void youMayGoNow(){
        System.out.println("### youMayGoNow");
    }

    private int getResult(){
        return 3;
    }
    /*@Test
    void successfulSearchTest(){
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }*/
}
