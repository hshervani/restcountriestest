package com.pnc.test;


import com.pnc.CapitalCity;
import com.pnc.CapitalCityService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CountryCapitalTests extends BaseTest {


    @Test(dataProvider = "capitalCity", dataProviderClass = TestDataSet.class)
    public void validateCountry(CapitalCity c){
        Assert.assertNotNull(c);
        CapitalCityService service = new CapitalCityService();
        Assert.assertNotNull(service.findCountryCapital(c));
        Assert.assertTrue(!service.findCountryCapital(c).isBlank());
    }

}
