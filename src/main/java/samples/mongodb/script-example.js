
// This script example would add 10 to the price
// of products whose price is greater than 1000.

db.products.find({ price:{$gt:1000} }).forEach( function(p) {

	printjson( p.name + " price will be set to " + (p.price + 10));

	db.products.update( {_id:p._id}, { $set: {price: p.price + 10} } );
})