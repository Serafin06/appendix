# Appendix Project

This is a Java desktop application designed to assist in creating detailed invoice attachments ("appendices") for buildings. It manages records of work performed, associated materials, travel costs, and VAT rates, allowing for precise monthly settlement reports per building.

---

## Overview

The project allows users to:

- Enter building addresses.
- Record multiple works done on buildings, each with date, labor hours, VAT rates, travel costs.
- Manage materials used in each work, including quantity and unit prices.
- Generate monthly settlement reports as invoice attachments.
- Store data in a relational database (PostgreSQL).

---

## Technologies Used

- Java 11+
- Swing for desktop GUI
- Hibernate ORM for database interaction
- PostgreSQL database
- Maven for build and dependency management

---

## Project Structure

- `src/main/java` — main Java source code
- `src/main/resources` — Hibernate config and other resources
- Core classes manage entities such as Building, Work, Material, and their relationships.
- GUI forms implemented with Swing.
- Database schema mapped via Hibernate annotations.

---

## Current Status

This project was developed as a prototype in Java but will no longer be actively maintained or extended. The development focus has shifted to a new Kotlin-based version for improved maintainability and features.

---

## Getting Started

To build and run this project:

1. Ensure you have Java JDK 11 or newer installed.
2. Set up a PostgreSQL database and update connection settings in `hibernate.cfg.xml`.
3. Build the project using Maven:

mvn clean install

Run the main class (e.g. pl.marko.AppendixApp).

---

## Contribution
As the project is no longer actively developed in Java, new contributions will not be merged. For the Kotlin version, please refer to the respective repository.
---

## Author

Serafin06

---
## FAQ

Q: Is this project still actively maintained?

A: No, the project has been superseded by a Kotlin version and is no longer actively maintained.

Q: Where can I find the Kotlin version?

A: Please check your other repositories or contact the author for more info.

---

## Usage Instructions

Launch the application.

Input building address or select existing one.

Add work details including date, labor hours, VAT rate, and travel costs.

Add materials used for each work, specifying quantity and unit prices.

Save records and generate monthly reports.
