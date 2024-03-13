package api;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Generator {
    public static api.User getFaker() {
        Faker faker = new Faker(Locale.forLanguageTag("ru"));
        final String email = faker.internet().emailAddress();
        final String password = faker.internet().password(6, 10);
        final String name = faker.name().firstName();
        return new api.User(email, password, name);
    }
}
