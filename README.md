 **⚠️ Atenção:** Os diagramas e o script são relevantes apenas para o caso de uso Solicita Afiliação.

**📘 1. Diagrama de Sequência**

![Diagrama de sequência básico](https://github.com/user-attachments/assets/33c59d2a-628b-4297-a7a3-e8946d565915)


**🧩 2. Diagrama de Classes**

![Fluxograma (8)](https://github.com/user-attachments/assets/2df2da75-e92d-4d94-ba4c-143e9cef19ee)



**🗄️ 3. Script do Banco de Dados (MySQL)**

<details>
 <summary> Clique aqui para expandir </summary>
  
[ScriptBD.sql](https://github.com/user-attachments/files/23663530/ScriptBD.sql)
````
Create DATABASE db2;
USE db2;

DROP TABLE IF EXISTS mensagem_valida;
DROP TABLE IF EXISTS mensagem_email;
DROP TABLE IF EXISTS mensagem_Cand;
DROP TABLE IF EXISTS mensagem_notificacao;

DROP TABLE IF EXISTS Sessao;

DROP TABLE IF EXISTS Identidade;
DROP TABLE IF EXISTS Email;

DROP TABLE IF EXISTS ItemAceite;
DROP TABLE IF EXISTS AceiteTermo;

DROP TABLE IF EXISTS Afiliacao;
DROP TABLE IF EXISTS ItemTermo;
DROP TABLE IF EXISTS Interesse;
DROP TABLE IF EXISTS Habilidade;

DROP TABLE IF EXISTS RepresentadoPor;
DROP TABLE IF EXISTS Certidao;

DROP TABLE IF EXISTS PessoaJuridica;
DROP TABLE IF EXISTS PessoaFisica;

DROP TABLE IF EXISTS Perfil;
DROP TABLE IF EXISTS Candidato;
DROP TABLE IF EXISTS Termo;

DROP TABLE IF EXISTS Endereco;

DROP TABLE IF EXISTS Entidade;



CREATE TABLE Entidade (
    idEntidade INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL
);

CREATE TABLE Endereco (
    idEndereco INT PRIMARY KEY AUTO_INCREMENT,
    idEntidade INT,
    local VARCHAR(150),
    FOREIGN KEY (idEntidade)
        REFERENCES Entidade(idEntidade)
        ON DELETE CASCADE
);

-- 2. Perfil


CREATE TABLE Termo (
    idTermo INT PRIMARY KEY AUTO_INCREMENT,
    nomeTermo VARCHAR(200)
);


CREATE TABLE Candidato (
    idCand INT PRIMARY KEY AUTO_INCREMENT,
    STATUS CHAR(100)
);

CREATE TABLE Perfil (
    idPerfil INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(200),
    idCand INT,
    FOREIGN KEY (idCand)
        REFERENCES Candidato(idCand)
        ON DELETE CASCADE
);


CREATE TABLE PessoaFisica (
    cpf CHAR(11) PRIMARY KEY,
    idEntidade INT UNIQUE,
    idCand INT,
    FOREIGN KEY (idEntidade)
        REFERENCES Entidade(idEntidade)
        ON DELETE CASCADE,
    FOREIGN KEY (idCand)
        REFERENCES Candidato(idCand) ON DELETE CASCADE
);


CREATE TABLE PessoaJuridica (
    cnpj CHAR(14) PRIMARY KEY,
    cpf_representante CHAR(11),
    idEntidade INT UNIQUE,
    FOREIGN KEY (idEntidade)
        REFERENCES Entidade(idEntidade)
        ON DELETE CASCADE,
     FOREIGN KEY (cpf_representante)
        REFERENCES PessoaFisica(cpf)
        ON DELETE CASCADE   
);


CREATE TABLE Certidao (
    idCertidao INT PRIMARY KEY AUTO_INCREMENT,
    cnpj CHAR(14),
    legalNome VARCHAR(120),
    registroEmpresa VARCHAR(120),
    anexadoCertidao DATE,
    FOREIGN KEY (cnpj)
        REFERENCES PessoaJuridica(cnpj)
        ON DELETE CASCADE
);

CREATE TABLE Habilidade (
    idHabi INT PRIMARY KEY AUTO_INCREMENT,
    idPerfil INT,
    descricao VARCHAR(200),
    FOREIGN KEY (idPerfil)
        REFERENCES Perfil(idPerfil) ON DELETE CASCADE
);


CREATE TABLE Interesse (
    idInte INT AUTO_INCREMENT PRIMARY KEY,
    idPerfil INT,
    descricao VARCHAR(200),
    FOREIGN KEY (idPerfil)
        REFERENCES Perfil(idPerfil) ON DELETE CASCADE
);


CREATE TABLE ItemTermo (
    idItemTermo INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(500),
    idTermo INT,
    FOREIGN KEY (idTermo)
        REFERENCES Termo(idTermo)
        ON DELETE CASCADE
);


CREATE TABLE Afiliacao (
    idAfiliacao INT PRIMARY KEY AUTO_INCREMENT,
    STATUS VARCHAR(100),
    idCand INT,
    FOREIGN KEY (idCand)
        REFERENCES Candidato(idCand)
        ON DELETE CASCADE
);


CREATE TABLE AceiteTermo (
    idAceite INT AUTO_INCREMENT,
    idAfiliacao INT,
    idTermo INT,
    PRIMARY KEY (idAceite, idAfiliacao, idTermo),
    FOREIGN KEY (idAfiliacao)
        REFERENCES Afiliacao(idAfiliacao)
        ON DELETE CASCADE,
    FOREIGN KEY (idTermo)
        REFERENCES Termo(idTermo)
        ON DELETE CASCADE
);


CREATE TABLE ItemAceite (
    idItemAceite INT AUTO_INCREMENT,
    idAceite INT,
    idItemTermo INT,
    descricao VARCHAR(500),
    PRIMARY KEY (idItemAceite, idAceite, idItemTermo),
    FOREIGN KEY (idAceite)
        REFERENCES AceiteTermo(idAceite)
        ON DELETE CASCADE,
    FOREIGN KEY (idItemTermo)
        REFERENCES ItemTermo(idItemTermo)
        ON DELETE CASCADE
);


CREATE TABLE Email (
    idEmail INT AUTO_INCREMENT,
    idEntidade INT,
    enderecoEmail VARCHAR(200) NOT NULL,
    PRIMARY KEY (idEmail, idEntidade),
    FOREIGN KEY (idEntidade)
        REFERENCES Entidade(idEntidade) ON DELETE CASCADE
);


CREATE TABLE Identidade (
    idIdenti INT PRIMARY KEY AUTO_INCREMENT,
    cpf CHAR(11),
    estadoCivil VARCHAR(150) NOT NULL,
    data_nascimento DATE NOT NULL,
    nacionalidade VARCHAR(150),
    profissao VARCHAR(150),
    sexo VARCHAR(1),
    FOREIGN KEY (cpf)
        REFERENCES PessoaFisica(cpf)
        ON DELETE CASCADE
);

INSERT INTO Termo (nomeTermo)
VALUES ('Termo de Uso e Afiliação da Plataforma');


SET @idTermo = LAST_INSERT_ID();

INSERT INTO ItemTermo (descricao, idTermo) VALUES
('Item 1 – Objeto: O presente Termo tem por objeto regular as condições de uso da Plataforma, bem como o processo de afiliação do Candidato, seja pessoa física ou jurídica, visando o acesso aos serviços e recursos disponibilizados.', @idTermo),
('Item 2 – Cadastro e Veracidade das Informações: O Candidato se compromete a fornecer informações verdadeiras, completas e atualizadas em seu perfil. A falsidade ou omissão de dados poderá acarretar na suspensão ou cancelamento da afiliação.', @idTermo),
('Item 3 – Responsabilidades do Candidato: O Candidato compromete-se a: Utilizar a Plataforma apenas para os fins propostos. Não compartilhar suas credenciais de acesso. Manter seu cadastro atualizado e válido. Cumprir todas as normas e políticas complementares da Plataforma.', @idTermo),
('Item 4 – Aceite de Termos Complementares: O Candidato poderá ser convidado a aceitar novos Termos ou atualizações, os quais entrarão em vigor no momento de sua aceitação eletrônica.', @idTermo),
('Item 5 – Tratamento de Dados Pessoais: Ao aceitar este Termo, o Candidato autoriza o tratamento de seus dados pessoais conforme a Lei Geral de Proteção de Dados (Lei nº 13.709/2018), exclusivamente para as finalidades operacionais da Plataforma.', @idTermo),
('Item 6 – Rescisão e Cancelamento: O vínculo de afiliação poderá ser encerrado: A pedido do Candidato, mediante solicitação formal. Pela Plataforma, em caso de violação das condições aqui descritas. O cancelamento não isenta o Candidato de eventuais responsabilidades anteriores.', @idTermo),
('Item 7 – Foro: Fica eleito o foro da Comarca de [Cidade/UF], para dirimir quaisquer dúvidas ou controvérsias decorrentes deste Termo.', @idTermo);


INSERT INTO Termo (nomeTermo)
VALUES ('Termos Opcionais da Plataforma');


SET @idTermoOpcional = LAST_INSERT_ID();

INSERT INTO ItemTermo (descricao, idTermo) VALUES
('Item 1 – Participação em Programas Promocionais: O Candidato poderá optar por participar de programas promocionais da Plataforma, que envolvem ofertas especiais e campanhas.', @idTermoOpcional);

INSERT INTO ItemTermo (descricao, idTermo) VALUES
('Item 2 – Recebimento de Newsletter: O Candidato poderá autorizar o envio de comunicados,novidades e informações promocionais por e-mail.', @idTermoOpcional);

INSERT INTO ItemTermo (descricao, idTermo) VALUES
('Item 3 – Aceite de Termos Complementares Opcionais: O Candidato poderá aceitar termos adicionais que não sejam obrigatórios para uso da Plataforma, mas que ofereçam funcionalidades extras.', @idTermoOpcional);
````
</details>
