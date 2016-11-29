# Floor Space Management

## Installation:
1. Create database (see [mydb.sql](https://github.com/AmeyKamat/FSM/blob/master/mydb.sql))
2. Ensure that `src/main` and `src/config` are in classpath
3. Do `maven clean install`
4. Edit [app.properties](https://github.com/AmeyKamat/FSM/blob/master/config/app.properties) file for upload location and database properties. 
6. Done!

## FSM API
The following section describes APIs provided by the project:

```
1. {root}/layoutFile/upload
Attributes: file (MultipartFile), floorId(int)  
Uploads Excel file to the server, parses the file, stores parsed floor object in the session and returns parsed floor as JSON.

2. {root}/layoutFile/publish
Attributes: toBePublished(boolean)
Publishes the floor object in the session to the database if true. Removes floor object from session if false.

3. {root}/countries
Attributes: none
Returns all available countries as JSON.

4. {root}/countries/{countryId}
Attributes: countryId(int)
Returns country with id {countryId} as JSON.

5. {root}/countries/{countryId}/cities
Attributes: countryId(int)
Returns cities in a country with id {countryId}

6. {root}/cities/{cityId}
Attributes: cityId(int)
Returns city with id {cityId} as JSON.

7. {root}/cities/{cityId}/locations
Attributes: cityId(int)
Returns locations in a city with id {cityId}.

8. {root}/locations/{locationId}
Attributes: locationId(int)
Returns location with id {locationId} as JSON.

9. {root}/locations/{locationId}/floors
Attributes: locationId(int)
Returns floors in a location with id {locationId},

10. {root}/floors/{floorId}
Attributes: floorId(int)
Returns floor layout for a floor with id {floorId}

```