# Banco de dados

## Modelo conceitual
![diceSystem](https://github.com/user-attachments/assets/2693bc68-9cca-4b81-8c05-b9e0bab006a8)


## Modelo Lógico 
![DiceSystemDiagramaLógico](https://github.com/user-attachments/assets/ab867df0-8837-4044-99df-9943e0d9c5a5)

## Script do SQL para criação do banco de dados usado

create database diceSystembd; <br>
<br>
use diceSystembd;<br>

create table usuarios(<br>
	id int auto_increment primary key,<br>
    nome varchar(45),<br>
    login varchar(45) unique,<br>
    email varchar(75) unique,<br>
    tipo varchar(40) default 'Estagiario',<br>
    senha varchar(80)<br>
);<br>
<br>
create table laboratorio(<br>
	id int auto_increment primary key,<br>
    nome varchar(45),<br>
    quant_equip int default 0<br>
);<br>
<br>
create table equipamento (<br>
id int auto_increment primary key,<br>
nome varchar(45),<br>
tipo varchar(45),<br>
descricao varchar(200),<br>
id_laboratorio int,<br>
<br>
foreign key(id_laboratorio) references laboratorio(id)<br>
);<br>
<br>
create table peca<br>
(<br>
id int auto_increment primary key,<br>
modelo varchar(45),<br>
status_peca varchar(45),<br>
descricao varchar(200),<br>
id_equipamento int,<br>
foreign key(id_equipamento) references equipamento(id)<br>
);<br>
<br>
create table manutencao(<br>
id int auto_increment primary key,<br>
data_entrada date,<br>
data_saida date,<br>
defeito varchar(115),<br>
solucao varchar(115),<br>
id_usuarios int,<br>
<br>
foreign key(id_usuarios) references usuarios(id)<br>
);
