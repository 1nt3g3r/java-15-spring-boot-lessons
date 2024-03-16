CREATE TABLE IF NOT EXISTS programming_language (
    language_name VARCHAR(255) NOT NULL,
    users BIGINT NOT NULL,
    projects BIGINT NOT NULL,
    love_percent INT NOT NULL,
    PRIMARY KEY (language_name)
    );

INSERT INTO programming_language (language_name, users, projects, love_percent)
VALUES  ('JavaScript', 10000000, 5000000, 65),
        ('Python', 9500000, 4000000, 78),
        ('Java', 8500000, 4500000, 69),
        ('C#', 4300000, 2000000, 59),
        ('PHP', 5000000, 2500000, 55),
        ('C++', 4000000, 2100000, 74),
        ('Ruby', 3000000, 1800000, 50),
        ('Swift', 3500000, 900000, 72),
        ('Go', 1500000, 850000, 65),
        ('Rust', 1300000, 780000, 86);
