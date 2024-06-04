SET search_path TO "api_users";

CREATE TABLE api_users.system_user_role (
    id_system_user_role SERIAL PRIMARY KEY,
    description VARCHAR NOT NULL
);

CREATE TABLE api_users.system_users (
    id_system_user SERIAL PRIMARY KEY,
    username VARCHAR NOT NULL,
    user_password VARCHAR NOT NULL,
    id_system_user_role INTEGER NOT NULL,
    CONSTRAINT fk_system_user_role FOREIGN KEY (id_system_user_role) REFERENCES api_users.system_user_role (id_system_user_role)
);
