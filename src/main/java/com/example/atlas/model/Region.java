package com.example.atlas.model;

public class Region {
    private String name;
    private String[] countries;
    private double[] centerCoordinates;
    private double[] lowerLeftBound;
    private double[] upperRightBound;

    public Region() {}

    public Region(String name, String[] countries, double[] centerCoordinates, double[] lowerLeftBound, double[] upperRightBound) {
        this.name = name;
        this.countries = countries;
        this.centerCoordinates = centerCoordinates;
        this.lowerLeftBound = lowerLeftBound;
        this.upperRightBound = upperRightBound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
