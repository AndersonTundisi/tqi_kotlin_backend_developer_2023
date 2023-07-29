CREATE TABLE carrinho_de_compra (
  id BIGINT AUTO_INCREMENT NOT NULL,
   cpf_cliente VARCHAR(255) NULL,
   data_operacao datetime NULL,
   token VARCHAR(255) NULL,
   forma_pagamento VARCHAR(255) NULL,
   valor_total_itens DOUBLE NOT NULL,
   CONSTRAINT pk_carrinhodecompra PRIMARY KEY (id)
);

CREATE TABLE carrinho_de_compra_produtos (
  carrinho_de_compra_id BIGINT NOT NULL,
   produtos_id BIGINT NOT NULL
);

ALTER TABLE carrinho_de_compra_produtos ADD CONSTRAINT uc_carrinho_de_compra_produtos_produtos UNIQUE (produtos_id);

ALTER TABLE carrinho_de_compra_produtos ADD CONSTRAINT fk_cardecompro_on_carrinho_de_compra FOREIGN KEY (carrinho_de_compra_id) REFERENCES carrinho_de_compra (id);

ALTER TABLE carrinho_de_compra_produtos ADD CONSTRAINT fk_cardecompro_on_item_carrinho FOREIGN KEY (produtos_id) REFERENCES item_carrinho (id);