package com.example.inventoryservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer  mysqlContainer = new MySQLContainer<>("mysql:8.3.0");

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port = port;
	}

	static {
		mysqlContainer.start();
	}
	@Test
	void shouldReadInventory() {
		RestAssured.given()
				.queryParam("skuCode", "SKU123")
				.queryParam("quantity", 10)
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.body(Matchers.is("true"));
		RestAssured.given()
				.queryParam("skuCode", "SKU123")
				.queryParam("quantity", 101)
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.body(Matchers.is("false"));
	}

}
