CREATE TABLE Produto
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  nome VARCHAR(200) NOT NULL,
  quantidade INTEGER NOT NULL,
  valor_Unitario DECIMAL(10,2) NOT NULL,
  data_Validade DATE NOT NULL,
  cod_Barra_Produto VARCHAR(14) NOT NULL,
  UNIQUE (cod_Barra_Produto)
);

CREATE TABLE Venda
(
  valor_Total DECIMAL(10,2) NOT NULL,
  data_saida DATE NOT NULL,
  id INTEGER PRIMARY KEY AUTOINCREMENT
);

CREATE TABLE Fornecedor
(
  nome VARCHAR(200) NOT NULL,
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  cidade VARCHAR(200) NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  CEP VARCHAR(10) NOT NULL,
  numero INTEGER NOT NULL,
  uf CHAR(2) NOT NULL,
  bairro VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  ramo_atuacao VARCHAR(200) NOT NULL,
  ativo boolean not null
);

CREATE TABLE Produto_Venda
(
  preco DECIMAL(10,2) NOT NULL,
  quantidade INTEGER NOT NULL,
  ID_Venda INTEGER NOT NULL,
  ID_Produto INTEGER NOT NULL,
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  FOREIGN KEY (ID_Venda) REFERENCES Venda(id),
  FOREIGN KEY (ID_Produto) REFERENCES Produto(id)
);

CREATE TABLE Fornecimento_produto
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  data_Entrada date NOT NULL,
  valor_Compra decimal(10,2) NOT NULL,
  ID_Produto INTEGER NOT NULL,
  ID_fornecedor INTEGER NOT NULL,
  FOREIGN KEY (ID_Produto) REFERENCES Produto(id),
  FOREIGN KEY (ID_fornecedor) REFERENCES Fornecedor(id),
  UNIQUE (ID_Produto, ID_fornecedor)
);

CREATE TABLE Fornecedor_telefone
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  telefone INTEGER NOT NULL,
  ID_fornecedor INTEGER NOT NULL,
  FOREIGN KEY (ID_fornecedor) REFERENCES Fornecedor(id)
);
