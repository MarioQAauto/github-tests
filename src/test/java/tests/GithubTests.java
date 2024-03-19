package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// ======================================
//TESTS FOR https://github.com/enterprise
// ======================================

public class GithubTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy= "eager";
        Configuration.browserSize = "1920x1200";

    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void navigateToGithubEnterpriseTest() {
        open("");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(".header-menu-wrapper").$(byText("Enterprise")).click();

        $(withTagAndText("title", "The AI Powered Developer Platform")).should(exist);
    }
}