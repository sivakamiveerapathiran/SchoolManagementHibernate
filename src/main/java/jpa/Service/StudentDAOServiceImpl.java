/*
This class is a Service DAO Implementation class for the Student Entity
 */
package jpa.Service;

import jpa.dao.StudentDAO;
import jpa.dao.StudentDAOImpl;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public class StudentDAOServiceImpl implements StudentDAOService {
    @Override
    public List<Student> getAllStudentsService() {
        StudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO.getAllStudents();
    }

    @Override
    public List<Student> getStudentByEmailService(String sEmail) {
        StudentDAO studentDAO = new StudentDAOImpl();
      return   studentDAO.getStudentByEmail(sEmail);

    }
    @Override
    public Student  validateStudent(String sEmail,String sPass){
        StudentDAO studentDAO = new StudentDAOImpl();
        return studentDAO.validateStudent(sEmail,sPass);
    }

    @Override
    public boolean validateStudentCourseService(String sEmail,int cId) {
        StudentDAOImpl studentDAO = new StudentDAOImpl();
       return studentDAO.validateStudentCourse(sEmail,cId);
    }

    @Override
    public void registerStudentToCourseService(Student std, Course crs) {
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.registerStudentToCourse(std,crs);
    }

    @Override
    public List<Course> getStudentCoursesService(String mail) {
        StudentDAO studentDAO = new StudentDAOImpl();
      return  studentDAO.getStudentCourses(mail);

    }

}


