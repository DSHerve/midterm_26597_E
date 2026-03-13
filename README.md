# City Public Transport Management System (CPTMS) 🚌
**Midterm Exam Repository - Web Technologies**
**Student ID:** 26597

## 📌 Project Overview
This project is an enterprise-grade backend system designed to manage public transportation across different geographical regions. It maps physical transport infrastructure (Buses, Routes, Schedules) to regional demographics (Provinces, Locations, Stations, Users) utilizing a fully normalized PostgreSQL database.

##  Technical Stack
* **Framework:** Spring Boot (Java)
* **Database:** PostgreSQL
* **ORM:** Hibernate / Spring Data JPA
* **Architecture:** 10-Table Relational Entity-Relationship Model

##  Key Features & Exam Requirements Fulfilled

### 1. Complex ERD Implementation (10 Tables)
The system utilizes 10 interconnected tables bridging Geography and Transport Infrastructure via a Ticket transaction.
* **One-to-Many:** `Station` -> `User`
* **One-to-One:** `User` -> `Wallet`
* **Many-to-Many:** `Bus` <-> `Route
![ERD](<Screenshots/Drawing1.jpg>)

### 2. Hierarchical Geographical Saving
Safely links districts to larger provinces to maintain referential data integrity.
![Create Location Screenshot](<Screenshots/Crating location.png>)

### 3. Pagination and Sorting
Optimized database fetching for large datasets.
![Pagination Screenshot](<Screenshots/Sorting and pagination.png>)

### 4. Data Validation (`existsBy`)
Prevents duplicate passenger registrations using derived queries.
![Duplicate Email Validation Screenshot](<Screenshots/Creating a user with same email failed.png>)

### 5. Multi-Table Cross-Referencing (Custom JPQL)
Utilizes a custom `@Query` to fetch passengers based on top-level provincial data by performing consecutive `LEFT JOIN` operations across 4 tables.
![Search by Province Screenshot](<Screenshots/Getting user in a Location search.png>)

### 6. Full Transactional Flow (Ticketing Bridge)
The system successfully bridges the Passenger Identity (Geography) with the Physical Transport (Infrastructure) using dynamic ID mapping via the Ticket entity.
* **Infrastructure Setup:** Created routes and scheduled buses (Many-to-Many resolution).
![Route and Bus Creation](<Screenshots/Assigning bus to route.png>)
* **Wallet Funding:** Enforced strict One-to-One financial mapping.
![Wallet Creation](<Screenshots/Wallet creation.png>)
* **Ticket Booking:** Completed the transaction by linking `user_id` and `schedule_id`.
![Ticket Booking](<Screenshots/Ticket creation.png>)

## 🗄️ Database Schema
The database connects two main branches:
1.  `Province` -> `Location` -> `Station` -> `User` -> `Wallet`/`SmartCard`
2.  `Bus` & `Route` -> `Schedule`
*The two branches merge at the `Ticket` entity.*
