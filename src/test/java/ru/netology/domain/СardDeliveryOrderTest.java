package ru.netology.domain;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {
   private final String city = DataGenerator.getCity();
   private final String date = DataGenerator.getDate();
   private final String name = DataGenerator.getName();
   private final String phone = DataGenerator.getPhone();
   
    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue(city);
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(date);
        $("[data-test-id='name'] .input__control").setValue(name);
        $("[data-test-id='phone'] .input__control").setValue(phone);
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Запланировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=success-notification] .notification__content").shouldHave(text("Встреча успешно запланирована на " + date));
    }

}

