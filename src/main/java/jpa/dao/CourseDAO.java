/*
This class is a DAO class for the Course Entity
 */


package jpa.dao;

import jpa.entitymodels.Course;

import java.util.List;

public interface CourseDAO {
    List<Course> getAllCourses();
}
