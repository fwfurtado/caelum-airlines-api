CREATE TABLE airports (
    id BIGSERIAL,
    identifier VARCHAR(4),
    name VARCHAR(255),

    CONSTRAINT pk_airports PRIMARY KEY (id),
    CONSTRAINT unq_airports_identifier UNIQUE (identifier)
);
