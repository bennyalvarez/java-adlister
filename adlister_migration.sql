-- CREATE adlister_db;
--
-- CREATE USER 'johnny'@'localhost' IDENTIFIED BY 'johnny123';
-- GRANT ALL ON adlister_db.* TO 'johnny'@'localhost';

USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240),
    email VARCHAR(240),
    password VARCHAR(240),
    PRIMARY KEY(id)
    );


CREATE TABLE IF NOT EXISTS ads(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR (240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

INSERT INTO users (username, email, password)
VALUES('user1', 'user@email.com', password);