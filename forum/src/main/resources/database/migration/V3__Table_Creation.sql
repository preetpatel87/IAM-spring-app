DROP TABLE `easy_eng`.`COURSE`;

CREATE TABLE `easy_eng`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `role` ENUM('student', 'parent', 'admin', 'tutor') NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `easy_eng`.`student_dashboard` (
  `student_id` INT NOT NULL,
  `grade` VARCHAR(45) NULL,
  `score` VARCHAR(45) NULL,
  `schedule_detail` VARCHAR(45) NULL,
  `goal` VARCHAR(45) NULL,
  `course` VARCHAR(45) NULL,
  PRIMARY KEY (`student_id`),
  CONSTRAINT `student_id`
    FOREIGN KEY (`student_id`)
    REFERENCES `easy_eng`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `easy_eng`.`tutor_student` (
  `tutor_id` INT NOT NULL,
  `student_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tutor_id`, `student_id`),
  CONSTRAINT `tutor_id`
    FOREIGN KEY (`tutor_id`)
    REFERENCES `easy_eng`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `easy_eng`.`parent_student` (
  `parent_id` INT NOT NULL,
  `student_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`parent_id`, `student_id`),
  CONSTRAINT `parent_id`
    FOREIGN KEY (`parent_id`)
    REFERENCES `easy_eng`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `easy_eng`.`course` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `info` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));

