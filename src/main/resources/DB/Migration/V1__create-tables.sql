CREATE TABLE Produto
(
  id INT AUTO_INCREMENT,
  nome VARCHAR(200) NOT NULL,
  quantidade INT NOT NULL,
  valor_Unitario DECIMAL(10,2) NOT NULL,
  data_Validade DATE NOT NULL,
  cod_Barra_Produto VARCHAR(14) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (cod_Barra_Produto)
);

CREATE TABLE Venda
(
  valor_Total DECIMAL(10,2) NOT NULL,
  data_saida DATE NOT NULL,
  id INT AUTO_INCREMENT,
  PRIMARY KEY (id)
);

CREATE TABLE Fornecedor
(
  nome VARCHAR(200) NOT NULL,
  id INT AUTO_INCREMENT,
  cidade VARCHAR(200) NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  CEP VARCHAR(10) NOT NULL,
  numero INT NOT NULL,
  uf CHAR(2) NOT NULL,
  bairro VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  ramo_atuacao VARCHAR(200) NOT NULL,
  ativo boolean not null,
  PRIMARY KEY (id)
);

CREATE TABLE Produto_Venda
(
  preco DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  ID_Venda INT NOT NULL,
  ID_Produto INT NOT NULL,
  id INT AUTO_INCREMENT,
  PRIMARY KEY (id),
  FOREIGN KEY (ID_Venda) REFERENCES Venda(id),
  FOREIGN KEY (ID_Produto) REFERENCES Produto(id)
);

CREATE TABLE Fornecimento_produto
(
  id INT AUTO_INCREMENT,
  data_Entrada date NOT NULL,
  valor_Compra decimal(10,2) NOT NULL,
  ID_Produto INT NOT NULL,
  ID_fornecedor INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (ID_Produto) REFERENCES Produto(id),
  FOREIGN KEY (ID_fornecedor) REFERENCES Fornecedor(id),
  UNIQUE (ID_Produto, ID_fornecedor)
);

CREATE TABLE Fornecedor_telefone
(
  id INT AUTO_INCREMENT,
  telefone INT NOT NULL,
  ID_fornecedor INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (ID_fornecedor) REFERENCES Fornecedor(id)
);