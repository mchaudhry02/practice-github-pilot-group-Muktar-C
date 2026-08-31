# ClassManager

A simple Spring Boot REST API for managing teachers and students, backed by MySQL.

## Before You Run It

1. Make sure MySQL is running locally. The connection URL includes `createDatabaseIfNotExist=true`, so the `classmanager` database will be created automatically the first time the app connects — no manual `CREATE DATABASE` needed.
2. Update `src/main/resources/application.properties` with your actual MySQL username/password if different from the defaults (`root` / `root`).

## Running the App

```bash
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`.

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | /teachers | List all teachers |
| GET | /teachers/{id} | Get a teacher by ID |
| POST | /teachers | Create a teacher |
| PUT | /teachers/{id} | Update a teacher |
| DELETE | /teachers/{id} | Delete a teacher |
| GET | /students | List all students |
| GET | /students/{id} | Get a student by ID |
| POST | /students | Create a student |
| PUT | /students/{id} | Update a student |
| DELETE | /students/{id} | Delete a student |

### Example: Create a Teacher

```bash
curl -X POST http://localhost:8080/teachers \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Ada","lastName":"Lovelace","email":"ada@example.com","subject":"Computer Science"}'
```

### Example: Create a Student

```bash
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Grace","lastName":"Hopper","email":"grace@example.com","gradeLevel":10}'
```

## Project Structure

```
src/main/java/com/launchcode/classmanager/
├── ClassmanagerApplication.java   # Main entry point
├── model/
│   ├── Teacher.java                # Teacher entity
│   └── Student.java                # Student entity (many-to-one with Teacher)
├── repository/
│   ├── TeacherRepository.java
│   └── StudentRepository.java
└── controller/
    ├── TeacherController.java      # REST endpoints for /teachers
    └── StudentController.java      # REST endpoints for /students
```

## Notes

- `Student` has an optional `teacher` field (many-to-one) so you can assign a student to a teacher, but it's nullable — you don't need to set it to create a student.
- No authentication is implemented, per the assignment instructions.
- Table creation is handled automatically via `spring.jpa.hibernate.ddl-auto=update`.