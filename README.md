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

### Clone the Repository

```bash
git clone https://github.com/yourusername/smart-garbage-reporting.git
cd smart-garbage-reporting
