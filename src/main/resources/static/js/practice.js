import { data } from "./countries-data.js";

// Values
const mapUrl = 'mapbox://styles/dheiskdie/ck9gqaprj0knl1io05o41ad01/draft';
const centerCoordinates = [52.27, 21.09];
const lowerLeftBound = [35.85, -12.3];
const higherUpperBound = [71.86, 60.82];

// Map properties
const options = {
    center: centerCoordinates,
    zoom: 4,
    minZoom: 3,
    maxZoom: 5,
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

