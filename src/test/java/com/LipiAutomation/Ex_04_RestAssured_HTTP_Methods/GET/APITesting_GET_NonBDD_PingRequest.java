package com.LipiAutomation.Ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_GET_NonBDD_PingRequest {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_PingRequest() {

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/ping");

        response = r.when().log().all().get();

        vr = response.then().log().all();
        vr.statusCode(201);

    }
}
