// 1. Total number of movies
db.movies.count()

// 2. List of countries where the movies where projected
db.movies.distinct("countries")

// 3. Total number of movies projected on every country
db.movies.aggregate([
    {$unwind:"$countries"},
    {
        $group:{
            _id:"$countries",
            "total":{$sum:1}
        }
    }
])
// 4. Titles of the movies with more comments (and the correspondent number of comments)


// 5. Total number of movies per every 10-year period


// 6. Total number of theatres per city


// 7. List the different genres available


// 8. Total number of movies per actor (Display only the top 10 actors)


// 9. Total number of movies per director (Display only the top 10 directors)


// 10. Total number of comments per movie (Display only the top 10 movies)
