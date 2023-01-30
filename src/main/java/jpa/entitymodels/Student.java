/*
This class is an Entity class for the Student DB table
 */

package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @Column(name = "email")
    private String sEmail;
    @Column(name = "name")
    private String sName;
    @Column(name = "password")
    private String sPass;

    @ManyToMany
    private List<Course> sCourses;

    public Student() {
    }

    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;

        this.sCourses = sCourses;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }

    @Override
    public String toString() {
        return "EMAIL= " + sEmail + ", Name= " + sName + ", Password= " + sPass;
    }

    @Override
    public boolean equals(Object s) {
            if (this == s) return true;
            if (s == null || getClass() != s.getClass()) return false;
            Student student = (Student) s;
            return getsEmail() == student.getsEmail() && getsPass() == student.getsPass() && getsName()==student.getsName()&& Objects.equals(getsEmail(), student.getsEmail()) && Objects.equals(getsName(), student.getsName()) && Objects.equals(getsPass(), student.getsPass());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getsEmail(), getsName(), getsPass());
        }

    }

