CREATE DATABASE dreamcatcher_db;
USE dreamcatcher_db;
CREATE TABLE dream (
    `id`                  INT AUTO_INCREMENT PRIMARY KEY,
    `timestamp`           DATETIME NOT NULL DEFAULT '2025-03-29 15:02:00',
    `title`               TINYTEXT NOT NULL,
    `content`             TEXT NOT NULL,
    `img`                 BLOB
);
CREATE USER 'db_user_dc'@'localhost' IDENTIFIED BY 'please_let_us_alone_1990';
GRANT ALL PRIVILEGES ON dreamcatcher_db.* TO 'db_user_dc'@'localhost';
