CREATE TABLE item_carrinho (
  id BIGINT AUTO_INCREMENT NOT NULL,
   produto_id BIGINT NULL,
   quantidade_item INT NOT NULL,
   carrinho_id BIGINT NULL,
   CONSTRAINT pk_itemcarrinho PRIMARY KEY (id)
);

ALTER TABLE item_carrinho ADD CONSTRAINT FK_ITEMCARRINHO_ON_CARRINHO FOREIGN KEY (carrinho_id) REFERENCES carrinho_de_compra (id);

ALTER TABLE item_carrinho ADD CONSTRAINT FK_ITEMCARRINHO_ON_PRODUTO FOREIGN KEY (produto_id) REFERENCES produto (id);