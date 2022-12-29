INSERT INTO usr (id, username, password, active, email, activation_code)
VALUES (1, 'admin', '$2a$12$dc2wloXn6JqhJssSqVE1EOQ6/L8icR7C95PINVv4ANv/Q.cjCtxQ.', b'1', 'admin@admin.com', '');

INSERT INTO  user_role (user_id, roles)
values (1, 'USER'), (1, 'ADMIN');