package com.pnc;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Iterator;

public class CapitalCityService {


    public String findCountryCapital(CapitalCity city) {
        RestAssured.baseURI = city.getUri()+city.getPath();
            RequestSpecification httprequest = RestAssured.given();
            Response response = httprequest.request(Method.GET, city.getCountryCityName());
        System.out.println(response.getBody().asString());
            return extractCapitolCityFromResponse(response.getBody().asString(), city.getCapitalElement());
    }

    public static String extractCapitolCityFromResponse(String json, String capitalElement){
        JsonArray jsonArray = new Gson().fromJson(json, JsonArray.class);
        Iterator<JsonElement> it = jsonArray.iterator();
        String result = "";
        while(it.hasNext()){
            JsonObject jobj = (JsonObject) it.next();
            result = jobj.get(capitalElement).toString();
        }
        return result;
    }
}
