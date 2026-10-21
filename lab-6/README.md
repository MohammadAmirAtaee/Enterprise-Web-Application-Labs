# CampusHub Courses React Client

Student name: Mohammad Amir Ataee

This React application displays and manages courses through the CampusHub Spring Boot REST API. The Courses page supports listing, editing, and deleting courses.

## Project folders

- Frontend: `compushub-ui`
- Backend: `campushub-api`

## Ports and API

- Backend API: `http://localhost:8080`
- Frontend: `http://localhost:5173`
- Courses endpoint: `http://localhost:8080/api/v1/courses`

The frontend uses these endpoints:

| Method | Endpoint | Purpose |
| --- | --- | --- |
| GET | `/api/v1/courses` | List courses |
| PUT | `/api/v1/courses/{id}` | Update a course |
| DELETE | `/api/v1/courses/{id}` | Delete a course |

The backend must expose the PUT and DELETE mappings above. The update request sends JSON fields `code` (string), `title` (string), and `credits` (number). Confirm that these match the backend DTO and validation rules.

## Start the backend

Open a terminal in `lab-6` and run:

```powershell
cd ".\campushub-api"
mvn.cmd spring-boot:run
```

## Start the frontend

Open a second terminal in `lab-6` and run:

```powershell
cd ".\compushub-ui"
npm.cmd install
npm.cmd run dev
```

Open `http://localhost:5173/courses` in the browser. The backend should be running first; otherwise, the page shows a connection error.

## Use course management

1. Open the Courses page and confirm the course list loads.
2. Select **Edit** to load a course into the form, change its fields, and select **Update**.
3. Select **Delete** and confirm the browser prompt to remove a course.

After a successful update or deletion, the page reloads the course list from the API. A course that is referenced by sections or registrations may be rejected by backend constraints.

## Troubleshooting

- **Connection error:** Confirm that Spring Boot is listening on port `8080`.
- **404 or 405 on update/delete:** Confirm the backend routes use PUT and DELETE at `/api/v1/courses/{id}`.
- **400 on update:** Check DTO field names, JSON types, and validation rules. `code` is sent as a string and `credits` as a number.
- **CORS error:** Allow the frontend origin `http://localhost:5173` and the PUT, DELETE, and OPTIONS methods in the backend CORS configuration.
