package Backend;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestsFromNoAuthorizedUsersTest {
    @Test
    void failRequestToLookAtOtherPeoplesPostsNoAuthorizedUser() {
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(401);
    }
    @Test
    void failRequestToLookMyPostsNoAuthorizedUser() {
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get("https://test-stand.gb.ru/api/posts")
                .then()
                .statusCode(401);
    }
}
