/*
This class is a Service DAO Implementation class for the Course Entity
 */

package jpa.Service;

import jpa.dao.CourseDAO;
import jpa.dao.CourseDAOImpl;
import jpa.entitymodels.Course;

import java.util.List;

public class CourseDAOServiceImpl implements CourseDAOService {

    @Override
    public List<Course> getAllCoursesService() {
        CourseDAO courseDAO=new CourseDAOImpl();
     return courseDAO.getAllCourses();



    }

    @Override
    public Course getCourseByIdService(int id) {
        CourseDAOImpl courseDAO=new CourseDAOImpl();
      return  courseDAO.getCourseById(id);
    }
}
