# CampusHub API Unit Testing Lab

Name: ____________________  
Student ID: ____________________

## Results

| Test ID | Expected result | Actual result | Pass / Fail |
|---|---|---|---|
| 01 | 200 OK; course 101 has code IS-401 | 200 OK; ID 101 and code IS-401 | Pass |
| 02 | 404 Not Found; empty body | 404 Not Found; body is empty | Pass |
| 03 | 201 Created; IS-404 with 3 credits | 201 Created; IS-404 with 3 credits | Pass |
| 04 | 400 Bad Request; credits must be positive | 400 Bad Request; message contains “positive” | Pass |
| 05 | 204 No Content; course 103 then returns 404 | 204 No Content; follow-up lookup returns 404 | Pass |

## Maven Test Summary

Command: `mvn -Dtest=CourseControllerTest test`

Tests run: 5, Failures: 0, Errors: 0, Skipped: 0  
Build: SUCCESS
