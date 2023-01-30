/*
This class is a DAO Implementation class for the Student Entity
 */

package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAllStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Student");
        List<Student> stu = query.getResultList();
        for (Student s : stu) {
            System.out.println(s.getsEmail());
        }
        factory.close();
        session.close();
        return stu;

    }

    @Override
    public List<Student> getStudentByEmail(String x) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM Student  where sEmail =:y";
        TypedQuery query = session.createQuery(hql, Student.class);
        query.setParameter("y", x);
        List<Student> student = query.getResultList();

        factory.close();
        session.close();
        return student;
    }

    @Override
    public Student validateStudent(String sEmail, String sPass) {
        Student Studentreturnvalue=null;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
         String hql="FROM Student where sEmail=:y and sPass=:z";
        TypedQuery query = session.createQuery(hql, Student.class);
        query.setParameter("y", sEmail);
        query.setParameter("z", sPass);
        List<Student> student = query.getResultList();

        if(!student.isEmpty()) {
         Studentreturnvalue=student.get(0);
        }
        factory.close();
        session.close();
        return Studentreturnvalue;
    }


    public boolean validateStudentCourse(String sEmail, int cId) {
        boolean ismatchexist = false;
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createSQLQuery("SELECT id,Instructor,name FROM course c,student_course sc where c.id=sc.sCourses_id and sc.Student_email=?1 and c.id=?2");
        query.setParameter(1, sEmail);
        query.setParameter(2, cId);

        List<Object[]> rows = query.getResultList();
        if(!rows.isEmpty()){
            ismatchexist=true;
        }

        return ismatchexist;
    }

    @Override
    public void registerStudentToCourse(Student std, Course crs) {
     List<Course> crslist=new ArrayList<>();
     List<Student> studlist=new ArrayList<>();
     studlist.add(std);
        crs.setStudent(studlist);
        List<Course> stdcrs= this.getStudentCourses(std.getsEmail());
        for(Course currcrs:stdcrs ){
            currcrs.setStudent(studlist);
            crslist.add(currcrs);
        }
        crslist.add(crs);
        std.setsCourses(crslist);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.merge(std);
        t.commit();
        factory.close();
        session.close();
    }

    @Override
    public List<Course> getStudentCourses(String mail ) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Query query = session.createSQLQuery("SELECT id,Instructor,name FROM course c,student_course sc where c.id=sc.sCourses_id and sc.Student_email=?1");
        query.setParameter(1,mail);
        List<Course> Courses = new ArrayList<>();

        List<Object[]> rows = query.getResultList();
        for(Object[] row : rows){
            Course crs = new Course();

            crs.setCld(Integer.parseInt(row[0].toString()));
            crs.setcName(row[1].toString());
            crs.setcInstructorName(row[2].toString());
            Courses.add(crs);
        }

        factory.close();
        session.close();

        return Courses;
    }

}
