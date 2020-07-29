package com.example.atlas.repository;

import com.example.atlas.model.Region;

import java.util.*;

public final class MapsData {
    private static final Map<String, Region> regions = new TreeMap<>();
    private static final Map<String, Integer> numOfCountriesPerRegion = new HashMap<>();

    static {
        regions.put("europe", europeRegion());
        regions.put("asia", asiaRegion());
        regions.put("africa", africaRegion());
        regions.put("n-america", northAmericaRegion());
        regions.put("s-america", southAmericaRegion());
        regions.put("oceania", oceaniaRegion());
        regions.forEach((name, region) -> numOfCountriesPerRegion.put(name, region.getNumOfCountries()));
    }

    private MapsData() {};

    public static Collection<Region> getRegions() {
        return regions.values();
    }

    public static Region getRegion(String id) {
        return regions.get(id);
    }

    public static Map<String, Integer> getNumberOfCountriesPerRegion() {
        return numOfCountriesPerRegion;
    }

    public static Collection<String> getRegionIds() {
        return regions.keySet();
    }

    public static boolean isCountryInRegion(String country, String regionName) {
        Region region = regions.get(regionName);
        if (region != null)
            return Arrays.asList(region.getCountries()).contains(country);
        return false;
    }

    private static Region europeRegion() {
        return Region.create("europe", "Europe")
                .countries(europeCountries())
                .centerCoordinates(new double[] { 49.78, 20.74 })
                .lowerLeftBound(new double[] { 24, -29 })
                .upperRightBound(new double[] { 74, 65 })
                .build();
    }

    private static Region asiaRegion() {
        return Region.create("asia", "Asia")
                .countries(asiaCountries())
                .centerCoordinates(new double[] { 43.07, 88.24 })
                .lowerLeftBound(new double[] { -15, 15 })
                .upperRightBound(new double[] { 75, 178 })
                .build();
    }

    private static Region africaRegion() {
        return Region.create("africa", "Africa")
                .countries(africaCountries())
                .centerCoordinates(new double[] { 0, 21 })
                .lowerLeftBound(new double[] { -48, -32 })
                .upperRightBound(new double[] { 45, 75 })
                .build();
    }

    private static Region northAmericaRegion() {
        return Region.create("n-america", "North America")
                .countries(northAmericaCountries())
                .centerCoordinates(new double[] { 53, -89 })
                .lowerLeftBound(new double[] { -4, -177 })
                .upperRightBound(new double[] { 85, -25 })
                .build();
    }

    private static Region southAmericaRegion() {
        return Region.create("s-america", "South America")
                .countries(southAmericaCountries())
                .centerCoordinates(new double[] { -26, -57 })
                .lowerLeftBound(new double[] { -65, -125 })
                .upperRightBound(new double[] { 21, 2 })
                .build();
    }

    private static Region oceaniaRegion() {
        return Region.create("oceania", "Oceania")
                .countries(oceaniaCountries())
                .centerCoordinates(new double[] { -24, 140 })
                .lowerLeftBound(new double[] { -54, 83 })
                .upperRightBound(new double[] { 35, 179 })
                .build();
    }

    private static String[] europeCountries() {
        return new String[] {
                "Albania",
                "Austria",
                "Belgium",
                "Bulgaria",
                "Bosnia and Herzegovina",
                "Belarus",
                "Switzerland",
                "Northern Cyprus",
                "Cyprus",
                "Czech Republic",
                "Germany",
                "Denmark",
                "Spain",
                "Estonia",
                "Finland",
                "France",
                "United Kingdom",
                "Greece",
                "Croatia",
                "Hungary",
                "Ireland",
                "Iceland",
                "Italy",
                "Kosovo",
                "Lithuania",
                "Luxembourg",
                "Latvia",
                "Moldova",
                "Macedonia",
                "Malta",
                "Montenegro",
                "Netherlands",
                "Norway",
                "Poland",
                "Portugal",
                "Romania",
                "Russia",
                "Republic of Serbia",
                "Slovakia",
                "Slovenia",
                "Sweden",
                "Turkey",
                "Ukraine"
        };
    }

    private static String[] asiaCountries() {
        return new String[] {
                "Afghanistan",
                "United Arab Emirates",
                "Armenia",
                "Azerbaijan",
                "Bangladesh",
                "Brunei",
                "Bhutan",
                "Cambodia",
                "China",
                "Georgia",
                "India",
                "Iran",
                "Iraq",
                "Israel",
                "Japan",
                "South Korea",
                "Kazakhstan",
                "Kuwait",
                "Jordan",
                "Kyrgyzstan",
                "Laos",
                "Lebanon",
                "Sri Lanka",
                "Myanmar",
                "Mongolia",
                "Nepal",
                "Oman",
                "Pakistan",
                "North Korea",
                "Qatar",
                "Saudi Arabia",
                "Syria",
                "Thailand",
                "Tajikistan",
                "Turkmenistan",
                "Taiwan",
                "Uzbekistan",
                "Vietnam",
                "Yemen"
        };
    }

    private static String[] africaCountries() {
        return new String[] {
                "Angola",
                "Burundi",
                "Benin",
                "Burkina Faso",
                "Botswana",
                "Central African Republic",
                "Ivory Coast",
                "Cameroon",
                "Democratic Republic of the Congo",
                "Republic of the Congo",
                "Djibouti",
                "Algeria",
                "Egypt",
                "Eritrea",
                "Ethiopia",
                "Gabon",
                "Ghana",
                "Guinea",
                "Gambia",
                "Guinea Bissau",
                "Equatorial Guinea",
                "Kenya",
                "Liberia",
                "Libya",
                "Lesotho",
                "Madagascar",
                "Mali",
                "Mozambique",
                "Mauritania",
                "Malawi",
                "Morocco",
                "Namibia",
                "Niger",
                "Nigeria",
                "Rwanda",
                "Western Sahara",
                "Sudan",
                "South Sudan",
                "Senegal",
                "Sierra Leone",
                "Somaliland",
                "Somalia",
                "Swaziland",
                "Chad",
                "Togo",
                "Tunisia",
                "United Republic of Tanzania",
                "Uganda",
                "South Africa",
                "Zambia",
                "Zimbabwe"
        };
    }

    private static String[] northAmericaCountries() {
        return new String[] {
                "Belize",
                "Canada",
                "Costa Rica",
                "Cuba",
                "Dominican Republic",
                "Greenland",
                "Guatemala",
                "Honduras",
                "Haiti",
                "Jamaica",
                "Mexico",
                "Nicaragua",
                "Panama",
                "Puerto Rico",
                "El Salvador",
                "United States of America"
        };
    }

    private static String[] southAmericaCountries() {
        return new String[] {
                "Argentina",
                "Bolivia",
                "Brazil",
                "Chile",
                "Colombia",
                "Ecuador",
                "Falkland Islands",
                "French Guiana",
                "Guyana",
                "Peru",
                "Paraguay",
                "Suriname",
                "Trinidad and Tobago",
                "Uruguay",
                "Venezuela"
        };
    }

    private static String[] oceaniaCountries() {
        return new String[] {
                "Australia",
                "Indonesia",
                "Malaysia",
                "New Zealand",
                "Papua New Guinea",
                "Philippines"
        };
    }

}
