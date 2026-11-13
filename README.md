# Task Tracker API

A simple REST API built with Spring Boot and Java to manage tasks.
Tasks are stored in memory (no database yet).

## Endpoints

| Method | URL | What it does |
|---|---|---|
| GET | /tasks | Get all tasks |
| POST | /tasks | Add a task (body: `{"title": "..."}`) |
| PUT | /tasks/{id} | Update title and/or done status |
| DELETE | /tasks/{id} | Delete a task |

## How to run

1. Clone the repository
2. Open it in IntelliJ and run `TasktrackerApplication`
3. Open `http://localhost:8080/tasks`

## Tech

Java, Spring Boot, Maven

## Planned

Validation, service layer, database (JPA)
