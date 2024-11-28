# JDBC Setup in Eclipse

This guide explains how to set up a JDBC project in Eclipse and connect it to a MySQL database.

---

## Prerequisites
1. **Java Development Kit (JDK):**
   - Ensure JDK is installed on your system and `JAVA_HOME` is configured.
   - [Download JDK](https://www.oracle.com/java/technologies/javase-jdk-downloads.html)

2. **MySQL Database:**
   - Install MySQL Server and MySQL Workbench.
   - [Download MySQL](https://dev.mysql.com/downloads/)

3. **Eclipse IDE:**
   - Install Eclipse IDE for Java Developers.
   - [Download Eclipse](https://www.eclipse.org/downloads/)

4. **MySQL Connector/J (JDBC Driver):**
   - Download the MySQL JDBC driver (`mysql-connector-java-x.x.x.jar`).
   - [Download MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

---

## Steps to Set Up JDBC in Eclipse

### 1. Create a New Java Project
1. Open Eclipse and go to **File > New > Java Project**.
2. Enter a project name (e.g., `JDBCExample`) and click **Finish**.

---

### 2. Add JDBC Driver to the Project
1. Right-click the project in the **Package Explorer**.
2. Select **Build Path > Configure Build Path**.
3. Go to the **Libraries** tab and click **Add External JARs...**.
4. Locate the downloaded `mysql-connector-java-x.x.x.jar` file and add it.
5. Click **Apply and Close**.

---

### 3. Create a Database in MySQL
1. Open MySQL Workbench and connect to your server.
2. Create a new database using the following SQL query:
   ```sql
   CREATE DATABASE ExampleDB;
