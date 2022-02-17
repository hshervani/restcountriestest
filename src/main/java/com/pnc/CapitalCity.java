package com.pnc;

public class CapitalCity {

    String uri;
    String path;
    String capitalElement;
    String countryName;

    public CapitalCity() {
    }

    public CapitalCity(String uri, String path, String capitalElement, String countryCityName) {
        this.uri = uri;
        this.path = path;
        this.capitalElement = capitalElement;
        this.countryName = countryCityName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCapitalElement() {
        return capitalElement;
    }

    public void setCapitalElement(String capitalElement) {
        this.capitalElement = capitalElement;
    }

    public String getCountryCityName() {
        return countryName;
    }

    public void setCountryCityName(String countryCityName) {
        this.countryName = countryCityName;
    }
}
