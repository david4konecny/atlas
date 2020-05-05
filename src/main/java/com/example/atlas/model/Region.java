package com.example.atlas.model;

public class Region {
    private String name;
    private String displayName;
    private String[] countries;
    private double[] centerCoordinates;
    private double[] lowerLeftBound;
    private double[] upperRightBound;

    public Region() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public double[] getCenterCoordinates() {
        return centerCoordinates;
    }

    public void setCenterCoordinates(double[] centerCoordinates) {
        this.centerCoordinates = centerCoordinates;
    }


    public double[] getLowerLeftBound() {
        return lowerLeftBound;
    }

    public void setLowerLeftBound(double[] lowerLeftBound) {
        this.lowerLeftBound = lowerLeftBound;
    }

    public double[] getUpperRightBound() {
        return upperRightBound;
    }

    public void setUpperRightBound(double[] upperRightBound) {
        this.upperRightBound = upperRightBound;
    }

    public int getNumOfCountries() {
        return countries.length;
    }
}
