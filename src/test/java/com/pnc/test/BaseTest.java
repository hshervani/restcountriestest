package com.pnc.test;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    Properties prop;

    @BeforeClass
    public void setup() {

        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            prop = new Properties();
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  String getPropValue(String key){
        return prop.getProperty(key);
    }
}
