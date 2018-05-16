package db;

import models.Course;
import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBLesson {

    private static Session session;

    public static List<Student> getStudentsInLesson(Lesson lesson){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Student> results  = null;

        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.createAlias("lessons", "individual_lesson");
            criteria.add(Restrictions.eq("individual_lesson.id", lesson.getId()));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
