/*CREATE SCHEMA media_works;
SHOW DATABASES;*/
USE media_works;

CREATE TABLE IF NOT EXISTS digital_media(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  url VARCHAR(500)
);

/*SHOW TABLES*/

CREATE TABLE IF NOT EXISTS newspaper(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS audio_visual(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  type VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS newspaper_section(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  newspaper_id INT(11),
  FOREIGN KEY(newspaper_id) REFERENCES newspaper(id)
  /*FOREIGN KEY(LOCAL_FIELD) REFERENCES newspaper(FIELD)*/
);

CREATE TABLE IF NOT EXISTS audio_visual_section(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  audio_visual_id INT(11),
  FOREIGN KEY(audio_visual_id) REFERENCES audio_visual(id)
);

CREATE TABLE IF NOT EXISTS audio_visual_program(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  program_name VARCHAR(100),
  schedule DATETIME,
  section_id INT(11),
  FOREIGN KEY(section_id) REFERENCES audio_visual_section(id)
);

CREATE TABLE IF NOT EXISTS news_item(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(500),
  body TEXT,
  publication_date DATETIME
);

CREATE TABLE IF NOT EXISTS keywords(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  keyword VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS news_item_keywords(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  news_item_id INT(11),
  keyword_id INT(11),
  FOREIGN KEY(news_item_id) REFERENCES news_item(id),
  FOREIGN KEY(keyword_id) REFERENCES keywords(id)
);

CREATE TABLE IF NOT EXISTS news_item_digital_media(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  news_item_id INT(11),
  digital_media_id INT(11),
  FOREIGN KEY(news_item_id) REFERENCES news_item(id),
  FOREIGN KEY(digital_media_id) REFERENCES digital_media(id)
);

CREATE TABLE IF NOT EXISTS news_item_newspaper(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  news_item_id INT(11),
  newspaper_id INT(11),
  FOREIGN KEY(news_item_id) REFERENCES news_item(id),
  FOREIGN KEY(newspaper_id) REFERENCES newspaper_section(id)
);

CREATE TABLE IF NOT EXISTS news_item_audio_visual(
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  news_item_id INT(11),
  audio_visual_id INT(11),
  FOREIGN KEY(news_item_id) REFERENCES news_item(id),
  FOREIGN KEY(audio_visual_id) REFERENCES audio_visual_program(id)
);