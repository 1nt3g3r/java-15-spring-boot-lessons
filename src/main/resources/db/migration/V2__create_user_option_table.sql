CREATE TABLE user_option (
    "username" VARCHAR(255) NOT NULL,
    "option" VARCHAR(255) NOT NULL,
    "value" VARCHAR(255),
    PRIMARY KEY ("username", "option")
);
