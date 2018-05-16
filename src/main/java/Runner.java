import db.DBCourse;
import db.DBHelper;
import db.DBLesson;
import models.Course;
import models.CourseLevel;
import models.Lesson;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Title 1", CourseLevel.BEng);
        Course course2 = new Course("Title 2", CourseLevel.BSc);
        Course course3 = new Course("Title 3", CourseLevel.MA);

        DBHelper.save(course1);
        DBHelper.save(course2);
        DBHelper.save(course3);

        Student student1 = new Student("Name 1", 25, 100, course1);
        Student student2 = new Student("Name 2", 20, 101, course2);
        Student student3 = new Student("Name 3", 30, 102, course3);
        Student student4 = new Student("Name 4", 38, 103, course3);

        DBHelper.save(student1);
        DBHelper.save(student2);
        DBHelper.save(student3);
        DBHelper.save(student4);

        Lesson lesson1 = new Lesson("Lesson 1", 200, course1);
        Lesson lesson2 = new Lesson("Lesson 2", 200, course1);
        Lesson lesson3 = new Lesson("Lesson 3", 200, course2);

        DBHelper.save(lesson1);
        DBHelper.save(lesson2);
        DBHelper.save(lesson3);

        DBHelper.addStudentToLesson(student1, lesson1);
        DBHelper.addStudentToLesson(student2, lesson1);
        DBHelper.addStudentToLesson(student3, lesson2);
        DBHelper.addStudentToLesson(student3, lesson1);

        List<Student> allStudents = DBHelper.getAll(Student.class);
        List<Course> allCourses = DBHelper.getAll(Course.class);
        List<Lesson> allLessons = DBHelper.getAll(Lesson.class);

        List<Student> studentsOnCourse3 = DBCourse.getStudentsOnCourse(course3);
        List<Lesson> lessonsForCourse1 = DBCourse.getLessonsForCourse(course1);
        List<Student> studentsInLesson1 = DBLesson.getStudentsInLesson(lesson1);

    }
}
