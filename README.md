# Kids Immunization Reminder - Project

## Overview
This project is a **Kids Immunization Reminder** application that helps parents track and manage their child's vaccination schedule. It includes both the **frontend** and **backend** components.

---

## Project Structure
Arrange the files as below (Unzip the backend file):

Kids_Immunization_Reminder/
├── frontend/ # React frontend files
│ ├── public/ # Public assets (index.html, etc.)
│ ├── src/ # Source code (components, views, etc.)
│ ├── package.json # Frontend dependencies and scripts
│ ├── .gitignore # Git ignore file
│ └── README.md # Frontend specific instructions
├── backend_part.zip # Zip file containing backend code
└── README.md # Project overview and instructions


---

## Frontend
The `frontend/` folder contains the **React application**. It has all the necessary components, views, and logic for the user interface.

---

## Backend
The `backend_part.zip` file contains the **backend code** necessary for the application's functionality. Follow the steps below to set it up.

### Setting Up the Backend

1. **Unzip the backend file**  
   - Locate `backend_part.zip` inside the project directory.  
   - Unzip it into a new folder called `backend/`.

2. **Install Java and Maven** (if not installed)  
   - Check Java installation:  
     ```bash
     java -version
     ```  
   - Check Maven installation:  
     ```bash
     mvn -version
     ```  
   - Download if not installed:  
     - [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
     - [Maven](https://maven.apache.org/download.cgi)

3. **Build the backend project**  
   ```bash
   cd backend
   mvn clean install
