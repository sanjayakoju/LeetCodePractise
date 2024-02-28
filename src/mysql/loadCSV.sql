CREATE TABLE athletes (
                          id INT PRIMARY KEY,
                          name VARCHAR(50),
                          age INT,
                          nationality VARCHAR(50)
);

-- Load data from CSV file
LOAD DATA INFILE '/var/lib/mysql-files/athletes.csv'
INTO TABLE athletes
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

SHOW VARIABLES LIKE 'secure_file_priv';

select * from athletes;
