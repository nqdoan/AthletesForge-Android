
CREATE TABLE tracklocation(
	track_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    school_name VARCHAR(50),
    city_name VARCHAR(100),
    altitude BIGINT,
    men_conversion_indoor DECIMAL(12,10),
    women_conversion_indoor DECIMAL(12,10),
    indoor_type VARCHAR(4),
    men_conversion_outdoor DECIMAL(12,10),
    women_conversion_outdoor DECIMAL(12,10),
    outdoor_type VARCHAR(4)
); 

CREATE TABLE events(
	event_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	event_name VARCHAR(20),
	men_u2f DECIMAL(12,10),
	men_bo2f DECIMAL(12,10),
	men_u2bo DECIMAL(12,10),
	men_f2bo DECIMAL(12,10),
	women_u2f DECIMAL(12,10),
	women_bo2f DECIMAL(12,10),
	women_u2bo DECIMAL(12,10),
	women_f2bo DECIMAL(12,10)
);

CREATE TABLE nationallocation(
	national_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location_name VARCHAR(100),
    location_type VARCHAR(4)
);



INSERT INTO tracklocation(school_name, city_name, altitude, men_conversion_indoor, men_conversion_outdoor, indoor_type, women_conversion_indoor, women_conversion_outdoor, outdoor_type) VALUES 
	('Fake School High' , 'Missoula', 3199, 1.002995, 1.002995, 'f', 1.025707 , 1.025707, 'u');

INSERT INTO events(event_name, men_u2f, men_bo2f, men_u2bo, men_f2bo, women_u2f, women_bo2f, women_u2bo, women_f2bo) VALUES
	('200m', 0.9872, 1.0179, 0.9698, 0.9824, 0.9900, 1.0155, 0.9749, 0.9847);

INSERT INTO nationallocation(location_name, location_type) VALUES
	('National Track University', 'f');


