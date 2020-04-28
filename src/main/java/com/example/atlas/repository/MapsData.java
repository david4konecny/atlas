package com.example.atlas.repository;

import com.example.atlas.model.Region;

import java.util.HashMap;
import java.util.Map;

public class MapsData {
    public static final Map<String, Region> REGIONS = new HashMap<>();

    static {
        REGIONS.put("europe", europeRegion());
        REGIONS.put("asia", asiaRegion());
    }

    private static Region europeRegion() {
        Region region = new Region();
        region.setName("europe");
        region.setCountries(europeanCountries());
        region.setCenterCoordinates(new double[] { 49.78, 20.74 });
        region.setLowerLeftBound(new double[] { 32.03, -18.9 });
        region.setUpperRightBound(new double[] { 71.86, 60.82 });
        return region;
    }

    private static Region asiaRegion() {
        Region region = new Region();
        region.setName("asia");
        region.setCountries(asianCountries());
        region.setCenterCoordinates(new double[] { 43.07, 88.24 });
        region.setLowerLeftBound(new double[] { 12.9, 27.95 });
        region.setUpperRightBound(new double[] { 64.62, 161.89 });
        return region;
    }

    private static String[] europeanCountries() {
        return new String[] {
                "Austria",
                "Belgium",
                "Belarus",
                "Switzerland",
                "Northern Cyprus",
                "Cyprus",
                "Czech Republic",
                "Germany",
                "Denmark",
                "Spain"
        };
    }

    private static String[] asianCountries() {
        return new String[] {
                "Afghanistan",
                "United Arab Emirates",
                "Azerbaijan",
                "Bangladesh",
                "China",
                "Japan",
                "South Korea",
                "Kuwait"
        };
    }

}
