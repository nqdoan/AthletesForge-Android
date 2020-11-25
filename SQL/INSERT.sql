INSERT INTO city(city_name, university_name, state, indoor_altitude, indoor_track, outdoor_altitude, outdoor_track) VALUES 
	('Air Force Academy' , 'Air Force Academy' , 'CO' , 7048 , 'Oversized/Flat' , 6981 , '400m/Flat'),
	('Alamosa' , 'Adams State University' , 'CO' , 7547 , '200m/Flat' , 7544 , '400m/Flat'),
	('Albuquerque' , 'University of New Mexico' , 'MN' , 4958 , '200m/Banked' , 5120 , '400m/Flat'),
	('Amarillo' , 'West Texas A&M' , 'TX' , NULL , NULL , 3676 , '400m/Flat'),
	('Ann Arbor' , 'University of Michigan' , 'MI' , NULL , '200m/Banked' , NULL , '400m/Flat'),
	('Billings' , 'Montana State University Billings' , 'MT' , NULL , NULL , 3124 , '400m/Flat'),
	('Boone' , 'Appalachian State University' , 'NC' , 3333 , 'Oversized/Flat' , 3333 , '400m/Flat'),
	('Boulder' , 'University of Colorado at Boulder' , 'CO' , 5337 , 'Oversized/Flat' , 5260 , '400m/Flat'),
	('Bozeman' , 'Montana State University Bozeman' , 'MT' , 4926 , '200m/Flat' , 4926 , '400m/Flat'),
	('Chadron' , 'Chadron State College' , 'NE' , 3281 , 'Undersized/Flat' , 3288 , '400m/Flat'),
	('College Station' , 'Texas A&M' , 'TX' , NULL , '200m/Banked' , NULL , '400m/Flat'),
	('Colorado Springs' , 'University of Colorado at Colorado Springs' , 'CO' , 6007 , '200m/Flat' , 6007 , '400m/Flat'),
	('Flagstaff' , 'Northern Arizona University' , 'AZ' , 6877 , '300m/Flat' , 6888 , '400m/Flat'),
	('Fort Collins' , 'Colorado State University' , 'CO' , 5081 , 'Undersized/Banked' , 5081 , '400m/Flat'),
	('Gillette' , 'Campbell County Recreation Center' , 'WY' , 4554 , '200m/Flat' , NULL , 'null'),
	('Golden' , 'Colorado School of Mines' , 'CO' , 5675 , 'Undersized/Flat' , 5675 , '400m/Flat'),
	('Greeley' , 'University of Northern Colorado' , 'CO' , NULL , NULL , 4774 , '400m/Flat'),
	('Gunnison' , 'Western State University of Colorado' , 'CO' , 7717 , '200m/Flat' , 7771 , '400m/Flat'),
	('Houston' , 'University of Houston' , 'TX' , NULL , '200m/Banked' , NULL , '400m/Flat'),
	('Kearney' , 'University of Nebraska Kearney' , 'NE' , NULL , 'Undersized/Flat' , NULL , '400m/Flat'),
	('Laramie' , 'University of Wyoming' , 'WY' , 7212 , 'Undersized/Flat' , 7163 , '400m/Flat'),
	('Lincoln' , 'University of Nebraska Lincoln' , 'NE' , NULL , '200m/Banked' , NULL , '400m/Flat'),
	('Logan' , 'Utah State University' , 'UT' , NULL , NULL , 4680 , '400m/Flat'),
	('Lubbock' , 'Texas Tech University' , 'TX' , 3217 , '200m/Banked' , 3281 , '400m/Flat'),
	('Missoula' , 'University of Montana' , 'MT' , NULL , NULL , 3199 , '400m/Flat'),
	('Ogden' , 'Weber State' , 'UT' , 4700 , '200m/Flat' , 4759 , '400m/Flat'),
	('Orem' , 'Utah Valley University' , 'UT' , NULL , NULL , 4706 , '400m/Flat'),
	('Plainview' , 'Wayland Baptist University' , 'TX' , NULL , NULL , 3230 , '400m/Flat'),
	('Pocatello' , 'Idaho State' , 'ID' , 4539 , '200m/Banked' , 4465 , '400m/Flat'),
	('Portales' , 'Eastern New Mexico' , 'NM' , NULL , NULL , 4009 , '400m/Flat'),
	('Provo' , 'Brigham Young University' , 'UT' , 4627 , 'Oversized/Flat' , 4627 , '400m/Flat'),
	('Pueblo' , 'Colorado State University Pueblo' , 'CO' , NULL , NULL , 4700 , '400m/Flat'),
	('Rapid City' , 'South Dakota School of Mines and Technology' , 'SD' , NULL , NULL , 3247 , '400m/Flat'),
	('Reno' , 'University of Nevada Reno' , 'NV' , NULL , NULL , 4620 , '400m/Flat'),
	('Salt Lake City' , 'University of Utah' , 'UT' , NULL , NULL , 4825 , '400m/Flat'),
	('Seattle' , 'University of Washington' , 'WA' , NULL , 'Oversized/Flat' , NULL , '400m/Flat'),
	('South Lake Tahoe' , 'South Tahoe Community Sports Complex' , 'NV' , NULL , NULL , 6224 , '400m/Flat'),
	('Spearfish' , 'Black Hills State' , 'SD' , 3593 , '200m/Flat' , 3593 , '400m/Flat');

INSERT INTO event(event_name, event_type) VALUES
	('10,000m', 'altitude'),
	('5,000m', 'altitude'),
	('3,000m/Steeple', 'altitude'),
	('1,500m', 'altitude'),
	('Mile', 'altitude'),
	('800m', 'altitude'),
	('DMR', 'altitude'),
	('60m/60mH', 'altitude'),
	('100m', 'altitude'),
	('100mH/110mH', 'altitude'),
	('200m', 'altitude'),
	('400m/400mH', 'altitude'),
	('4x100m', 'altitude'),
	('4x100m', 'altitude'),
	('5,000m', 'indoor'),
	('3,000m', 'indoor'),
	('Mile', 'indoor'),
	('1,000m', 'indoor'),
	('800m/4x800m', 'indoor'),
	('600m', 'indoor'),
	('600yd', 'indoor'),
	('500m', 'indoor'),
	('400m/4x400m', 'indoor'),
	('200m', 'indoor'),
	('DMR', 'indoor');

