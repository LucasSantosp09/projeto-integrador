-- Categorias
INSERT INTO categoria (descricao, url_imagem) VALUES ('Esportivo', 'url_para_imagem_esportivo');
INSERT INTO categoria (descricao, url_imagem) VALUES ('Hatch', 'url_para_imagem_hatch');
INSERT INTO categoria (descricao, url_imagem) VALUES ('Pickup', 'url_para_imagem_pickup');

-- Características dos Carros
INSERT INTO caracteristica_carro (descricao) VALUES ('Câmbio manual');
INSERT INTO caracteristica_carro (descricao) VALUES ('Híbrido');
INSERT INTO caracteristica_carro (descricao) VALUES ('Elétrico');

-- Cidades
INSERT INTO cidade (nome_cidade) VALUES ('Curitiba');
INSERT INTO cidade (nome_cidade) VALUES ('Salvador');
INSERT INTO cidade (nome_cidade) VALUES ('Fortaleza');

-- Locadoras
INSERT INTO locadora (nome_locadora, logradouro, bairro, numero, complemento, cep) VALUES ('Locadora CTBA', 'Rua Santos', 'Bairro Santos', '130', 'Não possui', '10000-000');
INSERT INTO locadora (nome_locadora, logradouro, bairro, numero, complemento, cep) VALUES ('Locadora ABCD', 'Rua Almir', 'Bairro Real', '150', 'apt 203', '20000-000');
INSERT INTO locadora (nome_locadora, logradouro, bairro, numero, complemento, cep) VALUES ('Locadora DHAQ', 'Rua Veja', 'Bairro Revista', '5330', 'apt 702', '30000-000');

-- Carros
INSERT INTO carro (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2019, 1, 1, 1, 'Branco', 'Marca C', 'Modelo C', 'CDE-3456', 'url_para_imagem_carro4');
INSERT INTO carro (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2018, 1, 2, 2, 'Cinza', 'Marca D', 'Modelo D', 'FGH-5678', 'url_para_imagem_carro5');
INSERT INTO carro (ano, status, categoria_id, locadora_id, cor, marca, modelo, placa, url_imagem) VALUES (2017, 1, 3, 3, 'Vermelho', 'Marca E', 'Modelo E', 'IJK-6789', 'url_para_imagem_carro6');

-- Associação de Locadoras e Cidades
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (2, 1);
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (3, 2);
INSERT INTO locadora_cidade (locadora_id, cidade_id) VALUES (1, 3);

-- Associação de Carros e Características
INSERT INTO carro_caracteristica (carro_id, caracteristica_id) VALUES (2, 1);
INSERT INTO carro_caracteristica (carro_id, caracteristica_id) VALUES (2, 2);
INSERT INTO carro_caracteristica (carro_id, caracteristica_id) VALUES (2, 3);
INSERT INTO carro_caracteristica (carro_id, caracteristica_id) VALUES (3, 3);
INSERT INTO carro_caracteristica (carro_id, caracteristica_id) VALUES (1, 2);

-- Usuario
INSERT INTO usuario (nome, email, telefone, logradouro, bairro, numero, complemento, cep) VALUES ('Carlos', 'Carlos@gmail.com', '71 97777-2112', 'Rua Anjos', 'Bairro Topper', '130', 'apt 205', '40000-222');
INSERT INTO usuario (nome, email, telefone, logradouro, bairro, numero, complemento, cep) VALUES ('Lucas', 'Lucas@gmail.com', '12 97244-2233', 'Rua Delta', 'Bairro Jardins', '1234', 'casa', '34000-222');
INSERT INTO usuario (nome, email, telefone, logradouro, bairro, numero, complemento, cep) VALUES ('Maria', 'Maria@gmail.com', '23 97233-5552', 'Rua Esfera', 'Bairro Saraiva', '4232', 'apt 789', '67800-222');

-- Reservas
INSERT INTO reserva (preco_total, carro_id, usuario_id, data_inicio, data_fim) VALUES (200.0, 2, 2, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 3 DAY);
INSERT INTO reserva (preco_total, carro_id, usuario_id, data_inicio, data_fim) VALUES (250.0, 3, 3, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 4 DAY);
INSERT INTO reserva (preco_total, carro_id, usuario_id, data_inicio, data_fim) VALUES (300.0, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP() + INTERVAL 5 DAY);

-- Avaliações
INSERT INTO avaliacao (pontuacao, carro_id, usuario_id, data_avaliacao, comentario) VALUES (1, 2, 2, CURRENT_TIMESTAMP(), 'Bom, mas poderia ser mais econômico.');
INSERT INTO avaliacao (pontuacao, carro_id, usuario_id, data_avaliacao, comentario) VALUES (2, 3, 3, CURRENT_TIMESTAMP(), 'Adequado para o preço.');
INSERT INTO avaliacao (pontuacao, carro_id, usuario_id, data_avaliacao, comentario) VALUES (3, 1, 1, CURRENT_TIMESTAMP(), 'Experiência incrível, carro perfeito!');
