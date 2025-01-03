CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(100) NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status TINYINT,
    autor VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    respuesta VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);
