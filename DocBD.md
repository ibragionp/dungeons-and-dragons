# Banco de Dados

O banco de dados criado para atender os requisitos de uma ficha de RPG, tendo como base a regra de jogo do Dungeons And Dragons, é constituído por 6(seis) tabelas, são elas:

- USU_USUARIO
- PER_PERSONAGEM
- FEI_FEITICEIRO
- LUT_LUTADOR
- GRU_GRUPO
- INT_INTEGRANTE

## Tabelas
### USU_USUARIO
A tabela USU_USUARIO refere-se diretamente ao usuário, constituído por id, nome, senha, nome de exibição, administrador e classificação a tabela armazena os dados necessários do usuário para o uso do sistema
- USU_ID
- USU_NOME
- USU_SENHA
- USU_NOME_EXIBICAO
- USU_ADMINISTRADOR
- ADM_CLASSIFICACAO

### PER_PERSONAGEM
A tabela PER_PERSONAGEM por sua vez armazena os dados do(s) personagem(ns) criado(s) pelo usuário, contendo id, nome, raça, classe, id do proprietário e outros dados de status.
O campo proprietário é uma foreign key do id do usuário do qual criou esse personagem.

- PER_ID
- PER_PROPRIETARIO
- PER_NOME
- PER_RACA
- PER_CLASSE
- PER_NIVEL
- PER_ANTECEDENTE
- PER_FORCA
- PER_DESTREZA
- PER_CONSTITUINCAO
- PER_INTELIGENCIA
- PER_SABEDORIA
- PER_CARISMA

### FEI_FEITICEIRO
FEI_FEITICEIRO é usado para indicar habilidades conhecidas e modificadores de habilidade conforme a classe permite, além desses dois campos é incluído o campo id da classe e o campo de id do personagem como foreign key para identificar de qual personagem cada modificador e habilidade é referido.

- FEI_ID
- FEI_MAGIAS_CONHECIDAS
- FEI_MODIFICADOR_HABILIDADE

### LUT_LUTADOR
Assim como a tabela FEI_FEITICEIRO, a tabela LUT_LUTADOR também é uma tabela que se refere a classe do personagem criado, por sua vez, é incluído os dados superiores como habilidade. Seguindo a ideia da tabela anterior, também é adicionado o campo id da classe e o campo id do personagem também como foreign key.

- LUT_ID
- LUT_DADOS_SUPERIORIDADE

### GRU_GRUPO
Por fim, essa tabela se responsabiliza pela criação da mesa de RPG, armazenando o id do mestre (uma foreign key do id do usuário que se identifica como mestre nesta mesa em específico) e o nome da mesa podendo ser de escolha do grupo e apenas para identificação. 

- GRU_ID
- GRU_MESTRE
- GRU_NOME

### INT_INTEGRANTE
Como intermediária do personagem e grupo, a tabela INT_INTEGRANTE é criada para armazenar e intermediar a tabela GRU_GRUPO, armazenando o id do grupo, com a tabela PER_PERSONAGEM, armazenando o id do personagemas (As duas como foreign key).

- GRU_ID
- PER_ID