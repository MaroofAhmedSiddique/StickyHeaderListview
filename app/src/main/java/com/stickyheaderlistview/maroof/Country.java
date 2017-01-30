package com.stickyheaderlistview.maroof;

/**
 * Created by Maroof Ahmed Siddique on 1/23/2017.
 */
public class Country {

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }



    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    String countrycode = "";
    String countryName = "";

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public void setCountryLanguage(String countryLanguage) {
        this.countryLanguage = countryLanguage;
    }

    String countryLanguage = "";

}
