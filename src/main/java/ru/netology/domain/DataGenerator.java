package ru.netology.domain;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    public static class Registrator {
        private Registrator() {
        }

        public static RegistrationByCard generateByCard(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new RegistrationByCard(
                    faker.address().city(),
                    LocalDate.now().plusDays(3),
                    faker.name().fullName(),
                    faker.phoneNumber();
        }

    }
}
