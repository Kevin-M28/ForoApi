create table topico(
    id INT NOT null auto_increment,
    titulo VARCHAR(255),
    mensaje TEXT(20000),
    fecha_creacion DATE,
    estatus BOOL,
    autor VARCHAR(255),
    curso VARCHAR(255),
    PRIMARY KEY (id)
);