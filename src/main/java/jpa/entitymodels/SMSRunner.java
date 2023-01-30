/*
This class is an starting class for the School Management System
 */
package jpa.entitymodels;

import jpa.Service.CourseDAOService;
import jpa.Service.CourseDAOServiceImpl;
import jpa.Service.StudentDAOService;
import jpa.Service.StudentDAOServiceImpl;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class SMSRunner {


        private Scanner sin;
        private StringBuilder sb;

        private CourseDAOService courseService;
        private StudentDAOService studentService;
        private Student currentStudent;

        public SMSRunner() {
            sin = new Scanner(System.in);
            sb = new StringBuilder();
            courseService = new CourseDAOServiceImpl();
            studentService = new StudentDAOServiceImpl();
        }

        /**
         * @param args
         */
        public static void main(String[] args) {

            SMSRunner sms = new SMSRunner();
            sms.run();
            out.println("You have been signed out.");
        }

        private void run() {
            // Login or quit
            switch (menu1()) {
                case 1:
                    if (studentLogin()) {
                        registerMenu();
                    }
                    break;
                case 2:
                    out.println("Goodbye!");
                    break;

               default:
                    out.println("Not a valid Selection. Exiting Application!");

            }
        }

        private int menu1() {
            sb.append("\n1.Student Login\n2. Quit Application\nPlease Enter Selection: ");
            out.print(sb.toString());
            sb.delete(0, sb.length());

            return sin.nextInt();
        }

        private boolean studentLogin() {
            boolean retValue = false;
            out.print("Enter your email address: ");
            String email = sin.next();
            out.print("Enter your password: ");
            String password = sin.next();
           Student value=studentService.validateStudent(email,password);
                if(value!=null){
                    currentStudent=value;
                List<Course> courses = studentService.getStudentCoursesService(email);
                if(courses!=null) {
                    out.println("MyClasses");
                    out.printf("%5s%15S%15s\n", "ID", "Course", "                   Instructor");
                    for (Course course : courses) {
                        out.println("    "+course.getCld()+"       "+course.getcName()+"       "+course.getcInstructorName());
                    }
                }
                retValue = true;
            } else {
                out.println("User Validation failed. GoodBye!");
            }
            return retValue;
        }

        private void registerMenu() {
            sb.append("\n1.Register a class\n2. Logout\nPlease Enter Selection: ");
            out.print(sb.toString());
            sb.delete(0, sb.length());

            switch (sin.nextInt()) {
                case 1:

                    List<Course> allCourses = courseService.getAllCoursesService();

                    out.printf("%5s%15S%15s\n", "ID", "Course", "                   Instructor");
                    for (Course course : allCourses) {
                        out.println("    "+course.getCld()+"       "+course.getcName()+"       "+course.getcInstructorName());
                    }

                    out.println();
                    out.print("Enter Course Number: ");
                    int number = sin.nextInt();
                    Course newCourse = courseService.getCourseByIdService(number);

                    if (newCourse != null) {

                       boolean check= studentService.validateStudentCourseService(currentStudent.getsEmail(),newCourse.getCld());
                       if(check==true) {
                           System.out.println("Student Already Registered");
                       }
                       else {
                         studentService.registerStudentToCourseService(currentStudent, newCourse);
                       }
                        Student temp = studentService.getStudentByEmailService(currentStudent.getsEmail()).get(0);

                        List<Course> sCourses = studentService.getStudentCoursesService(currentStudent.getsEmail());
                        if (!sCourses.isEmpty()) {
                            out.println("MyClasses");
                            out.printf("%5s%15S%15s\n", "ID", "Course", "            Instructor");
                            for (Course course : sCourses) {
                                out.println("    "+course.getCld()+"       "+course.getcName()+"       "+course.getcInstructorName());
                            }
                        }
                    }
                    break;
                case 2:
                    out.println("Goodbye!");
                default:
                    out.println("Not a valid Selection. Exiting Application!");
            }
        }
    }


