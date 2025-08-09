package com.LipiAutomation.Restful;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class APITesting_Restfulbooker_E2E_WithFullUpdate1 {

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

    @Test(priority = 2)
    public void createBooking() {
        r = RestAssured.given().contentType(ContentType.JSON)
                .body("{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":150,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2025-08-01\",\"checkout\":\"2025-08-05\"},\"additionalneeds\":\"Breakfast\"}");
        response = r.post("/booking");
        bookingid.set(response.jsonPath().getInt("bookingid"));
        System.out.println("Booking ID: " + bookingid.get());
        Assert.assertTrue(bookingid.get() > 0, "Booking ID should be greater than 0");
    }

    @Test(priority = 3, dependsOnMethods = {"generateToken", "createBooking"})
    public void getBooking() {
        r = RestAssured.given().contentType(ContentType.JSON);
        response = r.get("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 200, "GET Booking should return 200");
        Assert.assertEquals(response.jsonPath().getString("firstname"), "John");
        Assert.assertEquals(response.jsonPath().getString("lastname"), "Doe");
        System.out.println("GET Booking Response: " + response.asString());
    }

    @Test(priority = 4, dependsOnMethods = {"generateToken", "createBooking"})
    public void updateBookingFull() {
        r = RestAssured.given().contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body("{\"firstname\":\"Jane\",\"lastname\":\"Smith\",\"totalprice\":200,\"depositpaid\":false,\"bookingdates\":{\"checkin\":\"2025-08-10\",\"checkout\":\"2025-08-15\"},\"additionalneeds\":\"Lunch\"}");
        response = r.put("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Jane");
    }

    @Test(priority = 5, dependsOnMethods = {"generateToken", "createBooking"})
    public void deleteBooking() {
        r = RestAssured.given().header("Cookie", "token=" + token);
        response = r.delete("/booking/" + bookingid.get());
        Assert.assertEquals(response.getStatusCode(), 201);
        System.out.println("Booking Deleted Successfully");
    }
}

