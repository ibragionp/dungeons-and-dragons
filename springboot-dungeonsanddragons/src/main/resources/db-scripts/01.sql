--liquibase formatted sql

--changeset railson:1

INSERT INTO dungeonsanddragons.usu_usuario
(usu_id,
usu_nome_exibicao,
usu_nome_usuario,
usu_senha,
adm_classificacao)
VALUES
(2,
'R',
'T',
'1',
1);

-- rollback delete from usu_usuario where usu_id = 2;
