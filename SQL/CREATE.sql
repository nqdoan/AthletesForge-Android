CREATE TABLE city(
	city_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(50),
    university_name VARCHAR(100),
	state VARCHAR(10),
	indoor_altitude INT,
	indoor_track VARCHAR(50),
    outdoor_altitude INT,
    outdoor_track VARCHAR(50)
) ENGINE=INNODB;


CREATE TABLE event(
	event_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	event_name VARCHAR(50),
	event_type VARCHAR(50)
) ENGINE=INNODB;