CREATE DATABASE ToDo;
USE ToDo;

CREATE TABLE tarefas(
idTarefas INT PRIMARY KEY AUTO_INCREMENT,
titulo TEXT,
descricao TEXT,
concluida BOOLEAN,
dataCriacao DATE
);