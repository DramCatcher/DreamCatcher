# Dream Catcher



Das Projekt ist die zweite Leistungsbeurteilung des Moduls 245 in der schulischen Ausbildung an der CsBe in Bern, Schweiz.

## Die Applikation

[Dream Catcher](https://dreamcatcher.galister.ch) ist ein Minimum Viable Product (MVP) basierend auf einer im vorherigen Modul entwickelten Start-up-Idee. Der Fokus liegt bewusst auf den zentralen Funktionen:
- Erfassen von Träumen
- Visualisierung von Trauminhalten durch KI
- Träume speichern
- Abruf gespeicherter Träume

### Technologiestack

- **Backend:** Spring Boot
- **Frontend:** Angular
- **Webserver:** Nginx
- **Datenbank:** MariaDB

### Deployment MVP

Für das Deployment haben wir uns für eine direkte Bereitstellung auf einem Debian-Server entschieden.

Der Grund: Der Server war bereits als funktionierender Webserver im Einsatz.

## Anleitung

### Voraussetzungen

1. Ein Server mit einem Linux-basierten Betriebssystem.
    - [Installationsanleitung Debian](https://www.debian.org/releases/stable/i386/)
    - [Installationsanleitung Ubuntu](https://documentation.ubuntu.com/server/tutorial/basic-installation/index.html)
2. Ein installierter und konfigurierter Webserver, versehen mit einem gültigen TLS-Zertifikat, das von einer öffentlich vertrauenswürdigen Zertifizierungsstelle (Root CA) ausgestellt wurde.
    - Nginx:
        - [Installationsanleitung](https://docs.nginx.com/nginx/admin-guide/installing-nginx/installing-nginx-open-source/)
        - [Konfigurationsanleitung](https://nginx.org/en/docs/beginners_guide.html)
    - Apache:
        - [Installation- und Konfigurationsanleitung](https://ubuntu.com/tutorials/install-and-configure-apache#3-creating-your-own-website)
    - TLS-Zertifizierung:
        - [Anleitung von DigitalOcean für Nginx](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-20-04)
        - [Anleitung von DigitalOcean für Apache](https://www.digitalocean.com/community/tutorials/how-to-secure-apache-with-let-s-encrypt-on-ubuntu)
        - [Anleitung von Nginx](https://nginx.org/en/docs/http/configuring_https_servers.html)
3. Eine auf dem Server installierte MariaDB-Datenbank.
    - [Installationsanleitung von DigitalOcean für MariaDB](https://www.digitalocean.com/community/tutorials/how-to-install-mariadb-on-ubuntu-20-04)
    - [Installationsanleitung von MariaDB](https://mariadb.com/kb/en/getting-installing-and-upgrading-mariadb/)
4. Eine Datenbank und eine Tabelle mit der nächsten Struktur:
```
MariaDB [dreamcatcher_db]> desc dream;
+-----------+------------+------+-----+---------------------+----------------+
| Field     | Type       | Null | Key | Default             | Extra          |
+-----------+------------+------+-----+---------------------+----------------+
| id        | bigint(20) | NO   | PRI | NULL                | auto_increment |
| timestamp | datetime   | NO   |     | 2025-03-29 15:02:00 |                |
| title     | tinytext   | NO   |     | NULL                |                |
| content   | text       | YES  |     | NULL                |                |
| img       | mediumblob | YES  |     | NULL                |                |
+-----------+------------+------+-----+---------------------+----------------+
```
5. Ein Benutzer für die Datenbank:
````
MariaDB [dreamcatcher_db]> show grants for 'db_user_dc'@'localhost';
+-----------------------------------------------------------------------------+
| Grants for db_user_dc@localhost                                             |
+-----------------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `db_user_dc`@`localhost` IDENTIFIED BY PASSWORD 'xxx' |
| GRANT ALL PRIVILEGES ON `dreamcatcher_db`.* TO `db_user_dc`@`localhost`     |
+-----------------------------------------------------------------------------+
````

### Installation

1. Sicherstellen, das die Voraussetzungen erfüllt sind
2. Package Repository updaten:
```
sudo apt update
```
3. Benötigte Packages installieren:
```
sudo apt install tree curl openjdk-17-jdk maven -y
```
4. Installer von node.js herunterladen und ausführen
```
sudo curl -fsSL https://deb.nodesource.com/setup_20.x | sudo bash -
```
5. Nodejs installieren
```
sudo apt install nodejs -y
```
6. Angular cli installieren
```
sudo npm install -g @angular/cli
```
7. Repository clonen
```
git clone https://github.com/DramCatcher/DreamCatcher.git
```
8. Backend lokal kopieren
```
sudo mkdir -p /opt/dreamcatcher/backend && sudo cp -r DreamCatcher/Backend/* /opt/dreamcatcher/backend/
```
9. Benutzername und Passwort für Datenbankbenutzer setzen:
    - In der [Datei](./Backend/src/main/resources/application.yml) 'username' und 'password' setzen
10. Backend bauen
```
cd /opt/dreamcatcher/backend && sudo mvn clean package
```
11. Backend als Systemdienst anlegen
```
sudo tee /etc/systemd/system/dc_backend.service > /dev/null <<EOF
[Unit]
Description=Dreamcatcher Backend Service
After=network.target

[Service]
ExecStart=/usr/bin/java -jar /opt/dreamcatcher/backend/target/$(ls /opt/dreamcatcher/backend/target | grep ".jar$")
WorkingDirectory=/opt/dreamcatcher/backend
Restart=always

[Install]
WantedBy=multi-user.target
EOF
```
12. Systemd neu laden
```
sudo systemctl daemon-reload
```
13. Backend-Dienst einschalten
```
sudo systemctl enable dc_backend.service && sudo systemctl start dc_backend.service
```
14. Kontrollieren, ob das backend läuft
```
if ! systemctl is-active --quiet dc_backend.service; then echo "Backend läuft nicht" 1; else echo "Backend läuft" ; fi
```
15. In das GitHub-Repo wechseln
16. Statische Dateien für das Frontend erstellen
```
cd Frontend && npm install && ng build --configuration production
```
17. In das GitHub-Repo wechseln
18. Statische Dateien vom Frontend in das Verzeichnis des Webservers kopieren
```
sudo cp Frontend/dist/dream-catcher/browser/* /var/www/<deine-webseite>/
```
19. Berechtigungen von neuen Dateien anpassen
```
sudo chown -R www-data:www-data /var/www/<deine-webseite>
```
20. Webserver neu starten beim nginx
```
sudo systemctl restart nginx 
```
20. Oder Webserver neu starten beim apache
```
sudo systemctl restart apache2 
```
