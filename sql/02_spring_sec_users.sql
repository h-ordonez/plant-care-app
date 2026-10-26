USE plants_db;

DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	username VARCHAR(50) NOT NULL,
    password VARCHAR(68) NOT NULL,
    enabled TINYINT NOT NULL,
    PRIMARY KEY (username)
);                                                                                                   
                                                                                                       
CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    UNIQUE KEY authorities_idx_1 (username, authority),
    CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

INSERT INTO users VALUES
	('user',  '{bcrypt}$2a$10$5Ox1KKawMkMTHlQqZqJFOuaJZBrwSrFpwz/Ed8iXNRLB2LVwqtmcC',  1),
    ('admin', '{bcrypt}$2a$10$wRaZY/6fvGJ1c5IFBY.0x.klr80OGu3g4z5RblvHe2rCy9IU6FVXO', 1);

INSERT INTO authorities VALUES
	('user',  'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN');