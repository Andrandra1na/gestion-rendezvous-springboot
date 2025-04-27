🏥 Projet Spring Boot - Gestion de Médecins et Rendez-vous

    📚 Contexte

Ce projet est basé sur un TP de **Technologies Web Avancées** de l'ESMIA.  
L'objectif est de construire une **application Java EE** moderne en utilisant **Spring Boot** avec une architecture professionnelle (Web, EJB, JPA, JDBC, Web Services).

---

    🛠 Objectifs principaux

- **Créer une base de données `base_medecin`** sous MySQL.
- **Développer une application complète** en couches avec :
  - **JDBC** : Connexion optimisée via pool de connexions.
  - **JPA** : Mapping relationnel-objet (ORM) des tables SQL.
  - **DAO** : Accès aux données avec CRUD complet via des EJBs.
  - **Web Services** : Exposition de certains services via SOAP.
  - **Client Web** : Interface utilisateur via Spring MVC + Thymeleaf.

---

    🏗 Architecture

- **Base de données** : MySQL
- **Backend** : Spring Boot
- **ORM** : Spring Data JPA (Hibernate)
- **Web Services** : SOAP (avec Spring-WS)
- **Sécurité** : Spring Security
- **Front-end** : Thymeleaf + CSS

---

    ⚙️ Fonctionnement

| Couches         | Description |
|-----------------|-------------|
| **JDBC**        | Gère la connexion rapide à la base via un pool de connexions. |
| **JPA (Hibernate)** | Mappe les tables de la base en entités Java manipulables. |
| **DAO (EJB)**   | Fournit les méthodes `Create`, `Read`, `Update`, `Delete`. |
| **Web Services** | Permet l'interopérabilité via messages XML en SOAP. |
| **Client Web**  | Interface Web accessible pour manipuler les données. |

---

    🧱 Entités principales

- **Patient** : informations d'un patient.
- **Médecin** : informations d'un médecin.
- **Creneaux** : créneaux horaires disponibles.
- **Rendez-vous (Rv)** : rendez-vous médicaux.
- **Utilisateur (User)** : gestion des comptes utilisateurs.

---

    🗄 Base de données

- Base : `base_medecin`
- Tables principales : `Patient`, `Medecin`, `Creneaux`, `Rv`, `User`
- Relations bien modélisées via JPA (`@OneToMany`, `@ManyToOne`, etc.)

---

    🚀 Lancer l'application

1. Cloner le projet :
   ```bash
   git clone https://github.com/votre-pseudo/Backend_Exam_SpringBoot.git
   cd Backend_Exam_SpringBoot
   ```

2. Configurer `src/main/resources/application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/base_medecin
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Démarrer l'application :
   ```bash
   ./mvnw spring-boot:run
   ```

4. Accéder :
   ```
   http://localhost:8007/
   ```

---

    🧪 Lancer les tests

```bash
./mvnw test
```

---

    🛡 Sécurité

- Authentification des utilisateurs via Spring Security.
- Protection des pages sensibles.
- Gestion des rôles.

---

    🔗 Technologies utilisées

- Java 17
- Spring Boot 
- Spring Data JPA
- Spring Security
- Spring Web Services (SOAP)
- Thymeleaf
- MySQL

---

    📜 Remarques

- Utilisation de Maven Wrapper (`./mvnw`) pour exécuter sans Maven installé.
- Projet structuré en couches MVC + DAO.
- Service SOAP déployé sous `/services/*`.

