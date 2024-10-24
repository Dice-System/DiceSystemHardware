# Levantamento de requisitos

### *Projeto*: DICE system hardware | *Data*: 24/10/2024 | *Responsável/eis*: Bryan Cezar silveira e Leonardo dos S. Turczinski

## Objetivo

O objetivo deste documento é detalhar os requisitos funcionais e não funcionais do sistema "DICE systems - hardware", que permitirá o controle e monitoramento de máquinas, consertos, peças trocadas e inventário de componentes em um ou mais laboratórios.

## Escopo

O sistema gerenciará:

- Cadastro e controle de máquinas de diversos laboratórios.
- Registro de manutenções, consertos e peças trocadas.

## Definições, Acrônimos e Abreviações

- Máquina:
- Peça:
- Conserto:
- Inventário:

## requisitos funcionais

1. logar;

2. logar como administrador

3. criar conta;

4. editar conta (apenas propria se for usuario comum);

5. funções crud de maquinas, incluindo dados como, o tipo (desktop ou notebook), o numero (id), acessórios;

6. inventario tera crud de peças incluindo informações como tipo, fabricante e quantidade em estoque;

7. O sistema deve permitir a criação de perfis de usuário com diferentes níveis de acesso (técnicos, administradores);

### requisitos funcionais dos admins:

1. crud de usuarios;

(usuarios admins tambem fazem tudo que os tecnicos fazem);

# Requisitos não funcionais

1. Segurança: senhas são obrigatorias para evitar problemas;
   
2. a autentificação ira impedir dupla entrada de login, email, ou id;

3. O sistema deve possuir uma interface intuitiva, facilitando o registro de manutenções e o gerenciamento de inventário por técnicos;

## Requisitos de Interface
1.  O sistema deve ter uma interface gráfica baseada em JavaFX ou Swing;

# considerações finais

O sistema "DICE systems - hardware" deve facilitar o controle e o monitoramento das máquinas e peças de hardware, proporcionando maior eficiência na gestão de manutenção e inventário dos laboratórios. Este documento deverá ser revisado periodicamente conforme novas funcionalidades e necessidades sejam identificadas.
