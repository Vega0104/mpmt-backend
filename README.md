# mpmt-backenda# MPMT Backend

Backend de la plateforme collaborative de gestion de projet (Spring Boot + PostgreSQL).

## 🚀 Fonctionnalités principales

- Gestion des utilisateurs, projets, membres et tâches
- Assignation multi-utilisateurs aux tâches
- Suivi des statuts, priorités, notifications et historiques de modifications

## 🛠️ Stack technique

- **Java 21**
- **Spring Boot 3.5.3**
- **PostgreSQL**
- **Spring Data JPA**
- **Maven**

## ⚡️ Prérequis

- Java 21 ou supérieur
- PostgreSQL installé et une base créée
- Maven

## 🚦 Démarrage rapide

1. **Clone le repo :**
    ```bash
    git clone https://github.com/tonpseudo/mpmt-backend.git
    cd mpmt-backend
    ```

2. **Configure la base de données dans** `src/main/resources/application.properties` :
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/nom_de_ta_db
    spring.datasource.username=postgres
    spring.datasource.password=tonmotdepasse
    ```

3. **Lance l’application :**
    ```bash
    ./mvnw spring-boot:run
    ```
    ou via IntelliJ avec le bouton vert "Run"

## 📁 Structure du projet

- `model/` — entités JPA (User, Project, Task, etc.)
- `repository/` — interfaces Spring Data
- `service/` — logique métier
- `controller/` — REST endpoints

## 🙋‍♂️ Auteur

- [Ton nom](https://www.linkedin.com/in/tonprofil) — contact pro

---

> **Ce projet fait partie de mon portfolio et sert de vitrine technique pour la gestion de projet logiciel full stack.**
