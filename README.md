# Dream Catcher

Dieses Projekt stellt die zweite Leistungsbeurteilung im Rahmen des Moduls 245 der schulischen Ausbildung an der CsBe in Bern, Schweiz, dar.

**Applikation:** [Dream Catcher](dreamcatcher.galister.ch)

**Ersteller:** *J.S., P.V., F.S., I.G.*

**Dozent:** *M.M.*

**Rollen:**
- Projektleitung: F.S.
- Frontend-Entwicklung: J.S.
- Backend-Entwicklung: P.V.
- Deployment: I.G.

## Die Applikation

Dream Catcher ist ein Minimum Viable Product (MVP) basierend auf einer im vorherigen Modul entwickelten Start-up-Idee. Der Fokus liegt bewusst auf den zentralen Funktionen:
- Erfassen von Träumen
- Visualisierung von Trauminhalten
- Träume speichern
- Abruf gespeicherter Träume

### Technologiestack

- **Backend:** Spring Boot
- **Frontend:** Angular
- **Webserver:** Nginx
- **Datenbank:** MariaDB

## Anleitung

Für das Deployment haben wir uns für eine direkte Bereitstellung auf einem Debian-Server entschieden. Der Grund: Der Server war bereits als funktionierender Webserver im Einsatz. Die dafür notwendigen Schritte sind im [Workflows](./.github/workflows/deploy_prod.yml) ersichtlich.