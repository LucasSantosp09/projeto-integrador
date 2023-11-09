-- Categorias
INSERT INTO categorias (descricao, url_imagem) VALUES ('Esportivo', 'url_para_imagem_esportivo');
INSERT INTO categorias (descricao, url_imagem) VALUES ('Hatch', 'url_para_imagem_hatch');
INSERT INTO categorias (descricao, url_imagem) VALUES ('Pickup', 'url_para_imagem_pickup');

-- Características dos Carros
INSERT INTO caracteristicas_carro (descricao) VALUES ('Câmbio manual, 2 portas, básico');
INSERT INTO caracteristicas_carro (descricao) VALUES ('Híbrido, piloto automático');
INSERT INTO caracteristicas_carro (descricao) VALUES ('Elétrico, sistema autônomo completo');

-- Cidades
INSERT INTO cidade (nome_cidade) VALUES ('Curitiba');
INSERT INTO cidade (nome_cidade) VALUES ('Salvador');
INSERT INTO cidade (nome_cidade) VALUES ('Fortaleza');

-- Locadoras
INSERT INTO locadora (bairro, cep, complemento, logradouro, nome_locadora, numero) VALUES ('Bairro Curitiba', '80000-000', 'Complemento CTBA', 'Rua Curitiba', 'Locadora CTBA', '100');
INSERT INTO locadora (bairro, cep, complemento, logradouro, nome_locadora, numero) VALUES ('Bairro Salvador', '40000-000', 'Complemento SSA', 'Rua Salvador', 'Locadora SSA', '200');
INSERT INTO locadora (bairro, cep, complemento, logradouro, nome_locadora, numero) VALUES ('Bairro Fortaleza', '60000-000', 'Complemento FORT', 'Rua Fortaleza', 'Locadora FORT', '300');

-- Carros
INSERT INTO carros (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2019, 1, 1, 1, 'Branco', 'Marca C', 'Modelo C', 'CDE-3456', 'url_para_imagem_carro4');
INSERT INTO carros (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2018, 1, 2, 2, 'Cinza', 'Marca D', 'Modelo D', 'FGH-5678', 'url_para_imagem_carro5');
INSERT INTO carros (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2017, 1, 3, 3, 'Vermelho', 'Marca E', 'Modelo E', 'IJK-6789', 'url_para_imagem_carro6');

-- Associação de Locadoras e Cidades
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (2, 1);
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (3, 2);
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (1, 3);

-- Associação de Carros e Características
INSERT INTO carros_caracteristicas (carro_id, caracteristica_id) VALUES (2, 1);
INSERT INTO carros_caracteristicas (carro_id, caracteristica_id) VALUES (2, 2);
INSERT INTO carros_caracteristicas (carro_id, caracteristica_id) VALUES (2, 3);
INSERT INTO carros_caracteristicas (carro_id, caracteristica_id) VALUES (3, 3);
INSERT INTO carros_caracteristicas (carro_id, caracteristica_id) VALUES (1, 2);

-- Clientes
INSERT INTO clientes (bairro, cep, complemento, logradouro, numero, telefone) VALUES ('Bairro Curitiba', '80000-111', 'Apto 11', 'Rua CTBA', '112', '41 98888-1111');
INSERT INTO clientes (bairro, cep, complemento, logradouro, numero, telefone) VALUES ('Bairro Salvador', '40000-222', 'Apto 22', 'Rua SSA', '223', '71 97777-2222');
INSERT INTO clientes (bairro, cep, complemento, logradouro, numero, telefone) VALUES ('Bairro Fortaleza', '60000-333', 'Casa 33', 'Rua FORT', '334', '85 96666-3333');

-- Reservas
INSERT INTO reserva (preco_total, carro_id, cliente_id, data_inicio, data_fim) VALUES (200.0, 2, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 3 DAY);
INSERT INTO reserva (preco_total, carro_id, cliente_id, data_inicio, data_fim) VALUES (250.0, 3, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 4 DAY);
INSERT INTO reserva (preco_total, carro_id, cliente_id, data_inicio, data_fim) VALUES (300.0, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 5 DAY);

-- Avaliações
INSERT INTO avaliacoes (pontuacao, carros_id, clientes_id, data_avaliacao, comentario) VALUES (4, 2, 2, CURRENT_TIMESTAMP(), 'Bom, mas poderia ser mais econômico.');
INSERT INTO avaliacoes (pontuacao, carros_id, clientes_id, data_avaliacao, comentario) VALUES (3, 3, 3, CURRENT_TIMESTAMP(), 'Adequado para o preço.');
INSERT INTO avaliacoes (pontuacao, carros_id, clientes_id, data_avaliacao, comentario) VALUES (5, 1, 1, CURRENT_TIMESTAMP(), 'Experiência incrível, carro perfeito!');
