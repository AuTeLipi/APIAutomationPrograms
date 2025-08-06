package com.LipiAutomation.Ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_POSTBookingRequest_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_POST_BookingRequest() {

        String payload = "{\n" +
                "    \"firstname\" : \"NarayanaLipi\",\n" +
                "    \"lastname\" : \"Dubbaka\",\n" +
                "    \"totalprice\" : 350,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-07-25\",\n" +
                "        \"checkout\" : \"2025-07-26\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(payload);

        response = r.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
