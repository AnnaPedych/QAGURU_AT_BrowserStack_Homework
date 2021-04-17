package tests;

import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.Configuration;
import drivers.BrowserStackMobileDriver;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class SelenideAndroidWikiTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

//        @Test
//        void hideFirstCardTest() {
//        $(AccessibilityId("In the news")).shouldBe(visible);
//        $$(MobileBy.id("org.wikipedia.alpha:id/view_list_card_header_menu")).get(1).click();
//        $(AccessibilityId("Hide this card")).click();
//        $(AccessibilityId("In the news")).shouldNotBe(visible);
//    }
}