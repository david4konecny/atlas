package com.example.atlas.repository;

import com.example.atlas.model.Region;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsData {
    public static final Map<String, Region> REGIONS = new TreeMap<>();
    public static final Map<String, Integer> NUM_OF_COUNTRIES_PER_REGION = new HashMap<>();

    static {
        REGIONS.put("europe", europeRegion());
        REGIONS.put("asia", asiaRegion());
        REGIONS.put("africa", africaRegion());
        REGIONS.put("n-america", northAmericaRegion());
        REGIONS.put("s-america", southAmericaRegion());
        REGIONS.put("oceania", oceaniaRegion());
        REGIONS.forEach((name, region) -> NUM_OF_COUNTRIES_PER_REGION.put(name, region.getNumOfCountries()));
    }

    private static Region europeRegion() {
        Region region = new Region();
        region.setName("europe");
        region.setDisplayName("Europe");
        region.setCountries(europeCountries());
        region.setCenterCoordinates(new double[] { 49.78, 20.74 });
        region.setLowerLeftBound(new double[] { 32.03, -18.9 });
        region.setUpperRightBound(new double[] { 71.86, 60.82 });
        return region;
    }

    private static Region asiaRegion() {
        Region region = new Region();
        region.setName("asia");
        region.setDisplayName("Asia");
        region.setCountries(asiaCountries());
        region.setCenterCoordinates(new double[] { 43.07, 88.24 });
        region.setLowerLeftBound(new double[] { 12.9, 27.95 });
        region.setUpperRightBound(new double[] { 64.62, 161.89 });
        return region;
    }

    private static Region africaRegion() {
        Region region = new Region();
        region.setName("africa");
        region.setDisplayName("Africa");
        region.setCountries(africaCountries());
        region.setCenterCoordinates(new double[] { 0, 21 });
        region.setLowerLeftBound(new double[] { -46, -27 });
        region.setUpperRightBound(new double[] { 42, 69 });
        return region;
    }

    private static Region northAmericaRegion() {
        Region region = new Region();
        region.setName("n-america");
        region.setDisplayName("North America");
        region.setCountries(northAmericaCountries());
        region.setCenterCoordinates(new double[] { 53, -89 });
        region.setLowerLeftBound(new double[] { -4, -177 });
        region.setUpperRightBound(new double[] { 75, -32 });
        return region;
    }

    private static Region southAmericaRegion() {
        Region region = new Region();
        region.setName("s-america");
        region.setDisplayName("South America");
        region.setCountries(southAmericaCountries());
        region.setCenterCoordinates(new double[] { -26, -57 });
        region.setLowerLeftBound(new double[] { -61, -109 });
        region.setUpperRightBound(new double[] { 21, -8 });
        return region;
    }

    private static Region oceaniaRegion() {
        Region region = new Region();
        region.setName("oceania");
        region.setDisplayName("Oceania");
        region.setCountries(oceaniaCountries());
        region.setCenterCoordinates(new double[] { -24, 140 });
        region.setLowerLeftBound(new double[] { -54, 83 });
        region.setUpperRightBound(new double[] { 20, 179 });
        return region;
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
                "Cambodia",
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
                "Papua New Guinea",
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
                "Trinidad and Tobago",
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
                "Philippines"
        };
    }

}
