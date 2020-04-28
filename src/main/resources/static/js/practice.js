import { data } from "./countries-data.js";

// Constants
const mapUrl = 'mapbox://styles/dheiskdie/ck9gqaprj0knl1io05o41ad01/draft';

// Map properties
const options = {
    center: region.centerCoordinates,
    zoom: 3.5,
    minZoom: 3.5,
    maxZoom: 5.5,
    zoomSnap: 0.2,
    zoomControl: false,
    maxBounds: [region.lowerLeftBound, region.upperRightBound],
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

// Get countries to practice (practice items due + new countries)
const today = new Date().toISOString().substring(0, 10); // E.g 2020-04-27
const practicedItems = practiceItems.map(i => i.country); // Countries already practiced
const countriesDue = practiceItems.filter(i => i.nextReview <= today).map(i => i.country); // Countries due for practice
console.log('Countries due:');
console.log(countriesDue);
const countriesNotPracticed = region.countries.filter(i => !practicedItems.includes(i));
console.log('Countries new:');
console.log(countriesNotPracticed);
const countriesToReview = countriesDue.concat(countriesNotPracticed);
console.log('Countries to review:')
console.log(countriesToReview);

let hintDisplayed = false;

function onCorrectAnswer() {
    if (hintDisplayed) {
        countriesToReview.pop();
        countriesToReview.splice(0, 0, targetCountry);
        hintDisplayed = false;
        promptNextCountry();
        return;
    }
    countriesLeft--;
    document.querySelector('#countries-left').textContent = countriesLeft;
    countriesToReview.pop();
    if (countriesDue.includes(targetCountry)) {
        let id = practiceItems.find(i => i.country === targetCountry).id;
        increaseMemoryStrength(id);
    } else {
        addNewPracticeItem(targetCountry, region.name);
    }
    promptNextCountry();
}

function onWrongAnswer() {
    if (countriesDue.includes(targetCountry)) {
        let id = practiceItems.find(i => i.country === targetCountry).id;
        resetMemoryStrength(id);
    }
    onDisplayCountry();
}

let countriesLeft = countriesToReview.length;
let targetCountry;
function promptNextCountry() {
    if (countriesLeft > 0) {
        targetCountry = countriesToReview[countriesLeft - 1];
        document.querySelector('#country').textContent = targetCountry;
    } else {
        showCongratsScreen();
    }
}

function showCongratsScreen() {
    document.querySelector('#map-area').style.display = 'none';
    document.querySelector('#finished-message').style.display = 'block';
}

// Click listener
function checkAnswer(e) {
    const layer = e.target;
    let clickedCountry = layer.feature.properties.name;
    if (clickedCountry === targetCountry) {
        onCorrectAnswer();
    } else {
        onWrongAnswer();
    }
}
// Set all listeners
function onEachCountry(feature, layer) {
    layer.on({
        mouseover: highlightCountry,
        mouseout: resetHighlight,
        click: checkAnswer,
    })
}

// Display answer
function onDisplayCountry() {
    hintDisplayed = true;
    // find layer of the target country
    const layer = geoLayer.getLayers().find(l => l.feature.properties.name === targetCountry);
    // change the fill color
    layer.setStyle({
        weight: 3,
        color: '#ff9400',
        fillOpacity: 0.7
    })
}

function setUpButtonListener() {
    document.querySelector('#display-country').addEventListener('click', onDisplayCountry);
}

function increaseMemoryStrength(id) {
    const xhr = new XMLHttpRequest();
    xhr.open('PUT', '/practice/item/increase/' + id);
    xhr.send();
}

function resetMemoryStrength(id) {
    const xhr = new XMLHttpRequest();
    xhr.open('PUT', '/practice/item/reset/' + id);
    xhr.send();
}

function addNewPracticeItem(country, regionName) {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/practice/item/add');
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    const data = `country=${country}&region=${regionName}&_csrf=${csrfToken}`;
    xhr.send(data);
}

// Init geoJSON layer
geoLayer = L.geoJson(data, {style: style, onEachFeature: onEachCountry});
geoLayer.addTo(map);

// Init practice
setUpButtonListener();
document.querySelector('#countries-left').textContent = countriesLeft;
promptNextCountry();