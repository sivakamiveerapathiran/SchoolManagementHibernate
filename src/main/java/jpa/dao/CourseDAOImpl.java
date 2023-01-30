/*
This class is a DAO Implementation class for the Course Entity
 */
package jpa.dao;

import jpa.entitymodels.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class CourseDAOImpl implements CourseDAO{
    @Override
    public List<Course> getAllCourses() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query=session.createQuery("from Course");
        List<Course> courses = query.getResultList();
        factory.close();
        session.close();
        return courses;

    }

    public Course getCourseById(int x){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Course crs=null;
        String hql = "from Course where id=:y";
         TypedQuery query = session.createQuery(hql, Course.class);
        query.setParameter("y",x);
        List<Course> courses = query.getResultList();
        if (courses != null) {
            crs = courses.get(0);
        }

        factory.close();
        session.close();
        return crs;
    }
}
