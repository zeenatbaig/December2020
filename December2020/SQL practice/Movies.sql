-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Movies
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Movies
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Movies` DEFAULT CHARACTER SET utf8 ;
USE `Movies` ;

-- -----------------------------------------------------
-- Table `Movies`.`Genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`Genre` (
  `GenreID` INT NOT NULL AUTO_INCREMENT,
  `GenreName` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`GenreID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movies`.`Director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`Director` (
  `DirectorID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(30) NOT NULL,
  `LastName` VARCHAR(30) NOT NULL,
  `BirthDate` VARCHAR(45) NULL,
  PRIMARY KEY (`DirectorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movies`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`Rating` (
  `RatingID` INT NOT NULL AUTO_INCREMENT,
  `RatingName` VARCHAR(5) NULL,
  PRIMARY KEY (`RatingID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movies`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`Movie` (
  `MovieID` INT NOT NULL AUTO_INCREMENT,
  `GenreID` INT NULL,
  `Director_DirectorID` INT NULL,
  `Rating_RatingID` INT NULL,
  `Title` VARCHAR(128) NOT NULL,
  `ReleaseDate` VARCHAR(45) NULL,
  PRIMARY KEY (`MovieID`),
  INDEX `fk_Movie_Genre_idx` (`GenreID` ASC) VISIBLE,
  INDEX `fk_Movie_Director1_idx` (`Director_DirectorID` ASC) VISIBLE,
  INDEX `fk_Movie_Rating1_idx` (`Rating_RatingID` ASC) VISIBLE,
  CONSTRAINT `fk_Movie_Genre`
    FOREIGN KEY (`GenreID`)
    REFERENCES `Movies`.`Genre` (`GenreID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_Director1`
    FOREIGN KEY (`Director_DirectorID`)
    REFERENCES `Movies`.`Director` (`DirectorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_Rating1`
    FOREIGN KEY (`Rating_RatingID`)
    REFERENCES `Movies`.`Rating` (`RatingID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movies`.`Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`Actor` (
  `ActorID` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(30) NOT NULL,
  `LastName` VARCHAR(30) NOT NULL,
  `BirthDate` DATE NULL,
  PRIMARY KEY (`ActorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Movies`.`CastMembers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Movies`.`CastMembers` (
  `CastMemberID` INT NOT NULL AUTO_INCREMENT,
  `Actor_ActorID` INT NOT NULL,
  `MovieID` INT NOT NULL,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`CastMemberID`),
  INDEX `fk_CastMembers_Actor1_idx` (`Actor_ActorID` ASC) VISIBLE,
  INDEX `fk_CastMembers_Movie1_idx` (`MovieID` ASC) VISIBLE,
  CONSTRAINT `fk_CastMembers_Actor1`
    FOREIGN KEY (`Actor_ActorID`)
    REFERENCES `Movies`.`Actor` (`ActorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CastMembers_Movie1`
    FOREIGN KEY (`MovieID`)
    REFERENCES `Movies`.`Movie` (`MovieID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
