ALTER TABLE giorni_clients_dev.cliente
    MODIFY `ID_Cliente` int NOT NULL AUTO_INCREMENT;

ALTER TABLE giorni_clients_dev.endereco
    MODIFY `ID_Endereco` int NOT NULL AUTO_INCREMENT;

INSERT INTO giorni_clients_dev.cliente (Nome, Telefone, Email)
VALUES ('João Silva', '11987654321', 'joao.silva@email.com');

INSERT INTO giorni_clients_dev.cliente (Nome, Telefone, Email)
VALUES ('Maria Oliveira', '21987654321', 'maria.oliveira@email.com');

INSERT INTO giorni_clients_dev.cliente (Nome, Telefone, Email)
VALUES ('Carlos Pereira', '31987654321', 'carlos.pereira@email.com');

INSERT INTO giorni_clients_dev.cliente (Nome, Telefone, Email)
VALUES ('Ana Costa', '41987654321', 'ana.costa@email.com');

INSERT INTO giorni_clients_dev.cliente (Nome, Telefone, Email)
VALUES ('Lucas Santos', '51987654321', 'lucas.santos@email.com');


INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Centro', 'Rua A', 'São Paulo', 'SP', '01000-000', 1);

INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Jardins', 'Rua B', 'São Paulo', 'SP', '01400-000', 2);

INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Copacabana', 'Rua C', 'Rio de Janeiro', 'RJ', '22000-000', 3);

INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Ipanema', 'Rua D', 'Rio de Janeiro', 'RJ', '22400-000', 4);

INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Savassi', 'Rua E', 'Belo Horizonte', 'MG', '30100-000', 5);

INSERT INTO giorni_clients_dev.endereco (Bairro, Rua, Cidade, Estado, CEP, id_cliente)
VALUES ('Funcionários', 'Avenida do Contorno', 'Belo Horizonte', 'MG', '30110-100', 5);




