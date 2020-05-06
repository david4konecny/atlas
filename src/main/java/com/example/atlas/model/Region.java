package com.example.atlas.model;

public class Region {
    private String id;
    private String name;
    private String[] countries;
    private double[] centerCoordinates;
    private double[] lowerLeftBound;
    private double[] upperRightBound;

    public Region() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getNumOfCountries() {
        return countries.length;
    }
}
