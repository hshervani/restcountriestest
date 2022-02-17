package com.pnc;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

import static com.pnc.PropertyUtil.getPropValue;

public class CountryDetails {

    public static void main(String[] args) {
        PropertyUtil.setup();
        String uri  = getPropValue("restcountries.url");
        String path  = getPropValue("restcountries.countries.path");
        String capitalElement  = getPropValue("restcountries.capital.element");
        Scanner scanInput = new Scanner (System.in);
        CapitalCityService capitalCityService = new CapitalCityService();
        while (true) {
            System.out.print("Please enter country name for which you need details for: ");
            String countryName = scanInput.next();
            if((StringUtils.isBlank(countryName)) || countryName.length() <2 ){
                System.out.print("oops, input not valid , let's try again... ");
                continue;
            }
            CapitalCity city = new CapitalCity(uri,path,capitalElement,countryName);
            System.out.println("Capital City for the Country Entered " +countryName +" is :" +capitalCityService.findCountryCapital(city) );

        }
    }
}
