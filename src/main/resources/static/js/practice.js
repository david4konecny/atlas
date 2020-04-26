import { data } from "./countries-data.js";

// Constants
const mapUrl = 'mapbox://styles/dheiskdie/ck9gqaprj0knl1io05o41ad01/draft';
const centerCoordinates = [49.78, 20.74];
const lowerLeftBound = [32.03, -18.9];
const higherUpperBound = [71.86, 60.82];

// Map properties
const options = {
    center: centerCoordinates,
    zoom: 3.5,
    minZoom: 3.5,
    maxZoom: 5.5,
    zoomSnap: 0.5,
    zoomControl: false,
    maxBounds: [lowerLeftBound, higherUpperBound],
    maxBoundsViscosity: 1.0
};

// Initialize map
const map = L.map('map', options);

// Load map
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    id: 'dheiskdie/ck9gqaprj0knl1io05o41ad01/draft',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoiZGhlaXNrZGllIiwiYSI6ImNrOWdxNXVqZDA1ZjgzaG13YmQ3bzM2OHAifQ.3AfNGBc9QHBjGU1xNnuy2w'
}).addTo(map);

// Style geojson
function style(feature) {
    return {
        weight: 1,
        fillOpacity: 0.0
    };
}

// Add geojson
let geoLayer;

// Define listeners
function highlightCountry(e) {
    const layer = e.target;

    layer.setStyle({
        weight: 3,
        color: '#666',
        fillOpacity: 0.7
    });

    if (!L.Browser.ie && !L.Browser.opera && !L.Browser.edge) {
            layer.bringToFront();
    }
}

function resetHighlight(e) {
    geoLayer.resetStyle(e.target);
}

function onEachCountry(feature, layer) {
    layer.on({
        mouseover: highlightCountry,
        mouseout: resetHighlight
    })
}

// Init geoJSON layer
geoLayer = L.geoJson(data, {style: style, onEachFeature: onEachCountry});
geoLayer.addTo(map);