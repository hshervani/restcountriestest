package com.pnc.test;

import com.pnc.CapitalCity;
import com.pnc.PropertyUtil;
import org.testng.annotations.DataProvider;

import static com.pnc.PropertyUtil.getPropValue;

public class TestDataSet {

    @DataProvider(name = "validCapitals")
    public Object[] createValidCapitalData() {
        return new String[]
                {"lima","berlin","delhi", "washington"};
    }


    @DataProvider(name = "invalidCapitals")
    public Object[] createInValidCapitalData() {
        return new String[]
                {"seattle","dubai","canada", "000", ""};
    }

    @DataProvider(name = "statusCodes")
    public Object[][] createStatusCodeData(){
        return new String[][]
                {{"lima","200"},{"limas","404"}};
    }

    @DataProvider(name = "capitalCity")
    public Object[] createCapitalCityData(){
        PropertyUtil.setup();
        String uri  = getPropValue("restcountries.url");
        String path  = getPropValue("restcountries.countries.path");
        String capitalElement  = getPropValue("restcountries.capital.element");
        CapitalCity capitalCity1 = new CapitalCity(uri,path,capitalElement,"peru");
        CapitalCity capitalCity2 = new CapitalCity(uri,path,capitalElement,"america");
        return new Object[]
                {capitalCity1, capitalCity2};
    }
}
