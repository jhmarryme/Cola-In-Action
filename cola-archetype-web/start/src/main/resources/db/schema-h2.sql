DROP TABLE IF EXISTS user_jpa;
CREATE TABLE user_jpa
(
    id    BIGINT(20) NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT 'url',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_mybatis;
CREATE TABLE user_mybatis
(
    id    BIGINT(20) NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS mooc_roles (
                                          id BIGINT NOT NULL AUTO_INCREMENT,
                                          role_name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_mooc_roles_role_name UNIQUE (role_name)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS mooc_users (
                                          id BIGINT NOT NULL AUTO_INCREMENT,
                                          account_non_expired BIT NOT NULL,
                                          account_non_locked BIT NOT NULL,
                                          credentials_non_expired BIT NOT NULL,
                                          email VARCHAR(254) NOT NULL,
    enabled BIT NOT NULL,
    mobile VARCHAR(11) NOT NULL,
    name VARCHAR(50) NOT NULL,
    password_hash VARCHAR(180) NOT NULL,
    username VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_mooc_users_username UNIQUE (username),
    CONSTRAINT uk_mooc_users_mobile UNIQUE (mobile),
    CONSTRAINT uk_mooc_users_email UNIQUE (email)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS mooc_users_roles (
                                                user_id BIGINT NOT NULL,
                                                role_id BIGINT NOT NULL,
                                                PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_users_roles_user_id_mooc_users_id FOREIGN KEY (user_id) REFERENCES mooc_users (id),
    CONSTRAINT fk_users_roles_role_id_mooc_roles_id FOREIGN KEY (role_id) REFERENCES mooc_roles (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
