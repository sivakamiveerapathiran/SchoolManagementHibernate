/*
This class is a Junit Test class for the School Management System
 */
package SMSTest;

import jpa.Service.StudentDAOService;
import jpa.Service.StudentDAOServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmsServiceTest {
    StudentDAOService ss = new StudentDAOServiceImpl();
    @Test
    void validateStudentCourseServiceTest1() {

        boolean value = ss.validateStudentCourseService("cjaulme9@bing.com", 3);
        Assertions.assertEquals(true, value);
    }
    @Test
    void validateStudentCourseServiceTest2(){
       boolean value = ss.validateStudentCourseService("cjaulme9@bing.com", 1);
        Assertions.assertEquals(false, value);

    }
}
