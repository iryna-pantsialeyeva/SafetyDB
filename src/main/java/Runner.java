import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Random;

public class Runner {
    private static SessionFactory factory = null;

    public static void main(String[] args) {

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 1; i < 4; i++) {
                User user = new User();
                user.setEmail("test" + i + "@test" + i + ".com");
                user.setPassword("test" + i);
                Random rand = new Random();
                user.setActive(rand.nextBoolean());

                int userId = (Integer) session.save(user);
                user.setId(userId);
                System.out.println("saving: " + user);

                for (int j = 1; j < 3; j++) {
                    AdverseReaction adr = new AdverseReaction();
                    adr.setReportDate(LocalDate.now());
                    adr.setDescription("description " + (j * 3));
                    adr.setSuspectedDrug("suspected drug " + j);
                    adr.setOutcome(Outcome.values()[rand.nextInt(Outcome.values().length)]);
                    adr.setCriteria(Criteria.values()[rand.nextInt(Criteria.values().length)]);
                    adr.setRelationshipByCompany(RelationshipType.values()[rand.nextInt(RelationshipType.values().length)]);
                    adr.setNameGivenByReporter(RelationshipType.values()[rand.nextInt(RelationshipType.values().length)]);
                    adr.setTimeRelationship(AnswerType.values()[rand.nextInt(AnswerType.values().length)]);
                    adr.setWithdrawalResult(AnswerType.values()[rand.nextInt(AnswerType.values().length)]);
                    adr.setReintroductionResult(AnswerType.values()[rand.nextInt(AnswerType.values().length)]);
                    adr.setOtherExplanation(AnswerType.values()[rand.nextInt(AnswerType.values().length)]);
                    adr.setUser(user);

                    session.save(adr);
                    System.out.println("saving: " + adr);
                }
            }
            transaction.commit();
            System.out.println("all users saved");
        }

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 3; i < 10; i += 3) {
                User user = session.get(User.class, i);
                System.out.println("found user: " + user);
            }
            transaction.commit();
        }
    }

    private static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            factory = configuration.buildSessionFactory();
        }
        return factory;
    }
}
