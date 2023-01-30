/*
This class is a DAO Implementation class for the Student Entity
 */

package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents();
    List<Student> getStudentByEmail(String sEmail);
    Student  validateStudent(String sEmail,String Pass);
    void registerStudentToCourse(Student std, Course crs);
    List<Course>getStudentCourses(String mail);
}
