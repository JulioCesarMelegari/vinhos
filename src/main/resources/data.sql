-- Garante que a tabela está limpa antes de inserir (opcional, dependendo da sua estratégia ddl-auto)

DELETE FROM table_vinho;

INSERT INTO table_vinho (nome, origem, tipo, uva, preco, harmonizacao, descricao, imagem) VALUES
('Alma Negra Misterio', 'Argentina', 'Tinto', 'Malbec', 189.90, 'Churrasco, carnes vermelhas assadas e massas com molhos intensos.', 'Um tinto misterioso, encorpado e complexo, com notas de frutas escuras e especiarias.', 'alma_negra.jpg'),

('Casillero del Diablo Reserva', 'Chile', 'Tinto', 'Cabernet Sauvignon', 59.90, 'Carnes vermelhas grelhadas, queijos maduros e massas ao molho bolonhesa.', 'Um clássico chileno estruturado, com taninos firmes e aroma marcante de baunilha e ameixa.', 'casillero_cabernet.jpg'),

('Cartuxa Évora DOC', 'Portugal', 'Tinto', 'Blend Alentejano', 249.00, 'Cordeiro assado, bacalhau de forno e pratos tradicionais portugueses.', 'Vinho alentejano sofisticado, elegante, com excelente equilíbrio entre fruta e madeira.', 'cartuxa_tinto.jpg'),

('Leopoldina Gran Reserva', 'Brasil', 'Branco', 'Chardonnay', 120.00, 'Frutos do mar grelhados, salmão assado, risotos de queijo leve e aves.', 'Branco nacional premium encorpado, com passagem por barricas de carvalho, notas amanteigadas e de baunilha.', 'leopoldina_chardonnay.jpg'),

('Villa Antinori Toscana', 'Itália', 'Tinto', 'Sangiovese', 199.90, 'Massas com molhos vermelhos estruturados, lasanha de carne e risoto de funghi.', 'Um clássico toscano moderno, elegante, frutado e com acidez gastronômica perfeita.', 'villa_antinori.jpg'),

('Concha y Toro Exportacion', 'Chile', 'Doce / Suave', 'Blend', 39.90, 'Sobremesas à base de frutas ou queijos azuis.', 'Um vinho suave de entrada, fácil de beber, ideal para quem prefere paladares mais adocicados.', 'concha_suave.jpg'),

('Garzón Reserva', 'Uruguai', 'Tinto', 'Tannat', 98.00, 'Carnes gordas de churrasco, costela bovina e assados de caça.', 'O Tannat uruguaio perfeito: potente, com taninos maduros e notas expressivas de frutos negros.', 'garzon_tannat.jpg'),

('Jacob''s Creek Classic', 'Austrália', 'Branco', 'Chardonnay', 75.00, 'Saladas tropicais, frango grelhado e peixes brancos de água salgada.', 'Branco australiano refrescante, com notas vibrantes de melão, pêssego e um toque cítrico suave.', 'jacobs_creek.jpg'),

('Pera Manca Branco', 'Portugal', 'Branco', 'Antão Vaz', 650.00, 'Pratos finos de frutos do mar, lagosta e lagostins na manteiga.', 'Um dos brancos mais cultuados de Portugal. Raro, complexo e com incrível potencial de guarda.', 'pera_manca_branco.jpg'),

('Freixenet Cordon Negro', 'Espanha', 'Espumante', 'Macabeo', 95.00, 'Petiscos finos, culinária japonesa, canapés de salmão e ceviche.', 'Cava espanhol Brut leve, refrescante, frutado e com perlage (bolhas) fina e persistente.', 'freixenet_brut.jpg'),

('Chandon Passion', 'Brasil', 'Espumante', 'Malvasia', 110.00, 'Sobremesas de frutas tropicais, sorvetes ou para tomar com cubas de gelo.', 'Espumante demi-sec aromático, com notas de maracujá e lichia. Perfeito para drinks.', 'chandon_passion.jpg'),

('Whispering Angel', 'França', 'Rosé', 'Grenache', 289.00, 'Culinária mediterrânea, tábua de frios, carpaccio e camarão alho e óleo.', 'O rosé de Provence definitivo. Extremamente leve, seco, elegante e com notas minerais e florais.', 'whispering_rosé.jpg'),

('Casal Garcia Vinho Verde', 'Portugal', 'Branco', 'Trajadura', 49.90, 'Petiscos de praia, bolinho de bacalhau e saladas verdes com limão.', 'O vinho verde mais famoso do mundo. Jovem, leve, levemente frisante e extremamente refrescante.', 'casal_garcia.jpg'),

('Yellow Tail', 'Austrália', 'Tinto', 'Shiraz', 69.90, 'Hambúrguer artesanal, pizzas variadas e carnes de panela condimentadas.', 'Shiraz australiano muito macio e jovem, com forte presença de frutas vermelhas doces e especiarias.', 'yellow_tail_shiraz.jpg'),

('Catena Zapata High Mountain', 'Argentina', 'Tinto', 'Malbec', 220.00, 'Cortes de carne argentinos (ojo de bife, bife de tira) e queijos duros.', 'Um dos Malbecs mais prestigiados do mundo, cultivado em grandes altitudes com excelente estrutura e elegância.', 'catena_malbec.jpg');
