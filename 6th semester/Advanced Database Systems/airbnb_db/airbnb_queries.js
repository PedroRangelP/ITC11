//1
db.reviews.count()

//2
db.reviews.find(
  {property_type:"House"}
).count()

//3
db.reviews.count(
  {"address.country":"Portugal"}
)

//4
  //Option 1
db.reviews.count(
  {number_of_reviews:{$gte:10}}
)
  //Option 2

//5
db.reviews.find(
  {"number_of_reviews": {$gt: 300}}, 
  {"_id":0, "name": 1}
)

db.reviews.aggregate([
  {$match:{"number_of_reviews": {$gt: 300}}},
  {$project:{"_id":0, "name": 1}}
])

//6
db.reviews.distinct(
  "address.country"
)

//---------------------------------------------
//aggregate

db.reviews.aggregate([
  {$group:{
    _id:"$address.country",
    "total":{$sum:1}
  }}
])

db.reviews.aggregate([
  {$group:{
    _id:"$address.country",
    "min_price":{$min:{$toDouble:"$price"}},
    "max_price":{$max:{$toDouble:"$price"}},
  }}
])

//---------------------------------------------
//bucket

db.reviews.aggregate([
  {$match:{"address.country":"Spain"}},
  {$bucket:{
    groupBy:"$price",
    boundaries:[0,100,300,500],
    default: "500+",
    output:{"total":{$sum:1}}
  }}
])

//---------------------------------------------
//Order table

db.order.insertMany([
  {id:1, item:"Almonds", price:12, quantity:2},
  {id:2, item:"Pecans", price:20, quantity:1}
])

db.inventory.insertMany([
  {id:1, sku:"Almonds", description:"Product 1", instock:120},
  {id:2, sku:"Bread", description:"Product 2", instock:80},
  {id:3, sku:"Cashews", description:"Product 3", instock:60},
  {id:4, sku:"Pecans", description:"Product 4", instock:70},
  {id:5, description:"Incomplete"}
])

//---------------------------------------------
//lookup (Joins)

db.order.aggregate([
  {$lookup:{
    from:"inventory",
    localField:"item",
    foreignField:"sku",
    as:"inventory_docs"
  }}
])

//---------------------------------------------
//unwind

db.reviews.aggregate([
  {$unwind:"$amenities"},
  {$group:{
    _id:"$amenities",
    "total":{$sum:1}
  }},
  {$sort:{"total":-1}}
])
