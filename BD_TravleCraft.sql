-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Exam
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Exam` ;

-- -----------------------------------------------------
-- Schema Exam
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Exam` DEFAULT CHARACTER SET utf8mb4 ;
USE `Exam` ;

-- -----------------------------------------------------
-- Table `Exam`.`AppUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Exam`.`AppUser` (
  `idAppUser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAppUser`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `Exam`.`itinerario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Exam`.`itinerario` (
  `iditinerario` INT(11) NOT NULL AUTO_INCREMENT,
  `destino` VARCHAR(45) NOT NULL,
  `enlace` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `tipogrupo` VARCHAR(45) NULL DEFAULT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `aceptado` TINYINT(1) NOT NULL,
  PRIMARY KEY (`iditinerario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `Exam`.`guardado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Exam`.`guardado` (
  `idguardados` INT(11) NOT NULL AUTO_INCREMENT,
  `itinerario_iditinerario` INT(11) NOT NULL,
  `AppUser_idAppUser` INT(11) NOT NULL,
  PRIMARY KEY (`idguardados`),
  INDEX `fk_guardado_itinerario1_idx` (`itinerario_iditinerario` ASC) VISIBLE,
  INDEX `fk_guardado_AppUser1_idx` (`AppUser_idAppUser` ASC) VISIBLE,
  CONSTRAINT `fk_guardado_AppUser1`
    FOREIGN KEY (`AppUser_idAppUser`)
    REFERENCES `Exam`.`AppUser` (`idAppUser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_guardado_itinerario1`
    FOREIGN KEY (`itinerario_iditinerario`)
    REFERENCES `Exam`.`itinerario` (`iditinerario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `Exam`.`valoracion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Exam`.`valoracion` (
  `idvaloracion` INT(11) NOT NULL AUTO_INCREMENT,
  `nota` INT(11) NOT NULL,
  `comentario` VARCHAR(45) NULL DEFAULT NULL,
  `itinerario_iditinerario` INT(11) NOT NULL,
  PRIMARY KEY (`idvaloracion`),
  INDEX `fk_valoracion_itinerario_idx` (`itinerario_iditinerario` ASC) VISIBLE,
  CONSTRAINT `fk_valoracion_itinerario`
    FOREIGN KEY (`itinerario_iditinerario`)
    REFERENCES `Exam`.`itinerario` (`iditinerario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
