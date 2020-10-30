package ru.netology.domain;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {
   private RegistrationByCard registrationByCard;

    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue(registrationByCard.getCity());
        $("[data-test-id='date'] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] .input__control").setValue(registrationByCard.getDate());
        $("[data-test-id='name'] .input__control").setValue(registrationByCard.getName());
        $("[data-test-id='phone'] .input__control").setValue(registrationByCard.getPhoneNumber());
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Запланировать")).click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
        $("[data-test-id=success-notification] .notification__content").shouldHave(text("Встреча успешно запланирована на " + registrationByCard.getDate()));
    }

//        LocalDate date = LocalDate.now().plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        String dateOfDelivery = formatter.format(date);
}

