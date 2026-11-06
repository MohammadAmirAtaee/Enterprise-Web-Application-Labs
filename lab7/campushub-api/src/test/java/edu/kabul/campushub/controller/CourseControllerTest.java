package edu.kabul.campushub.controller;

import edu.kabul.campushub.model.Course;
import edu.kabul.campushub.model.CourseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CourseControllerTest {

    private CourseController controller;

    @BeforeEach
    void setUp() {
        controller = new CourseController();
    }

    @Test
    void findsExistingCourse() {
        ResponseEntity<Course> response = controller.getCourseById(101L);

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals(101L, response.getBody().id());
        assertEquals("IS-401", response.getBody().code());
    }

    @Test
    void returnsNotFoundForMissingCourse() {
        ResponseEntity<Course> response = controller.getCourseById(9999L);

        assertEquals(404, response.getStatusCode().value());
        assertNull(response.getBody());
    }

    @Test
    void createsValidCourse() {
        CourseInput input = new CourseInput("IS-404", "Software Testing", 3);

        ResponseEntity<?> response = controller.createCourse(input);

        assertEquals(201, response.getStatusCode().value());
        assertInstanceOf(Course.class, response.getBody());
        Course course = (Course) response.getBody();
        assertEquals("IS-404", course.code());
        assertEquals(3, course.credits());
    }

    @Test
    void rejectsZeroCredits() {
        CourseInput input = new CourseInput("IS-404", "Software Testing", 0);

        ResponseEntity<?> response = controller.createCourse(input);

        assertEquals(400, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().toString().toLowerCase().contains("positive"));
    }

    @Test
    void deletesExistingCourse() {
        ResponseEntity<Void> deleteResponse = controller.deleteCourse(103L);

        assertEquals(204, deleteResponse.getStatusCode().value());
        ResponseEntity<Course> lookupResponse = controller.getCourseById(103L);
        assertEquals(404, lookupResponse.getStatusCode().value());
    }
}
