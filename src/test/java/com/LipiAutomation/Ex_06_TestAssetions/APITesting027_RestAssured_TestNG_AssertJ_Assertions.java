package com.LipiAutomation.Ex_06_TestAssetions;

import static org.assertj.core.api.Assertions.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    Integer bookingId;

    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Lipi\",\n" +
                "    \"lastname\" : \"Dubbaka\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        // Prepare request
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        // Send POST request
        response = requestSpecification.when().post();

        // Validate response status code and body using RestAssured Matchers
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Lipi"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dubbaka"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));

        // Extract values using JsonPath
        JsonPath jp = new JsonPath(response.asString());
        bookingId = jp.getInt("bookingid");
        String firstname = jp.getString("booking.firstname");
        String lastname = jp.getString("booking.lastname");

        // AssertJ assertions for dynamic and fixed values
        assertThat(bookingId).isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Lipi");
        assertThat(lastname).isEqualTo("Dubbaka");
        assertThat(jp.getInt("booking.totalprice")).isEqualTo(123);
        assertThat(jp.getBoolean("booking.depositpaid")).isFalse();

        // TestNG assertions for additional validation
        Assert.assertEquals(firstname, "Lipi");
        Assert.assertEquals(lastname, "Dubbaka");
        Assert.assertNotNull(bookingId);

        if (!firstname.contains("Lipi")) {
            Assert.fail("Failed kar diya Test");
        }
    }
}
