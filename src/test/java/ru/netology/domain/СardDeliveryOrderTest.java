package ru.netology.domain;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {
    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Смоленск");
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        LocalDate date = LocalDate.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String dateOfDelivery = formatter.format(date);
        $("[data-test-id='date'] .input__control").setValue(dateOfDelivery);
        $("[data-test-id='name'] .input__control").setValue("Смирнова Юлия");
        $("[data-test-id='phone'] .input__control").setValue("+78542586320");
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Забронировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=notification] .notification__content").shouldHave(text("Встреча успешно забронирована на " + dateOfDelivery));
    }
}

