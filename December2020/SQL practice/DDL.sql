-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Genre` (
  `GenreID` INT NOT NULL,
  `GenreName` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`GenreID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Director`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Director` (
  `DirectorID` INT NOT NULL,
  `FirstName` VARCHAR(30) NOT NULL,
  `LastName` VARCHAR(30) NOT NULL,
  `BirthDate` VARCHAR(45) NULL,
  PRIMARY KEY (`DirectorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rating` (
  `RatingID` INT NOT NULL,
  `RatingName` VARCHAR(5) NULL,
  PRIMARY KEY (`RatingID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Actor` (
  `ActorID` INT NOT NULL,
  `FirstName` VARCHAR(30) NOT NULL,
  `LastName` VARCHAR(30) NOT NULL,
  `BirthDate` DATE NULL,
  PRIMARY KEY (`ActorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Movie` (
  `MovieID` INT NOT NULL,
  `Title` VARCHAR(128) NOT NULL,
  `ReleaseDate` VARCHAR(45) NULL,
  `GenreID` INT NOT NULL,
  `Director_DirectorID` INT NOT NULL,
  `Rating_RatingID` INT NOT NULL,
  `Actor_ActorID` INT NOT NULL,
  PRIMARY KEY (`MovieID`, `GenreID`, `Director_DirectorID`, `Rating_RatingID`, `Actor_ActorID`),
  INDEX `fk_Movie_Genre_idx` (`GenreID` ASC) VISIBLE,
  INDEX `fk_Movie_Director1_idx` (`Director_DirectorID` ASC) VISIBLE,
  INDEX `fk_Movie_Rating1_idx` (`Rating_RatingID` ASC) VISIBLE,
  INDEX `fk_Movie_Actor1_idx` (`Actor_ActorID` ASC) VISIBLE,
  CONSTRAINT `fk_Movie_Genre`
    FOREIGN KEY (`GenreID`)
    REFERENCES `mydb`.`Genre` (`GenreID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_Director1`
    FOREIGN KEY (`Director_DirectorID`)
    REFERENCES `mydb`.`Director` (`DirectorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_Rating1`
    FOREIGN KEY (`Rating_RatingID`)
    REFERENCES `mydb`.`Rating` (`RatingID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_Actor1`
    FOREIGN KEY (`Actor_ActorID`)
    REFERENCES `mydb`.`Actor` (`ActorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CastMembers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CastMembers` (
  `CastMemberID` INT NOT NULL,
  `Role` VARCHAR(50) NULL,
  `Actor_ActorID` INT NOT NULL,
  `MovieID` INT NOT NULL,
  PRIMARY KEY (`CastMemberID`, `Actor_ActorID`, `MovieID`),
  INDEX `fk_CastMembers_Actor1_idx` (`Actor_ActorID` ASC) VISIBLE,
  INDEX `fk_CastMembers_Movie1_idx` (`MovieID` ASC) VISIBLE,
  CONSTRAINT `fk_CastMembers_Actor1`
    FOREIGN KEY (`Actor_ActorID`)
    REFERENCES `mydb`.`Actor` (`ActorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CastMembers_Movie1`
    FOREIGN KEY (`MovieID`)
    REFERENCES `mydb`.`Movie` (`MovieID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
