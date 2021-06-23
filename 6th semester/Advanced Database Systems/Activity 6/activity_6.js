
// use car_agency

db.sales.insertMany([
    {_id: 1, date: new Date("2020-01-13"), vehicle_type: "Ferrari", plate_number: "jwe-044", total_amount: 2500000, monthly_payments: 1, seller: "Pedro", owner_id:1},
    {_id: 2, date: new Date("2020-08-26") , vehicle_type: "BMW", plate_number: "ezs-604", total_amount: 500000, monthly_payments: 2, seller: "Pedro", owner_id: 2},
    {_id: 3, date: new Date("2020-03-15") , vehicle_type: "Tsuru", plate_number: "owo-101", total_amount: 65000, monthly_payments: 1, seller: "Richie", owner_id: 3},
    {_id: 4, date: new Date("2020-12-01") , vehicle_type: "Lamborghini", plate_number: "ggz-784", total_amount: 6930000, monthly_payments: 2, seller: "Eduardo", owner_id: 4},
    {_id: 5, date: new Date("2021-07-12") , vehicle_type: "Audi R8", plate_number: "xdf-368", total_amount:3470000, monthly_payments: 1, seller: "Eduardo", owner_id: 5}
])

// Owners
db.owners.insertMany([
    {_id: 1, name: "Andrea", phone_number: "55 6789 4556", address: "iztapalapa"}, 
    {_id: 2, name: "Fernando", phone_number: "55 6469 9834", address: "Coyoacan"},
    {_id: 3, name: "Rodrigo", phone_number: "55 5698 9845", address: "Benito Juárez"},
    {_id: 4, name: "Jorge", phone_number: "55 1937 7204", address: "Doctores"},
    {_id: 5, name: "Gerardo", phone_number: "55 0285 8294", address: "Lomas Estrella"}
])

// Payments
db.payments.insertMany([
    {_id: 1, sale_id: 1, amount: 2500000, payment_date: new Date("2020-03-15"), status: "paid"},
    {_id: 2, sale_id: 2, amount: 250000, payment_date: new Date("2020-08-26"), status: "delayed"},
    {_id: 3, sale_id: 2 , amount: 2500000, payment_date: new Date("2020-09-26"), status: "paid"},
    {_id: 4, sale_id: 3 , amount: 65000, payment_date: new Date("2020-03-15"), status: "pending"},
    {_id: 5, sale_id: 4, amount: 3465000, payment_date: new Date("2020-12-01"), status: "paid"},
    {_id: 6, sale_id: 4, amount: 3465000, payment_date: new Date("2021-01-01"), status: "delayed"},
    {_id: 7, sale_id: 5 , amount: 3470000, payment_date: new Date("2021-07-12"), status: "paid"}
])

// Notifications
db.notifications.insertMany([
    {owner_id:1 ,payment_id: 1},
    {owner_id: 2, payment_id: 2},
    {owner_id: 2, payment_id: 3},
    {owner_id: 3, payment_id: 4},
    {owner_id: 4, payment_id: 5},
    {owner_id: 4, payment_id: 6},
    {owner_id: 5, payment_id: 7}
])


// Number of sales made
db.sales.count()

// Average number of payments per sale
db.sales.aggregate([
    {$group:{
        _id:null,
        avg_payments: { $avg: "$monthly_payments" }
    }},
    {$project: {
        _id: 0,
        avg_payments: 1,
    }}
])

// Pending and delayed payments
db.payments.aggregate([
    {$match: {
      $or: [{status: {$eq: "pending"}}, {status: {$eq: "delayed"}}]
    }},
    {$group:{
        _id: "$status",
        total: {$sum: 1}
    }},
    {$project: {
        _id: 0,
        status: "$_id",
        total: "$total"
    }}
])

// Notifications of a given client
db.notifications.aggregate([
    {$match: { "owner_id":  1}},
    {$lookup:{
        from: "owners",
        localField: "owner_id",
        foreignField: "_id",
        as: "owner_data"
    }},
    {$lookup:{
        from: "payments",
        localField: "payment_id",
        foreignField: "_id",
        as: "payment_data"
    }},
    {$unwind: '$owner_data'},
    {$unwind: '$payment_data'},
    {$project: {
        _id: 0,
        owner: "$owner_data.name",
        phone_number: "$owner_data.phone_number",
        amount_to_pay: "$payment_data.amount",
        payment_date: "$payment_data.payment_date",
    }},
])