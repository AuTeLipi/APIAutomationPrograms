package com.LipiAutomation.Restful;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.atomic.AtomicInteger;

public class APITesting_Restfulbooker_E2E_WithPatchUpdate1 {

    RequestSpecification r;
    Response response;
    String token;
    AtomicInteger bookingid = new AtomicInteger();

    @Test(priority = 1)
    public void generateToken() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        r = RestAssured.given().contentType(ContentType.JSON)
                .body("{\"username\":\"admin\",\"password\":\"password123\"}");
        response = r.post("/auth");
        token = response.jsonPath().getString("token");
        Assert.assertNotNull(token, "Token should not be null");
        System.out.println("Generated Token: " + token);
    }

    @Test(priority = 2, dependsOnMethods = {"generateToken"})
    public void createBooking() {
        r = RestAssured.given().contentType(ContentType.JSON)
                .body("{\"firstname\":\"Alice\",\"lastname\":\"Brown\",\"totalprice\":120,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-09-01\",\"checkout\":\"2025-09-05\"},\"additionalneeds\":\"Dinner\"}");
        response = r.post("/booking");
        bookingid.set(response.jsonPath().getInt("bookingid"));
        System.out.println("Booking ID: " + bookingid.get());
        Assert.assertTrue(bookingid.get() > 0, "Booking ID should be greater than 0");
    }


    @Test(priority = 3, dependsOnMethods = {"createBooking"})
    public void getBooking() {
        r = RestAssured.given().contentType(ContentType.JSON);
        response = r.get("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 200, "GET Booking should return 200");
        System.out.println("GET Booking Response: " + response.asString());
    }

    @Test(priority = 4, dependsOnMethods = {"generateToken", "createBooking"})
    public void updateBookingPatch() {
        r = RestAssured.given().contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body("{\"firstname\":\"Alicia\",\"lastname\":\"Brownie\"}");
        response = r.patch("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Alicia");
    }

    @Test(priority = 5, dependsOnMethods = {"generateToken", "createBooking"})
    public void deleteBooking() {
        r = RestAssured.given().header("Cookie", "token=" + token);
        response = r.delete("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Booking Deleted Successfully");
    }
}
