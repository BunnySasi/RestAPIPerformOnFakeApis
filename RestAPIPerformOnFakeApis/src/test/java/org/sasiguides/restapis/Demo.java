package org.sasiguides.restapis;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.hamcrest.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.*;

public class Demo {
	
	public static RequestSpecification requestSpecification;
	public static ResponseSpecification responseSpecification;
	@Test
	public void ActivitiesGet() throws Exception {
		
		/* RequestSpecification */
		
		requestSpecification = new RequestSpecBuilder() 
				.setBaseUri("https://fakerestapi.azurewebsites.net/")
				.setBasePath("api/v1")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		/* ResponseSpecification */
		responseSpecification = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.expectStatusCode(200)
				.build();
		/*
		 * given()
		 * .when()
		 * .then()
		 * */
		given().spec(requestSpecification).when().get("/Activities").then().spec(responseSpecification)
		.extract().response().asString();	
	}
	

	@Test
	public void ActivitesGetById() throws Exception {
		requestSpecification = new RequestSpecBuilder() 
				.setBaseUri("https://fakerestapi.azurewebsites.net/")
				.setBasePath("api/v1")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		/* ResponseSpecification */
		responseSpecification = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.expectStatusCode(200)
				.build();
		given().spec(requestSpecification).when().get("Activities/1").then().spec(responseSpecification).extract().asString();
	}
	@Test
	public void postActivity() throws Exception {
		requestSpecification = new RequestSpecBuilder() 
				.setBaseUri("https://fakerestapi.azurewebsites.net/")
				.setBasePath("api/v1")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		/* ResponseSpecification */
		responseSpecification = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.expectStatusCode(200)
				.build();
		given().spec(requestSpecification).body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"title\": \"string\",\r\n"
				+ "  \"dueDate\": \"2023-11-09T10:38:43.056Z\",\r\n"
				+ "  \"completed\": true\r\n"
				+ "}").when().post("/Activities").then().spec(responseSpecification).extract().response().asString();
	}
	@Test
	public void updateActivity() throws Exception {
		requestSpecification = new RequestSpecBuilder() 
				.setBaseUri("https://fakerestapi.azurewebsites.net/")
				.setBasePath("api/v1")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		/* ResponseSpecification */
		responseSpecification = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.expectStatusCode(200)
				.build();
		given().spec(requestSpecification).body("{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"title\": \"string\",\r\n"
				+ "  \"dueDate\": \"2023-11-09T10:58:04.372Z\",\r\n"
				+ "  \"completed\": true\r\n"
				+ "}").when().put("/Activities/1").then().spec(responseSpecification).extract().response().asString();
		
	}
	@Test
	public void deleteActivity() throws Exception {
		
		requestSpecification = new RequestSpecBuilder() 
				.setBaseUri("https://fakerestapi.azurewebsites.net/")
				.setBasePath("api/v1")
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		/* ResponseSpecification */
		responseSpecification = new ResponseSpecBuilder()
				.log(LogDetail.ALL)
				.expectStatusCode(200)
				.build();
		
		given().spec(requestSpecification).when().delete("Activities/1").then().spec(responseSpecification)
		.extract().response().asString();
	}
}
