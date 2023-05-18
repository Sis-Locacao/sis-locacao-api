INSERT INTO usuario (id, cpf, email, estado_civil, nacionalidade, nome, rg, senha) VALUES (1, '123456','william@gmail.com',1,'Brasileiro','William Dias','123456789','123456789');
INSERT INTO endereco (id, cep, cidade, estado, numero, rua) VALUES (1, '13179072', 'Sumaré', 'SP', 509, 'R denilson de oliveira');
INSERT INTO endereco (id, cep, cidade, estado, numero, rua) VALUES (2, '13179072', 'Sumaré', 'SP', 501, 'R denilson de oliveira');
INSERT INTO inquilino(id, cpf, estado_civil, nacionalidade, nome, profissao, rg, usuario_id) VALUES (1, '123123', 1, 'Brasileiro', 'Marcos Alexandre', 'Uber', '153545', 1);
INSERT INTO imovel (id, apelido, descricao, garagem, valor, endereco_id, usuario_id) VALUES (1, 'CASA 01-A', 'Casa de teste', true, 550.00, 2,1);
INSERT INTO locacao(data_fim, data_inicio, valor_caucao, imovel_id, inquilino_id, usuario_id) values ('2024-05-18', '2023-05-18', 1250.00, 1, 1, 1);