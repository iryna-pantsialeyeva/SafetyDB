import model.AdverseReaction;
import model.AnswerType;
import model.Criteria;
import model.Outcome;
import model.RelationshipType;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try (sessionFactory) {
            User user = new User("qat1@gmail.com", "12345", true);
            session.beginTransaction();
            session.save(user);
            AdverseReaction adverseReaction = new AdverseReaction("rash", "Ankermann",
                    Outcome.DEATH, Criteria.DEATH, user, RelationshipType.POSSIBLE,
                    AnswerType.YES, AnswerType.NO, AnswerType.YES, AnswerType.NA);
            session.save(adverseReaction);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
        }
    }
}
