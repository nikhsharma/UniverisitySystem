package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBStudent {

    private static Session session;

    public static List<Lesson> getLessonsFromStudent(Student student){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Lesson> results  = null;

        try {
            Criteria criteria = session.createCriteria(Lesson.class);
            criteria.createAlias("students", "individual_student");
            criteria.add(Restrictions.eq("individual_student.id", student.getId()));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }
}
