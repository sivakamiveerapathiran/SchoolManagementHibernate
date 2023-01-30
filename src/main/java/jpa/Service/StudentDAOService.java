/*
This class is a Service DAO class for the Student Entity
 */
package jpa.Service;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAOService {
    List<Student> getAllStudentsService();


    List<Student> getStudentByEmailService(String sEmail);
    Student  validateStudent(String sEmail,String Pass);
    boolean validateStudentCourseService(String sEmail,int cId);

    void registerStudentToCourseService(Student std, Course crs);

    List<Course>getStudentCoursesService(String mail);
}
