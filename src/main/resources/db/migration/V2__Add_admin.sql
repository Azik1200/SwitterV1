INSERT INTO usr (id, username, password, active, email, activation_code)
VALUES (1, 'admin', 'root', b'1', 'admin@admin.com', '');

INSERT INTO  user_role (user_id, roles)
values (1, 'USER'), (1, 'ADMIN');