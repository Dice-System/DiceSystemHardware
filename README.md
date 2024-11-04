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

Create database DiceSytemBD <br>
<br>
use DiceSytemBD <br>
<br>
CREATE TABLE usuarios ( <br>
    id_usuario INT AUTO_INCREMENT PRIMARY KEY, <br>
    nome VARCHAR(100) NOT NULL, <br>
    email VARCHAR(100) NOT NULL UNIQUE, <br>
    senha VARCHAR(100) NOT NULL,<br>
    login varchar (100) not null unique,<br>
    perfil ENUM('tecnico', 'administrador', 'professor', 'estagiario') NOT NULL default 'estagiario'<br>
);<br>
<br>
CREATE TABLE laboratorios (<br>
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,<br>
    nome VARCHAR(100) NOT NULL<br>
);<br>
<br>
CREATE TABLE equipamento (<br>
    id_equipamento INT AUTO_INCREMENT PRIMARY KEY,<br>
    id_laboratorio INT,<br>
    nome VARCHAR(100) NOT NULL,<br>
    processador VARCHAR(100),<br>
    memoria_RAM VARCHAR(50),<br>
    armazenamento VARCHAR(50),<br>
    numero_serie VARCHAR(100) UNIQUE,<br>
    data_aquisicao DATE,<br>
    status ENUM('funcionando', 'em_manutencao', 'fora_de_uso') NOT NULL,<br>
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorios(id_laboratorio)<br>
);<br>
<br>
CREATE TABLE manutencao (<br>
    id_manutencao INT AUTO_INCREMENT PRIMARY KEY,<br>
    id_equipamento INT,<br>
    data_manutencao DATE NOT NULL,<br>
    diagnostico TEXT,<br>
    solucao TEXT,<br>
    tecnico_responsavel VARCHAR(100),<br>
    FOREIGN KEY (id_equipamento) REFERENCES equipamento(id_equipamento)<br>
);<br>
<br>
CREATE TABLE pecas (<br>
    id_peca INT AUTO_INCREMENT PRIMARY KEY,<br>
    nome_peca VARCHAR(100) NOT NULL,<br>
    quantidade_estoque INT DEFAULT 0,<br>
    descricao TEXT<br>
);<br>
<br>
CREATE TABLE pecas_manutencao (<br>
    id_peca_manutencao INT AUTO_INCREMENT PRIMARY KEY,<br>
    id_manutencao INT,<br>
    id_peca INT,<br>
    quantidade_utilizada INT NOT NULL default 0,<br>
    FOREIGN KEY (id_manutencao) REFERENCES manutencao(id_manutencao),<br>
    FOREIGN KEY (id_peca) REFERENCES pecas(id_peca)<br>
);<br>
