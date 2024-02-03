package ru.praktikum.yandex.api.client;

import io.restassured.response.Response;
import ru.praktikum.yandex.api.dto.CreateUserDto;
import ru.praktikum.yandex.api.dto.LoginUserDto;

import static ru.praktikum.yandex.api.configs.Configs.*;

public class UserClient extends RestClient {

    public Response createClient(CreateUserDto createUserDto) {
        return getDefaultRequestSpecificationWithoutToken()
                .body(createUserDto)
                .when()
                .post(CREATE_USER);

    }
    public Response loginClient(LoginUserDto loginUserDto) {
        return getDefaultRequestSpecificationWithoutToken()
                .body(loginUserDto)
                .when()
                .post(LOGIN_USER);
    }

    public Response deleteClient(String token) {
        return getRequestSpecificationWithToken(token)
                .when()
                .delete(USER);
    }
}

