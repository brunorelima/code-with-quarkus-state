package com.brunolima.quarkus.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class StateResourceTest {

	@Test
	public void testRetornListStates() {
		RestAssured.given().when().get("/states").then().statusCode(200);
	}

}
