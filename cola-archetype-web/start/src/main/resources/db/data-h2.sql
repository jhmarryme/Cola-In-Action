INSERT INTO user_jpa (id, name, email)
VALUES (1, 'wjh', 'test'),
       (2, 'jh', 'test');

INSERT INTO user_mybatis (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');

insert into mooc_users(id, username, `name`, mobile, password_hash, enabled, account_non_expired, account_non_locked, credentials_non_expired, email)
values (1, 'user', 'Zhang San', '13012341234', '{bcrypt}$2a$10$uqEeYOmhs2h4yTXr.xFdqOMt/QIsAVqQWkwxs2cKvZ8us38wXVsFu', 1, 1, 1, 1, 'zhangsan@local.dev'),
       (2, 'old_user', 'Li Si', '13812341234', '{SHA-1}{uQd71hoL0n4JrBNd4G00FbjXqw7kWVTunLoMKfIyNWg=}fa7ceda9d4fb6e6da19bc4298bf765ff532ff79e', 1, 1, 1, 1, 'lisi@local.dev');
insert into mooc_roles(id, role_name) values (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');
insert into mooc_users_roles(user_id, role_id) values (1, 1), (1, 2), (2, 1);


