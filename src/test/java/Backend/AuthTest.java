package Backend;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AuthTest {
    @Test
    void getXAuthToken1 () {
        Object response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", "mitrofanova")
                .formParam("password", "f637bd1f30")
                .when()
                .post("https://test-stand.gb.ru/gateway/login")
                .then().extract()
                .jsonPath()
                .get("token")
                .toString();
        System.out.println("API.Token: " + response);
    }
    @Test
    void noGetXAuthTokenWithInvalidLogin(){
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username","mitrofanova11")
                .formParam("password","f637bd1f30")
                .when()
                .post("https://test-stand.gb.ru/gateway/login")
                .then()
                .statusCode(401);
    }
    @Test
    void noGetXAuthTokenWithInvalidPassword (){
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("username","mitrofanova")
                .formParam("password","5678")
                .when()
                .post("https://test-stand.gb.ru/gateway/login")
                .then()
                .statusCode(401);
    }
}
