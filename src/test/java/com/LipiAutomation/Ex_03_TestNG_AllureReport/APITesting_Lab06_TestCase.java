package com.LipiAutomation.Ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab06_TestCase {

    String pincode;

    @Test
    // valid pincode -> 110001
    public void Test_tc1_pincode_valid() {

        pincode = "500044";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    // #,$,%,@ - any special input = pincode
    public void Test_tc2_pincode_invalid() {

        pincode = "@";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    //  ' ' =  blank, pincode
    public void Test_tc3_pincode_invalid() {
        //  ' ' =  blank, pincode
        pincode = " ";

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }
}
