create table usuario
(
    id           bigint auto_increment NOT NULL PRIMARY KEY,
    username         varchar(255),
    email        varchar(255),
    password        varchar(255),
    role        varchar(255)
);

insert into usuario(username, email, password, role)
values ('Ian Gerolamo', 'ian@email.com', '$2a$10$Otv.NyCR3G00aYQgpwTGWO/Z4Yr/Hs/fJlBHGRBnIn/K9k/poIgNq', 'ROLE_ADMIN');

insert into usuario(username, email, password, role)
values ('Luke Skywalker', 'luke@email.com', '$2a$10$Otv.NyCR3G00aYQgpwTGWO/Z4Yr/Hs/fJlBHGRBnIn/K9k/poIgNq','ROLE_ADMIN');

insert into usuario(username, email, password, role)
values ('Frodo Bolseiro', 'frodo@email.com', '$2a$10$Otv.NyCR3G00aYQgpwTGWO/Z4Yr/Hs/fJlBHGRBnIn/K9k/poIgNq','ROLE_ADMIN');

insert into usuario(username, email, password, role)
values ('Bilbo Bolseiro', 'bilbo@email.com', '$2a$10$Otv.NyCR3G00aYQgpwTGWO/Z4Yr/Hs/fJlBHGRBnIn/K9k/poIgNq','ROLE_ADMIN');