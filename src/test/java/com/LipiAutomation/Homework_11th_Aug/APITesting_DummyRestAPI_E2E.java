package com.LipiAutomation.Homework_11th_Aug;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.assertThat;

public class APITesting_DummyRestAPI_E2E {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;
    int id;

    @BeforeMethod
    public void waitBeforeTest() throws InterruptedException {
        Thread.sleep(45000); // Wait 45 seconds before each test to avoid rate limits
    }

    @Test(priority = 1)
    public void test_CreateAEmployee_NonBDD_Post() {

        String payload = "{\n" +
                "    \"name\": \"Vijaya\",\n" +
                "    \"salary\": \"99000\",\n" +
                "    \"age\": \"29\"\n" +
                "}";

        rs = RestAssured.given()
                .baseUri("https://dummy.restapiexample.com")
                .basePath("/api/v1/create")
                .contentType("application/json")
                .body(payload);

        response = rs.when().log().all().post();

        vr = response.then().log().all();
        vr.statusCode(200);

        id = response.jsonPath().getInt("data.id");
        System.out.println("ID from response: " + id);

        String status = response.jsonPath().getString("status");
        String name = response.jsonPath().getString("data.name");
        String salary = response.jsonPath().getString("data.salary");
        String age = response.jsonPath().getString("data.age");
        String message = response.jsonPath().getString("message");

        //Hamcrest Assertion
        vr.body("status", Matchers.notNullValue());
        vr.body("status", Matchers.equalTo(status));

        vr.body("data.name", Matchers.notNullValue());
        vr.body("data.name", Matchers.equalTo(name));

        vr.body("data.salary", Matchers.notNullValue());
        vr.body("data.salary", Matchers.equalTo(salary));

        vr.body("data.age", Matchers.notNullValue());
        vr.body("data.age", Matchers.equalTo(age));

        vr.body("data.id", Matchers.notNullValue());
        vr.body("data.id", Matchers.equalTo(id));

        vr.body("message", Matchers.notNullValue());
        vr.body("message", Matchers.equalTo(message));

        // JSON Schema Validation comparing from Path: test -> resources -> schemas -> create_employee_schema.json
        vr.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/create_employee_schema.json"));
    }

    // PutWithRetry method As its resulting (429 Too Many Requests)
    public Response putWithRetry(String baseUri, String basePath, String payload, int maxRetries, int waitTimeSeconds) throws InterruptedException {
        Response response = null;
        int retryCount = 0;

        while (retryCount <= maxRetries) {
            response = RestAssured.given()
                    .baseUri(baseUri)
                    .basePath(basePath)
                    .contentType("application/json")
                    .body(payload)
                    .when()
                    .put();

            if (response.statusCode() == 429) {
                System.out.println("Received 429 Too Many Requests. Retrying after " + waitTimeSeconds + " seconds...");
                Thread.sleep(waitTimeSeconds * 1000L);
                retryCount++;
            } else {
                break;
            }
        }
        return response;
    }

    @Test(priority = 2)
    public void UpdateEmployeeDetailsByID_NonBDD_PUT() throws InterruptedException {

        // Updates Employee Details By ID

        String payload = "{\n" +
                "    \"name\": \"Narayana\",\n" +
                "    \"salary\": \"90000\",\n" +
                "    \"age\": \"54\"\n" +
                "}";

        // Retry with max 3 attempts and 13 seconds wait time as per retry-after header
        response = putWithRetry("https://dummy.restapiexample.com", "/api/v1/update/" + id, payload, 3, 13);

        vr = response.then().log().all();
        vr.statusCode(200);

        //TestNG - Soft Assertion
        SoftAssert softAssert = new SoftAssert();

        String status = response.path("status");
        softAssert.assertEquals(status, "success", "Status is not success");

        String message = response.path("message");
        softAssert.assertEquals(message, "Successfully! Record has been updated.", "Message is not success");

        softAssert.assertAll();

        // TestNG - Hard Assertion
        String name = response.path("data.name");
        Assert.assertEquals(name, "Narayana", "Name is not as expected");
        System.out.println("Name assertion passed successfully.");
        Reporter.log("Name assertion passed successfully.");

        String salary = response.path("data.salary");
        Assert.assertEquals(salary, "90000", "Salary mismatch");
        System.out.println("Salary assertion passed successfully.");
        Reporter.log("Salary assertion passed successfully.");

        String age = response.path("data.age");
        Assert.assertEquals(age, "54", "Age mismatch");
        System.out.println("Age assertion passed successfully.");
        Reporter.log("Age assertion passed successfully.");

        // JSON Schema Validation comparing from Path: Path: test -> resources -> schemas -> update_employee_schema.json
        vr.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/update_employee_schema.json"));
    }

    // DeleteWithRetry method As its resulting (429 Too Many Requests)
    public Response deleteWithRetry(String baseUri, String basePath, int maxRetries, int waitTimeSeconds) throws InterruptedException {
        Response response = null;
        int retryCount = 0;

        while (retryCount <= maxRetries) {
            response = RestAssured.given()
                    .baseUri(baseUri)
                    .basePath(basePath)
                    .when()
                    .delete();

            if (response.statusCode() == 429) {
                System.out.println("Received 429 Too Many Requests. Retrying after " + waitTimeSeconds + " seconds...");
                Thread.sleep(waitTimeSeconds * 1000L);
                retryCount++;
            } else {
                break;
            }
        }
        return response;
    }


    @Test(priority = 3)
    public void test_DeleteEmployeeDetailsByID() throws InterruptedException {

        //Delete Employee Details By ID

        // Retry with max 3 attempts and 13 seconds wait time as per retry-after header
        response = deleteWithRetry("https://dummy.restapiexample.com", "/api/v1/delete/" + id, 3, 13);

        vr = response.then().log().all();
        vr.statusCode(200);

        //AsserJ Assertion
        String status = response.path("status");
        String message = response.path("message");

        assertThat(status)
                .as("Check delete status")
                .isEqualTo("success");

        assertThat(message)
                .as("Check delete message")
                .isEqualTo("Successfully! Record has been deleted");

        System.out.println("Delete assertion passed successfully.");
        Reporter.log("Delete assertion passed successfully.");
    }

}
