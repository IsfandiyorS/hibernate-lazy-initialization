DROP TABLE IF EXISTS book;
CREATE TABLE book
(
    id        BIGINT NOT NULL,
    title     VARCHAR(255),
    genre     VARCHAR(255),
    author_id BIGINT NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (id)
);

ALTER TABLE book
    ADD CONSTRAINT FK_BOOK_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES author (id);