CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT primary key,
    nombre VARCHAR(100) NOT NULL,
    email varchar(100) NOT NULL,
    clave varchar(300) not null
);
