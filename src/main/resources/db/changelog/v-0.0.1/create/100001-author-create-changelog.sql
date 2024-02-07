DROP TABLE IF EXISTS author;

CREATE TABLE author
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_author PRIMARY KEY (id)
);