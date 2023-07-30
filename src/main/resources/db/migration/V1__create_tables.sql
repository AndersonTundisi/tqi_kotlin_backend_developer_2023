CREATE TABLE categoria (
  id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   CONSTRAINT pk_categoria PRIMARY KEY (id)
);

CREATE TABLE produto (
  id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   unidade_de_medida INT NOT NULL,
   valor_unitario DOUBLE NOT NULL,
   quantidade_estoque INT NOT NULL,
   categoria_id BIGINT NULL,
   code_produto BINARY(16) NULL,
   CONSTRAINT pk_produto PRIMARY KEY (id)
);

ALTER TABLE produto ADD CONSTRAINT FK_PRODUTO_ON_CATEGORIA FOREIGN KEY (categoria_id) REFERENCES categoria (id);


CREATE TABLE carrinho_de_compra (
  id BIGINT AUTO_INCREMENT NOT NULL,
   cpf_cliente VARCHAR(255) NULL,
   data_operacao datetime NULL,
   token VARCHAR(255) NULL,
   forma_pagamento VARCHAR(255) NULL,
   valor_total_itens DOUBLE NOT NULL,
   CONSTRAINT pk_carrinhodecompra PRIMARY KEY (id)
);


CREATE TABLE item_carrinho (
  id BIGINT AUTO_INCREMENT NOT NULL,
   produto_id BIGINT NULL,
   quantidade_item INT NOT NULL,
   carrinho_id BIGINT NULL,
   CONSTRAINT pk_itemcarrinho PRIMARY KEY (id)
);

ALTER TABLE item_carrinho ADD CONSTRAINT FK_ITEMCARRINHO_ON_CARRINHO FOREIGN KEY (carrinho_id) REFERENCES carrinho_de_compra (id);

ALTER TABLE item_carrinho ADD CONSTRAINT FK_ITEMCARRINHO_ON_PRODUTO FOREIGN KEY (produto_id) REFERENCES produto (id);