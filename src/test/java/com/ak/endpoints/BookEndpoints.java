package com.ak.endpoints;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

public class BookEndpoints {

    public static Response getBookByIsbn(String url, String isbn, int responseCode) {

        String endPoint = url + "api/"+ isbn;

        return given().log().ifValidationFails().header("Content-Type", "application/json")
                .urlEncodingEnabled(false)
                .when().get(endPoint)
                .then().assertThat().statusCode(responseCode).extract().response();
    }
}
