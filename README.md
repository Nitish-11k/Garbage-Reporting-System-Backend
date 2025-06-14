# Smart-Garbage-Reporting-System-Backend

# **🗑️ Smart Garbage Reporting System**

A web application that allows users to report uncleaned garbage locations to municipal authorities by uploading images, descriptions, and location data. Designed to improve city cleanliness and public hygiene through faster issue reporting and resolution.

---

## 🚀 Features

- 📷 Upload garbage images
- 📝 Add title and description of the report
- 📍 Optionally store/report geolocation (e.g., city area)
- 🧾 Admin panel to view and manage reports
- 📦 File upload and storage
- 📊 Clean and user-friendly UI

---

## 🛠️ Tech Stack

| Layer      | Technology               |
|------------|--------------------------|
| Backend    | Java, Spring Boot        |
| Database   | MySQL / H2 (for dev)     |
| File Upload| Spring MultipartFile     |
| ORM        | Spring Data JPA          |
| Build Tool | Maven                    |

---

## 🧑‍💻 Installation & Setup

### Prerequisites

- Java 24
- Maven
- MySQL or H2 (embedded)
- Git

---
### 📁 Project Structure

```bash
smart-garbage-reporting/
├── src/
│ ├── main/
│ │ ├── java/com/example/garbage/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── service/
│ │ └── resources/
│ │ ├── application.properties
│ │ └── templates/
├── uploads/ (image storage)
├── pom.xml
└── README.md
```

---

**⚙️Configure Database**

- Edit src/main/resources/application.properties:

- For MySQL:
```bash
properties

spring.datasource.url=jdbc:mysql://localhost:3306/garbage_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
file.upload-dir=uploads/
```

## 📮 API Endpoints

| Method | Endpoint                            | Description                   |
|--------|-------------------------------------|-------------------------------|
| POST   | `/api/report/add`                       | Create a new report           |
| GET    | `/api/report`                       | List all reports              |
| GET    | `/api/report/{id}`                  | Get single report by ID       |
| PUT    | `/api/report/{id}/status?status=resolved` | Update report status     |

> 🧪 Use tools like **Postman** to test these endpoints.


---
### Clone the Repository

```bash
git clone https://github.com/yourusername/smart-garbage-reporting.git
cd smart-garbage-reporting
