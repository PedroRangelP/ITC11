/* 1 Count all the measures from 2016 on */
SELECT SQL_NO_CACHE COUNT(*) AS number_of_measures FROM measures WHERE YEAR(measure_timestamp) >= 2016;

/* 2 Partition the table using a range partition for the measure_timestamp column */
ALTER TABLE `measures` PARTITION BY RANGE(YEAR(measure_timestamp))(
  PARTITION less_than_2015 VALUES LESS THAN (2015),
  PARTITION less_than_2016 VALUES LESS THAN (2016),
  PARTITION up_2016 VALUES LESS THAN MAXVALUE
);

/* 2.1 Count all the measures from 2016 on using the partition */
SELECT SQL_NO_CACHE COUNT(*) AS number_of_measures FROM measures  PARTITION (up_2016) WHERE YEAR(measure_timestamp) >= 2016;


/* 3 Create a view to determine the number of measurements tracked on every station every year.*/
CREATE VIEW measurements_in_stations_per_year AS
SELECT station_name, YEAR(measure_timestamp) AS measure_year, COUNT(YEAR(measure_timestamp)) AS measures_per_year FROM measures
GROUP BY measure_year, station_name;

/*4 Filter the information in the view for the years 2016 and on*/
SELECT * FROM measurements_in_stations_per_year WHERE measure_year >= 2016;