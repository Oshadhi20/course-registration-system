Course Registration System (CRS)

📌 Project Overview The Course Registration System (CRS) is a Java-based desktop application that allows students to register for courses, faculty to manage student grades, and administrators to oversee the enrollment process. It features authentication, role-based access control (RBAC), real-time updates, and reporting.

📋 System Requirements

In my sysytem meets the following requirements: Operating System: Windows Java Development Kit (JDK): Java 11 or higher Database: MySQL 8.0+ IDE: VS code

🚀 Setup Instructions
1️⃣ Install Java and MySQL Download and Install Java 11+: Oracle JDK Download and Install MySQL 8+: MySQL Community Edition

2️⃣ Clone the Repository git clone https://github.com/Oshadhi20/course-registration-system.git cd course-registration-system

3️⃣ Configure the Database Open MySQL and create a new database: CREATE DATABASE crs_new; Import the provided SQL schema: mysql -u root -p crs_new < database/crs_schema.sql

4️⃣ Configure Database Connection Edit DBConnection.java: private static final String URL = "jdbc:mysql://localhost:3306/crs_new"; private static final String USER = "root"; private static final String PASSWORD = "Oshadhi@20"

5️⃣ Compile and Run
Add mysql-connector-j-8.4.0.jar to the lib/ folder. Open .vscode/settings.json and add: { "java.project.referencedLibraries": [ "lib/mysql-connector-j-8.4.0.jar" ] } Run: javac -cp .;lib/mysql-connector-j-8.4.0.jar src/edu/ijse/crs/Main.java java -cp .;lib/mysql-connector-j-8.4.0.jar edu.ijse.crs.Main

📖 User Guide

🔹 Student Features

View Available Courses Register for Courses Drop Courses Check Academic Records

🔹 Faculty Features

View Assigned Courses Manage Student Grades

🔹 Admin Features

Manage Students and Courses View Enrollment Reports

📞 Support
For any issues, contact oshadhi23ravindya@gmail.com
