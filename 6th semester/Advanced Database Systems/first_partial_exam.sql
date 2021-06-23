SELECT title, rating, COUNT(film_actor.actor_id) AS number_actors
FROM film INNER JOIN film_actor
ON film.film_id = film_actor.film_id
WHERE release_year = 2006 AND length >= 50 AND length <= 90
GROUP BY film_actor.film_id;

DELIMITER $$
CREATE PROCEDURE search_movie(IN search_year YEAR, IN length_min SMALLINT, IN length_max SMALLINT, OUT result VARCHAR(100))
BEGIN
  SELECT title, rating, COUNT(film_actor.actor_id) AS number_actors
  FROM film INNER JOIN film_actor
  ON film.film_id = film_actor.film_id
  WHERE release_year = search_year AND length >= length_min AND length <= length_max
  GROUP BY film_actor.film_id;
END$$
DELIMITER ;

CALL search_movie(2006, 50, 90, @result);

CREATE EVENT daily_search_movie ON SCHEDULE EVERY 1 DAY DO CALL search_movie(2006, 50, 90, @result);

CREATE INDEX idx_release_year ON film(release_year);
CREATE INDEX idx_length ON film(length);