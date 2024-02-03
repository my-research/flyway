CREATE TABLE todo
(
    id         INT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    status     VARCHAR(15)  NOT NULL,
    created_at TIMESTAMP    NOT NULL
);
