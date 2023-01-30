/*
This class is a Service DAO class for the Course Entity
 */

package jpa.Service;

import jpa.entitymodels.Course;

import java.util.List;


public interface CourseDAOService {
    List<Course> getAllCoursesService();
    Course getCourseByIdService(int id);
}
