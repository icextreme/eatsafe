# EatSafe
<p align="center">
  <img src="https://github.com/icextreme/eatsafe/blob/master/images/Welcome.png" height="342" width="180" align="center"/>
</p>

An Android app that allows users to browse restaurant inspection report history and view health violation tickets, written in Java.

## Features
* View restaurants near your current location using Google Maps.
* Mark your favourite restaurants for accessibility.
* Filter restaurants according to name, hazard level, number of violations, and/or favourites.
* Update inspection reports via welcome screen when an update is available

### Supported Languages
* English (CA)
* French (CA)

## Screenshots
<p align="center">
  <img src="https://github.com/icextreme/eatsafe/blob/master/images/Map.png" height="342" width="180"/>
  <img src="https://github.com/icextreme/eatsafe/blob/master/images/List.png" height="342" width="180"/>
  <img src="https://github.com/icextreme/eatsafe/blob/master/images/Inspections.png" height="342" width="180"/>
  <img src="https://github.com/icextreme/eatsafe/blob/master/images/Violations.png" height="342" width="180"/>
</p>

## Getting Started
### Prerequisites
* Android Studio
* Java 8 or higher
* Android Nougat (7.0) or higher device 

### Building
After cloning or downloading the project, open it up in Android Studio. Gradle will then be imported and the building will start.

## Usage
### General
* The toolbar allows for you to search or filter for restaurants.
* Navigate between the map and the list of restaurants using the overflow menu.

### Map Activity
* You can view all the restaurants that have inspection data on the map. The restaurants are marked with pegs, and coloured according to hazard level.
* Tap a peg to see the restaurant pop-up window that shows the name, most recent inspection date, and hazard level.
* Tap the pop-up window to see all the restaurant's inspection reports.

### List Activity
* The list of restaurants is sorted in alphabetical order. Scroll to your desired restaurant and tap it to view inspection reports.
* Each restaurant in the list has the following information displayed:
  * Restaurant name
  * Restaurant icon
  * Information about the restaurant's most recent inspection:
    * Number of issues found
    * Hazard level
    * Date of last inspection
    
### Restaurant Activity
* This is where you will view the details of a single restaurant. The restaurant's name, address, and GPS coordiantes are listed.
* You can also mark it as a favourite restaurant by pressing the star button that is under the restaurant details. 
* Click on the GPS coordinates to view the restaurant on the map.
* Inspections are colour-coded according to their hazard level.

### Inspection Activity
* The following details of a single restaurant's inspection report will be shown here:
  * Full date of inspection
  * Inspection type
  * Number of critical issues
  * Number of non-critical issues
  * Hazard level of the inspection
 * You can view more violations by scrolling through the list.
 * Violations are colour-coded based on whether or not it is a critical issue.
 * Tap on a violation to view its long description.

## Acknowledgements
Special thanks to my wonderful development team!

## Notes
* Inspection report data was gathered from the Surrey Open Data Catalogue, and therefore only restaurants in Surrey are available.
* You are unable to view the map as you will need to create a key and need to insert it into ``/src/debug/res/values/google_maps_api.xml``.

