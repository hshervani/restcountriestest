package com.pnc.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CapitalEndPointTests extends BaseTest {

    public final String capitalJson = "countrycapital.json";

    @BeforeClass
    @Override
    public void setup() {
        super.setup();
        RestAssured.baseURI = getPropValue("restcountries.url");
        RestAssured.basePath =getPropValue("restcountries.capital.path");
    }

    @Test(dataProvider = "statusCodes", dataProviderClass = TestDataSet.class)
    public void statusCodesTest(String city, String statusCode) {
//        RestAssured.basePath =getPropValue("restcountries.capital.path");
        given().when().get("/" + city).then().statusCode(Integer.parseInt(statusCode));

    }


    @Test(dataProvider = "validCapitals", dataProviderClass = TestDataSet.class)
    public void apiEndPointValidCapitolTest(String capitalName) {
        given().when().get("/" + capitalName).then().statusCode(200);

    }

    @Test(dataProvider = "invalidCapitals", dataProviderClass = TestDataSet.class)
    public void apiEndPointInValidCapitolTest(String capitalName) {
        given().when().get("/" + capitalName).then().statusCode(404);

    }

    @Test
    public void countrySchemaValidation() {
        given().when().get("/lima").then().assertThat().body(matchesJsonSchemaInClasspath(capitalJson));
    }


}
