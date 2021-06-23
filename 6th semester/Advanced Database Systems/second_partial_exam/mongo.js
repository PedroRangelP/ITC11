//1
db.crunchbase_database.aggregate([
  {$match:{"number_of_employees": {$gt: 100}}},
  {$project: {
    _id: 0,
    company: "$name",
    number_of_employees: "$number_of_employees"
  }},
  {$sort: { number_of_employees: 1}},
  {$limit: 10}
])

//2
db.crunchbase_database.aggregate([
  {$bucket:{
    groupBy:"$founded_year",
    boundaries:[1870,1900,1930,1960,1990,2010],
    default: "other",
    output:{"total":{$sum:1}}
  }}
])

//3
db.crunchbase_database.aggregate([
  {$project: {
    _id: 0,
    company: "$name",
    "total_products": {$size: "$products"}
  }},
  {$sort: {"total_products": -1}},
  {$limit: 10}
])