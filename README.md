# Introdução

DiceSystem hardware é um sistema feito em java para registrar maquinas e peças, tal como suas manutenções, defeitos e soluções. O projeto
é baseado totalmento nos laboratorios de informatica do colegio Ulbra São Lucaa

# Funcionamento

ao entrar na tela inicial voce tera as opções de logar, ou criar uma conta caso não tenha uma. <br>
Todas as contas novas vem com o tipo de estagiario, pois para estar criando uma nova conta, voce certamente não é um admin.
<br>
Ao logar ou criar uma conta, voce automaticamente sera direcionado para a tela principal onde sera apresentado as funções principais, que são: <br>
Lorem ipsum dolor sit amet,<br>
consectetur adipiscing elit. <br>
Etiam eget ligula eu lectus lobortis <br>

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
