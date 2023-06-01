1. En sample_training.zips ¿Cuántas colecciones tienen menos de 1000 personas en el campo pop? (sol. 8065):

		db.zips.find({"pop": {"$lt": 1000}}).count()

2. En sample_training.trips ¿Cuál es la diferencia entre la gente que nació en 1998 y la que nació después de 1998? (sol.6):
	
		db.trips.aggregate([{ $facet: { count1: [{ $match: { "birth year": { $eq: 1998 } } }, { $count: "count" }], count2: [{ $match: { "birth year": { $gt: 1998 } } }, { $count: "count" }] } }, { $project: { difference: { $subtract: [{ $arrayElemAt: ["$count1.count", 0] }, { $arrayElemAt: ["$count2.count", 0] }] } } }]);


3. En sample_training.routes ¿Cuántas rutas tienen al menos una parada? (sol. 11):

		db.routes.find({"stops": { "$gte" : 1}}).count()	

4. En sample_training.inspections ¿Cuántos negocios tienen un resultado de inspección "Out of Business" y pertenecen al sector "Home Improvement Contractor -100"? (sol. 4):

		db.inspections.find({"result" : { "$eq": "Out of Business"}, "sector": { "$eq":"Home Improvement Contractor - 
		100"}}).count()

		db.inspections.find({"result" : "Out of Business", "sector": "Home Improvement Contractor - 100"}).count()

5. En sample_training.inspections ¿Cuántos documentos hay con fecha de inspección "Feb 20 2015" o "Feb 21 2015" y
cuyo sector no sea "Cigarette Retail Dealer - 127"? (sol.204):

		db.inspections.find({ "$and": [ {"$or": [{"date": "Feb 20 2015"}, {"date": "Feb 21 2015"}]}, { "$nor":[{ "sector": "Cigarette Retail Dealer - 127"}]}]}).count()


----------------------------EJ2------------------------------------

1. En sample_training.companies, ¿cuántas empresas tienen más empleados que el año en el que se fundaron? (sol. 324):



2. En sample_training.companies, ¿en cuántas empresas coinciden su permalink con su twitter_username? (sol.1299):



3. En sample_airbnb.listingsAndReviews, ¿cuál es el nombre del alojamiento en el que pueden estar más de 6 personas
alojadas y tiene exactamente 50 reviews? (sol. Sunset Beach Lodge Retreat):



4. En sample_airbnb.listingsAndReviews, ¿cuántos documentos tienen el "property_type" "House" e incluyen
"Changing table" como una de las "amenities"? (sol. 11):



5. En sample_training.companies, ¿Cuántas empresas tienen oficinas en Seattle? (sol. 117):



6. En sample_training.companies, haga una query que devuelva únicamente el nombre de las empresas que tengan exactamente 8 "funding_rounds":



7. En sample_training.trips, ¿cuántos viajes empiezan en estaciones que están al oeste de la longitud -74? (sol. 1928)
Nota 1: Hacia el oeste la longitud decrece
Nota 2: el formato es <field_name>: [ <longitud>, <latitud> ]:



8. En sample_training.inspections, ¿cuántas inspecciones se llevaron a cabo en la ciudad de "NEW YORK"? (sol. 18279):



9. En sample_airbnb.listingsAndReviews, haga una query que devuelva el nombre y la dirección de los alojamientos que
tengan "Internet" como primer elemento de "amenities":


-----------------------------------SIMULACRO----------------------------------

En la colección listingAndReviews indique el/los nombre(s) del alojamiento con más
reviews.

	db.listingAndReviews.find({}, {name: 1}).sort({ "number_of_reviews": -1 }).limit(1)


En la colección listingAndReviews indique el/los nombre(s) del alojamiento con más
amenities

	db.listingAndReviews.aggregate([{ $project: { name: 1, amenitiesCount: { $size: "$amenities" } } }, { $sort: { amenitiesCount: -1 } }, { $limit: 1 }])


En la colección listingAndReviews indique para cada tipo de property_type el número
de alojamientos de ese tipo

	db.listingAndReviews.aggregate([{ $group: { _id: "$property_type", count: { $sum: 1 } } }, { $project: { property_type: "$_id", count: 1, _id: 0 } }])


En la colección listingAndReviews indique el número de alojamientos que tienen 2, 3, 4 o
5 beds.

	db.listingAndReviews.count({ beds: { $in: [2, 3, 4, 5] } })