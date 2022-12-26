CREATE TABLE message
(
    id       BIGINT NOT NULL,
    filename VARCHAR(255) NULL,
    text     VARCHAR(2048) NOT NULL,
    tag      VARCHAR(255) NOT NULL,
    user_id  BIGINT NOT NULL,
    CONSTRAINT pk_message PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    roles   VARCHAR(255) NULL
);

CREATE TABLE usr
(
    id              BIGINT NOT NULL,
    username        VARCHAR(255) NOT NULL,
    password        VARCHAR(255) NOT NULL,
    active          BIT(1) NOT NULL,
    email           VARCHAR(255) NOT NULL,
    activation_code VARCHAR(255) NULL,
    CONSTRAINT pk_usr PRIMARY KEY (id)
);

ALTER TABLE message
    ADD CONSTRAINT FK_MESSAGE_ON_USER FOREIGN KEY (user_id) REFERENCES usr (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES usr (id);



