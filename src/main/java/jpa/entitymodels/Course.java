/*
This class is an Entity class for the Course DB table
 */

package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Course")
public class Course {
    @Id
    @Column(name = "id")
    int cld;
    @Column(name = "name")
    String cName;
    @Column(name = "Instructor")
    String cInstructorName;
    @ManyToMany
    private List<Student> student;

    public Course() {

    }

    public Course(int cld, String cName, String cInstructorName) {
        this.cld = cld;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getCld() {
        return cld;
    }

    public void setCld(int cld) {
        this.cld = cld;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

 @Override
    public String toString() {
        return "CourseId= " + cld + ", Name= " + cName + ", Password= " + cInstructorName;
    }

    @Override
     public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Course course = (Course) o;
            return getCld() == course.getCld() && getcName() == course.getcName() && getcInstructorName()==course.getcInstructorName()&& Objects.equals(getCld(), course.getCld()) && Objects.equals(getcName(), course.getcName()) && Objects.equals(getcInstructorName(), course.getcInstructorName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCld(), getcName(), getcInstructorName());
        }
    }



