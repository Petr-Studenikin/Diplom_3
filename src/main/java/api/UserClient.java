package api;

import io.restassured.response.ValidatableResponse;
import lombok.NonNull;

import static io.restassured.RestAssured.given;

public class UserClient extends api.Client {
    private static final String CREATE_USER = "api/auth/register";
    private static final String LOGIN_USER = "api/auth/login";
    private static final String AUTHORIZATION_USER = "api/auth/user";

    public ValidatableResponse create(api.User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(CREATE_USER)
                .then();
    }

    public ValidatableResponse login(UserDetails credentials) {
        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    public ValidatableResponse delete(@NonNull String token) {
        return given()
                .spec(getBaseSpec())
                .auth().oauth2(token)
                .when()
                .delete(AUTHORIZATION_USER)
                .then();
    }
}
