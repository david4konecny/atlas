package com.example.atlas.model;

public final class Region {
    private final String id;
    private final String name;
    private final String[] countries;
    private final double[] centerCoordinates;
    private final double[] lowerLeftBound;
    private final double[] upperRightBound;

    private Region(String id, String name, String[] countries, double[] centerCoordinates, double[] lowerLeftBound, double[] upperRightBound) {
        this.id = id;
        this.name = name;
        this.countries = countries;
        this.centerCoordinates = centerCoordinates;
        this.lowerLeftBound = lowerLeftBound;
        this.upperRightBound = upperRightBound;
    }

    public static Builder create(String id, String name) {
        return new Builder(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getCountries() {
        return countries;
    }

    public double[] getCenterCoordinates() {
        return centerCoordinates;
    }

    public double[] getLowerLeftBound() {
        return lowerLeftBound;
    }

    public double[] getUpperRightBound() {
        return upperRightBound;
    }

    public int getNumOfCountries() {
        return countries.length;
    }

    public static class Builder {
        private final String id;
        private final String name;
        private String[] countries = {};
        private double[] centerCoordinates = new double[2];
        private double[] lowerLeftBound = new double[2];
        private double[] upperRightBound = new double[2];

        private Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder countries(String[] countries) {
            this.countries = countries;
            return this;
        }

        public Builder centerCoordinates(double[] centerCoordinates) {
            this.centerCoordinates = centerCoordinates;
            return this;
        }

        public Builder lowerLeftBound(double[] lowerLeftBound) {
            this.lowerLeftBound = lowerLeftBound;
            return this;
        }

        public Builder upperRightBound(double[] upperRightBound) {
            this.upperRightBound = upperRightBound;
            return this;
        }

        public Region build() {
            return new Region(id, name, countries, centerCoordinates, lowerLeftBound, upperRightBound);
        }
    }
}
