create sequence hibernate_sequence start 1 increment 1;
create table tb_post (id int8 not null, autor varchar(255), data date, texto text, titulo varchar(255), primary key (id));
