/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Gabriel
 * Created: 08/12/2017
 */

CREATE TABLE tarefa(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY, 
    nome varchar(100) not null,
    descricao varchar(1000),
    dataIncial date,
    dataFinal date,
    percentual float,
    estado varchar(50),
    PRIMARY KEY (id)
);


CREATE TABLE projeto(
    id int not null generated always as identity,
    nome varchar(100) not null,
    id_responsavel int,
    descricao varchar(1000),
    dataAbertura date,
    dataFinal date,
    status boolean,
    primary key (id)
);


create table tarefa_pessoa(
    id_pessoa int,
    id_tarefa int
);

create table tarefa_requisito(
    id_tarefaA int,
    id_tarefaR int
);

create table pessoa(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY, 
    nome varchar(100) not null,
    email varchar(100),
    primary key (id)
);

select *from tarefa_pessoa;

