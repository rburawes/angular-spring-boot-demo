-- roles
INSERT INTO role (role_name, description, time_created, time_updated) VALUES ('USER_ACCOUNT', 'No administrator rights.', current_timestamp, current_timestamp);
INSERT INTO role (role_name, description, time_created, time_updated) VALUES ('ADMIN_ACCOUNT', 'Can perform administrative tasks.', current_timestamp, current_timestamp);

-- users
-- non-encrypted password: abc123
INSERT INTO app_user (first_name, last_name, password, username, time_created, time_updated) VALUES ('Juan', 'Panday', '$2a$10$n7n/1FpRW0bYPGeGJv7Zb.CINx/6aV2HGPnwCuFWYRueTid4EfFPG', 'juan.panday', current_timestamp, current_timestamp);
INSERT INTO app_user (first_name, last_name, password, username, time_created, time_updated) VALUES ('John', 'Smith', '$2a$10$mIF0Z6R/DCDZB1YG7ZeI0.vufHvWnXKGWnZCgZYV.6WKslwqnzzJm', 'admin', current_timestamp, current_timestamp);

-- user roles
INSERT INTO user_role (user_id, role_id) VALUES (1,1); -- assigns Juan Panday as standard user
INSERT INTO user_role (user_id, role_id) VALUES (2,1); -- assigns John Smith as standard
INSERT INTO user_role (user_id, role_id) VALUES (2,2); -- and and admin user.
