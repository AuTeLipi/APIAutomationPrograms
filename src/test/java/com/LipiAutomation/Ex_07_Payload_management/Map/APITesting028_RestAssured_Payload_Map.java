package com.LipiAutomation.Ex_07_Payload_management.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting028_RestAssured_Payload_Map {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_POST() {

        //        String payload_POST = "{\n" +
//                "    \"firstname\" : \"Lipi\",\n" +
//                "    \"lastname\" : \"Dubbaka\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Lunch\"\n" +
//                "}";

        // Hashmap -> key and value pair
        // Parent Hashmap ->  key and value , Child Hashmap

        Map<String, Object> JsonRequestBody = new LinkedHashMap<>();

        JsonRequestBody.put("firstname", "Lipi");
        JsonRequestBody.put("lastname", "Dubbaka");
        JsonRequestBody.put("totalprice", 111);
        JsonRequestBody.put("depositpaid", false);

        Map<String, Object> Bookingdates = new LinkedHashMap<>();
        Bookingdates.put("checkin", "2025-12-01"); // YYYY-MM-DD
        Bookingdates.put("checkout", "2025-12-05");

        JsonRequestBody.put("bookingdates", Bookingdates);
        JsonRequestBody.put("additionalneeds","Lunch");

        System.out.println(JsonRequestBody);

        rs = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/").basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(JsonRequestBody).log().all();

        response = rs.when().post();

        // Get Validatable response to perform validation
        vr = response.then().log().all();
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()
        vr.body("booking.firstname", Matchers.equalTo("Lipi"));
        vr.body("booking.lastname", Matchers.equalTo("Dubbaka"));
        vr.body("booking.depositpaid", Matchers.equalTo(false));
        vr.body("bookingid", Matchers.notNullValue());
    }
}
