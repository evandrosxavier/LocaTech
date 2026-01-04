CREATE TABLE veiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    placa VARCHAR(255),
    ano INT,
    cor VARCHAR(255),
    valordiaria DECIMAL(10,2)
);

INSERT INTO veiculos (marca, modelo, placa, ano, cor, valordiaria) VALUES
('Chevrolet', 'Celta', 'ABC-1234', 2010, 'Preto', 100.00),
('Volkswagen', 'Gol', 'DEF-5678', 2015, 'Branco', 120.00),
('Fiat', 'Uno', 'GHI-9012', 2012, 'Vermelho', 90.00),
('Ford', 'Ka', 'JKL-3456', 2018, 'Prata', 140.00),
('Hyundai', 'HB20', 'MNO-7890', 2020, 'Azul', 180.00),
('Toyota', 'Corolla', 'PQR-1122', 2019, 'Cinza', 220.00),
('Honda', 'Civic', 'STU-3344', 2017, 'Preto', 210.00),
('Renault', 'Sandero', 'VWX-5566', 2016, 'Branco', 130.00),
('Jeep', 'Renegade', 'YZA-7788', 2021, 'Verde', 260.00),
('Nissan', 'Versa', 'BCD-9900', 2018, 'Prata', 150.00);


CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(255),
    telefone VARCHAR(255),
    email VARCHAR(255)
);


INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Ana Clara Rezende', '123.456.789-01', '(11) 98765-4321', 'ana.rezende@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Bruno Costa e Silva', '234.567.890-12', '(21) 91234-5678', 'bruno.silva@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Carlos Eduardo Matos', '345.678.901-23', '(31) 92345-6789', 'carlos.matos@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Daniela Farias Lima', '456.789.012-34', '(41) 93456-7890', 'daniela.lima@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Eduardo Moreira Campos', '567.890.123-45', '(51) 94567-8901', 'eduardo.campos@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Fernanda Gonçalves Dias', '678.901.234-56', '(61) 95678-9012', 'fernanda.dias@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Gustavo Henrique Almeida', '789.012.345-67', '(71) 96789-0123', 'gustavo.almeida@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Helena Santos Oliveira', '890.123.456-78', '(81) 97890-1234', 'helena.oliveira@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Igor Nogueira Azevedo', '901.234.567-89', '(91) 98901-2345', 'igor.azevedo@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Juliana Pereira Rocha', '012.345.678-90', '(11) 99012-3456', 'juliana.rocha@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Lucas Martins Ferreira', '111.222.333-44', '(21) 98888-7777', 'lucas.ferreira@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Mariana Barros Ribeiro', '222.333.444-55', '(31) 97777-6666', 'mariana.ribeiro@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Nicolas Sousa Carvalho', '333.444.555-66', '(41) 96666-5555', 'nicolas.carvalho@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Olivia Mendes Castro', '444.555.666-77', '(51) 95555-4444', 'olivia.castro@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Pedro Teixeira Pinto', '555.666.777-88', '(61) 94444-3333', 'pedro.pinto@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Quintino Ramos Correia', '666.777.888-99', '(71) 93333-2222', 'quintino.correia@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Rafaela Cunha Gomes', '777.888.999-00', '(81) 92222-1111', 'rafaela.gomes@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Sofia Bernardes da Mota', '888.999.000-11', '(91) 91111-0000', 'sofia.mota@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Thiago Vasconcelos Neves', '999.000.111-22', '(11) 98765-1234', 'thiago.neves@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Ursula Xavier de Andrade', '000.111.222-33', '(21) 97654-2345', 'ursula.andrade@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Vitor Hugo Silveira', '121.232.343-45', '(31) 96543-3456', 'vitor.silveira@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Wanessa Freire Barbosa', '232.343.454-56', '(41) 95432-4567', 'wanessa.barbosa@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Yasmin Caldeira Duarte', '343.454.565-67', '(51) 94321-5678', 'yasmin.duarte@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Ziraldo Antunes Viana', '454.565.676-78', '(61) 93210-6789', 'ziraldo.viana@example.com');
INSERT INTO pessoas (nome, cpf, telefone, email) VALUES ('Laura Pires Cardoso', '565.676.787-89', '(71) 92109-7890', 'laura.cardoso@example.com');


