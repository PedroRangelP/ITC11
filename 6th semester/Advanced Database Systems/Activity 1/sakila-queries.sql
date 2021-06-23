/*1 The actors with the most number of movies (TOP 20) */
SELECT first_name, last_name, COUNT(film_actor.actor_id) AS film_count 
FROM actor INNER JOIN film_actor 	
ON actor.actor_id = film_actor.actor_id 
GROUP BY film_actor.actor_id 
ORDER BY film_count DESC 
LIMIT 20;

/*2 The movies’ titles of the actor with the most number of movies */
SELECT title 
FROM film INNER JOIN film_actor 
ON film.film_id = film_actor.film_id 
WHERE film_actor.actor_id = 
	(SELECT actor_id 
	 FROM film_actor 
      GROUP BY actor_id 
      ORDER BY COUNT(actor_id) 
      DESC LIMIT 1);
         
/*3*/
SELECT title, COUNT(film_actor.actor_id) AS actor_count 
FROM film INNER JOIN film_actor 	
ON film.film_id = film_actor.film_id 
GROUP BY film_actor.film_id 
ORDER BY actor_count DESC 
LIMIT 20;

/*4 The country with the maximum number of customers */
SELECT country, COUNT(customer_id) as customer_count
FROM ((country INNER JOIN city
ON country.country_id = city.country_id)
INNER JOIN address ON city.city_id = address.city_id)
INNER JOIN customer ON address.address_id = customer.address_id
GROUP BY country
ORDER BY customer_count DESC 
LIMIT 20;

/*5 The number of customers per country */
SELECT country, COUNT(customer_id) as customer_count
FROM ((country INNER JOIN city
ON country.country_id = city.country_id)
INNER JOIN address ON city.city_id = address.city_id)
INNER JOIN customer ON address.address_id = customer.address_id
GROUP BY country
ORDER BY customer_count DESC;

/*6 The country with the maximum number of customers */
SELECT country, COUNT(customer_id) as customer_count
FROM ((country INNER JOIN city
ON country.country_id = city.country_id)
INNER JOIN address ON city.city_id = address.city_id)
INNER JOIN customer ON address.address_id = customer.address_id
GROUP BY country
ORDER BY customer_count DESC 
LIMIT 1;

/*7 The top rented movies */
SELECT title , COUNT(rental_id) as rental_count
FROM (film INNER JOIN inventory 
ON film.film_id = inventory.film_id )
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY title
ORDER BY rental_count DESC
LIMIT 20;

/*8 The customers who rent more movies (TOP 20) */
SELECT first_name,last_name, COUNT(rental.customer_id) as rental_count
FROM customer INNER JOIN rental ON rental.customer_id = customer.customer_id
GROUP BY customer.customer_id
ORDER BY rental_count DESC
LIMIT 20;


/*9 The movies’ titles rented by the customer with more rents */
SELECT title 
FROM (film INNER JOIN inventory 
ON film.film_id = inventory.film_id) INNER JOIN rental ON  inventory.inventory_id = rental.inventory_id
WHERE rental.customer_id = 
	(SELECT customer.customer_id
		FROM customer INNER JOIN rental ON rental.customer_id = customer.customer_id
		GROUP BY customer.customer_id
		ORDER BY COUNT(rental.customer_id) DESC
		LIMIT 1);

/*10 The movies’ titles that have never been rented */
SELECT title FROM film WHERE film.film_id NOT IN (
  SELECT film.film_id FROM (film INNER JOIN inventory ON inventory.film_id = film.film_id)
    INNER JOIN rental ON rental.inventory_id = inventory.inventory_id);

/*11 The category with the highest number of movies */
SELECT name, COUNT(film_category.category_id) AS film_count 
FROM category INNER JOIN film_category 
ON category.category_id = film_category.category_id 
GROUP BY film_category.category_id 
ORDER BY film_count DESC 
LIMIT 1;

/*12 The number of movies per category */
SELECT name, COUNT(film_category.category_id) AS film_count 
FROM category INNER JOIN film_category 
ON category.category_id = film_category.category_id 
GROUP BY film_category.category_id 
ORDER BY film_count DESC ;

/*13 The number of rentals per category */
SELECT name, COUNT(category.category_id) AS category_count FROM category INNER JOIN film_category ON category.category_id = film_category.category_id
    INNER JOIN film ON film_category.film_id = film.film_id
    INNER JOIN inventory ON film.film_id = inventory.film_id
    INNER JOIN rental ON inventory.inventory_id = rental.inventory_id
    GROUP BY category.category_id
    ORDER BY category_count DESC;