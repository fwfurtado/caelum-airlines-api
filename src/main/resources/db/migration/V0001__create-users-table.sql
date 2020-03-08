CREATE TABLE  users (
   id BIGSERIAL,
   username VARCHAR(100) NOT NULL,
   password VARCHAR(255) NOT NULL,

   CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE INDEX idx_users_username ON users (username);