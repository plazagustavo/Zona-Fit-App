# Zona Fit App 🏋️‍♂️

Aplicación de escritorio desarrollada en **Java Swing** que utiliza **Spring Boot**, **MySQL** y operaciones **CRUD** para gestionar clientes de un gimnasio.

---

## 📌 Descripción del Proyecto

Zona Fit App es una migración de una aplicación previa de consola hacia una interfaz gráfica construida con **Swing**. El sistema permite gestionar clientes mediante operaciones CRUD conectadas a una base de datos MySQL.

* Visualización de clientes en una tabla (JTable).
* Conexión a MySQL usando Spring Boot + JPA/Hibernate.
* Estructura modular y mantenible.
* Lógica CRUD reutilizada desde la versión de consola.

Clase principal (Main):
`src/main/java/gm/ZonaFitSpring/ZonaFitSwing.java`

---

## 🚀 Tecnologías Utilizadas

* **Java 21**
* **Swing (UI)**
* **Spring Boot**
* **JPA**
* **MySQL**
* **Maven**



## ⚙️ Configuración de MySQL

Crear base de datos:

```sql
CREATE DATABASE zona_fit;
```

Configurar `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/zona_fit
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ ¿Cómo Ejecutar el Proyecto?

1. Clonar el repositorio:

```
git clone https://github.com/plazagustavo/Zona-Fit-App.git
```

2. Importarlo en tu IDE (NetBeans / IntelliJ / Eclipse).
3. Asegurar que MySQL esté ejecutándose.
4. Ejecutar el Main:

```
src/main/java/gm/ZonaFitSpring/ZonaFitSwing.java
```

Esto iniciará la interfaz gráfica.

---

## Funcionalidades principales

✔ Listar clientes en la tabla.

✔ Agregar nuevos clientes.

✔ Editar clientes existentes.

✔ Eliminar clientes.

---

## 📸 Capturas (opcional)

<img width="711" height="664" alt="image" src="https://github.com/user-attachments/assets/d853a50b-a024-4b7a-8359-ff5fb31def1a" />



