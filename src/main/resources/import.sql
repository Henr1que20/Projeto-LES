INSERT INTO tb_usuario (email, password, ativo) VALUES ('alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true );
INSERT INTO tb_usuario (email, password, ativo) VALUES ('bruno@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('caio@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('daniela@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('evandro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('fabio@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('gabriela@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('henrique@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('isabel@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);
INSERT INTO tb_usuario (email, password, ativo) VALUES ('julio@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', true);

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENTE');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (4, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (5, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (6, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (7, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (8, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (9, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (10, 1);


INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Alex da Silva', NOW(), '1993-05-01', '93028902010', 'M', 1)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Bruno da Silva', NOW(), '2000-03-13', '61483280039', 'M', 2)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Caio da Silva', NOW(), '1988-04-16', '89383951036', 'M', 3)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Daniela de Oliveira', NOW(), '1990-09-10', '38619906011', 'F', 4)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Evandro dos Santos', NOW(), '2001-01-05', '83432488050', 'M', 5)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Fabio Assunção', NOW(), '1999-02-02', '00877208093', 'M', 6)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Gabriela de Andrade', NOW(), '1995-11-25', '85733542080', 'F', 7)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Henrique de Oliveira', NOW(), '2001-11-09', '37964642030', 'M', 8)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Isabel Nogueira', NOW(), '1985-12-25', '49618633004', 'F', 9)
INSERT INTO tb_cliente (nome, dat_criacao, data_nascimento, cpf, genero, usuario_id) VALUES ('Julio de Amorim', NOW(), '1995-02-17', '15413355033', 'M', 10)

INSERT INTO tb_estado (nome, uf) VALUES ('São Paulo', 'SP')
INSERT INTO tb_estado (nome, uf) VALUES ('Rio de Janeio', 'RJ')
INSERT INTO tb_estado (nome, uf) VALUES ('Minas Gerais', 'MG')

INSERT INTO tb_cidade (nome, estado_id) VALUES ('Mogi das Cruzes', 1)
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Suzano', 1)
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Petropolis', 2)
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Nova Iguaçu', 2)
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Pirapora', 3)
INSERT INTO tb_cidade (nome, estado_id) VALUES ('Mariana', 3)

INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 2, 1);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 1, 2);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 3, 3);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 4, 4);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 5, 5);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 6, 6);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 3, 7);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 2, 8);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 1, 9);
INSERT INTO tb_endereco (BAIRRO, CEP, COMPLEMENTO, DESCRICAO, LOGRADOURO, NOME, NUMERO, PAIS, TIPO_LOGRADOURO, CIDADE_ID, CLIENTE) VALUES ('Monte Cristo', '08670020', 'Bairo perto do centro','Predio 1','Avenida Conde de Monte Cristo', 'Jardim Monte Cristo', '120', 'Brasil', 'Comercial', 2, 10);

