-- -----------------------------------------------------
-- Table "USUARIOS"
-- -----------------------------------------------------
CREATE TABLE  USUARIOS (
  "id_usuario" INT NOT NULL, -- identificador del usuario
  "nombre" VARCHAR(60) NOT NULL, -- nombre del usuario
  "apellido" VARCHAR(60) NULL, -- apellido del usuario
  "celular" NUMERIC NULL, -- celular de contacto
  "email" VARCHAR(70) NOT NULL, -- email para autenticación
  "password" VARCHAR(20) NOT NULL, -- password para autenticación
  PRIMARY KEY ("id_usuario"));


-- -----------------------------------------------------
-- Table "MASCOTAS"
-- -----------------------------------------------------
CREATE TABLE  MASCOTAS (
  "id_mascota" SERIAL NOT NULL, -- identificador de la mascota
  "id_usuario" INT NOT NULL, -- identificador del usurio
  "nombre_mascota" VARCHAR(50) NOT NULL, -- nombre de la mascota
  "tipo_mascota" CHAR(2) NOT NULL, -- Tipo registro mascota: P (Mascota Perdida), E (Mascota Encontrada), -- A Mascota en Adopción.
  "especie" VARCHAR(25) NOT NULL, -- Perro, Gato, Loro, Otro.
  "tamanio" VARCHAR(30) NOT NULL, -- Tamaño mascota: Chico, Mediano, Grande.
  "edad" INT NULL, -- Edad de la mascota.
  "color" VARCHAR(30), -- Color de la mascota.
  "comentarios" VARCHAR(300), -- comentario sobre la mascota perdida
  "estado" CHAR(1) NULL, -- A: Activar, I: Inactivar.
  PRIMARY KEY ("id_mascota"),
  CONSTRAINT "fk_MASCOTAS_USUARIOS1"
    FOREIGN KEY ("id_usuario")
    REFERENCES USUARIOS ("id_usuario")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);