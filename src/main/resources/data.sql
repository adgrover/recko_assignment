DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS user_posts;

CREATE TABLE users (
    id VARCHAR(100) PRIMARY KEY,
    user_name VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE posts(
    id VARCHAR(100) PRIMARY KEY,
    content VARCHAR(1000) NOT NULL,
    time_stamp TIMESTAMP NOT NULL
);

CREATE TABLE user_posts(
    user_id VARCHAR(100) NOT NULL,
    post_id VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id, post_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES posts (id)
);


INSERT INTO users (id, user_name, password) VALUES
                    ('20', 'GEORGE', '12345'),
                    ('21', 'PETER', '13579'),
                    ('22', 'JOHN', '14682');

INSERT INTO posts (id, content, time_stamp) VALUES
                    ('1', 'A QUICK BROWN FOX',           '2020-08-01 00:00:01'),
                    ('2', 'POST CONTENT IN SECOND FORM', '2020-08-05 12:00:01'),
                    ('3', 'LOREM IPSUM DOLOR SIT AMET',  '2020-08-07 10:30:00');