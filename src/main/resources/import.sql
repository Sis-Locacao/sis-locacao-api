INSERT INTO tb_usuarios (id, cpf, email, estado_civil, nacionalidade, nome, rg, senha) VALUES (1, '123456','william@gmail.com',1,'Brasileiro','William Dias','123456789','123456789');
INSERT INTO tb_enderecos (id, cep, cidade, estado, numero, rua) VALUES (1, '13179072', 'Sumaré', 'SP', 509, 'R denilson de oliveira');
INSERT INTO tb_enderecos (id, cep, cidade, estado, numero, rua) VALUES (2, '13179072', 'Sumaré', 'SP', 501, 'R denilson de oliveira');
INSERT INTO tb_inquilinos (id, cpf, estado_civil, nacionalidade, nome, profissao, rg, usuario_id) VALUES (1, '123123', 1, 'Brasileiro', 'Marcos Alexandre', 'Uber', '153545', 1);
INSERT INTO tb_imoveis (id, apelido, descricao, garagem, valor, endereco_id, usuario_id) VALUES (1, 'CASA 01-A', 'Casa de teste', true, 550.00, 2,1);
INSERT INTO tb_locacoes (id, data_fim, data_inicio, valor_caucao, imovel_id, inquilino_id, usuario_id) values (1, '2024-05-18', '2023-05-18', 1250.00, 1, 1, 1);
insert into tb_recibos (id, data_fim, data_inicio, numero_recibo, total_juros, total_por_extenso, total_recibo, valor_agua, valor_energia, locacao_id) values (1, '2023-06-01', '2023-07-01', 1, 0.00, 'Quinhentos Reais', 500.00, 20.00, 130, 1);