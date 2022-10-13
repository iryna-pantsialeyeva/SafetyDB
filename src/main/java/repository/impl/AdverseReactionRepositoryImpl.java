package repository.impl;

import model.*;
import model.RelationshipType;
import repository.*;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class AdverseReactionRepositoryImpl implements AdverseReactionRepository {

    private final OutcomeRepository outcomeRepository;
    private final CriteriaRepository criteriaRepository;
    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;
    private final ReporterRepository reporterRepository;
    private final CompanyAssessmentRepository companyAssessmentRepository;
    private final RelationshipTypeRepository relationshipTypeRepository;
    private final DataSourceUtil pool;

    public AdverseReactionRepositoryImpl() {
        outcomeRepository = new OutcomeRepositoryImpl();
        criteriaRepository = new CriteriaRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        relationshipRepository = new RelationshipRepositoryImpl();
        reporterRepository = new ReporterRepositoryImpl();
        companyAssessmentRepository = new CompanyAssessmentRepositoryImpl();
        relationshipTypeRepository = new RelationshipTypeRepositoryImpl();
        pool = DataSourceUtil.create();
    }

    @Override
    public List<AdverseReaction> getAll() throws RepositoryException {
        List<AdverseReaction> adverseReactions = new ArrayList<>();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_ADVERSE_REACTIONS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AdverseReaction newADReaction = new AdverseReaction();
                newADReaction.setId(rs.getInt("id"));
                newADReaction.setReportDate(rs.getDate("report_date").toLocalDate());
                newADReaction.setDescription(rs.getString("description"));
                newADReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newADReaction.setCriteria(Criteria.getCriteriaByLabel(rs.getString("criteria_name")));
                newADReaction.setOutcome(Outcome.getOutcomeByLabel(rs.getString("outcome_name")));
                User user = new User();
                user.setId(rs.getInt("user_id"));
                newADReaction.setUser(user);
                Reporter reporter = new Reporter();
                reporter.setId(rs.getInt("reporter_id"));
                newADReaction.setReporter(reporter);
                Relationship relationship = new Relationship();
                relationship.setId(rs.getInt("causal_relationship_reporter_id"));
                newADReaction.setRelationship(relationship);
                newADReaction.setRelationshipByCompany(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_company")));
                adverseReactions.add(newADReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RepositoryException("Trouble in the database while reading.", e);
        } finally {
            pool.releaseConnection(con);
        }
        return adverseReactions;
    }

    @Override
    public void save(AdverseReaction advReact) throws RepositoryException {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS)) {

            ps.setDate(1, Date.valueOf(advReact.getReportDate()));
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setString(4, advReact.getOutcome().name());
            ps.setString(5, advReact.getCriteria().name());
            ps.setInt(6, advReact.getUser().getId());
            ps.setInt(7, advReact.getReporter().getId());
            ps.setInt(8, advReact.getRelationship().getId());
            ps.setString(9, advReact.getRelationshipByCompany().name());
            ps.executeUpdate();
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RepositoryException("Trouble in the database while saving.", e);
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void update(AdverseReaction advReact) throws RepositoryException {
//        int updatedRows = 0;
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_ADVERSE_REACTIONS)) {

            ps.setDate(1, Date.valueOf(advReact.getReportDate()));
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setString(4, advReact.getOutcome().name());
            ps.setString(5, advReact.getCriteria().name());
            ps.setInt(6, advReact.getUser().getId());
            ps.setInt(7, advReact.getReporter().getId());
            ps.setInt(8, advReact.getRelationship().getId());
            ps.setString(9, advReact.getRelationshipByCompany().name());
            ps.setInt(10, advReact.getId());
            ps.executeUpdate();
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RepositoryException("Trouble in the database while updating.", e);
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void delete(int id) throws RepositoryException {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_ADVERSE_REACTIONS_BY_ID)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RepositoryException("Trouble in the database while deleting.", e);
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public AdverseReaction getById(int id) {
        AdverseReaction newADReaction = new AdverseReaction();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_ID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    newADReaction.setId(rs.getInt("id"));
                    newADReaction.setReportDate(rs.getDate("report_date").toLocalDate());
                    newADReaction.setDescription(rs.getString("description"));
                    newADReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                    newADReaction.setCriteria(Criteria.getCriteriaByLabel(rs.getString("criteria_name")));
                    newADReaction.setOutcome(Outcome.getOutcomeByLabel(rs.getString("outcome_name")));
                    User user = new User();
                    user.setId(rs.getInt("user_id"));
                    newADReaction.setUser(user);
                    Reporter reporter = new Reporter();
                    reporter.setId(rs.getInt("reporter_id"));
                    newADReaction.setReporter(reporter);
                    Relationship relationship = new Relationship();
                    relationship.setId(rs.getInt("causal_relationship_reporter_id"));
                    newADReaction.setRelationship(relationship);
                    newADReaction.setRelationshipByCompany(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_company")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return newADReaction;
    }

    @Override
    public int getId(AdverseReaction advReaction) {
//        //Проверка дубликатов по 4 параметрам: description, suspected drug, date, reporter id
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_ID_BY_PARAMETERS);
//             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
//             ResultSet rs = ps2.executeQuery();
//             PreparedStatement ps3 = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
//             ResultSet rs2 = ps3.executeQuery();
//             PreparedStatement ps4 = con.prepareStatement(SQLQuery.GET_USER_ID_BY_NAME);
//             ResultSet rs3 = ps4.executeQuery(); ResultSet rs4 = ps.executeQuery();) {
//
//            ps.setDate(1, (Date) advReact.getReportDate());
//            ps.setString(2, advReact.getDescription());
//            ps.setString(3, advReact.getSuspectedDrug());
//
//            ps2.setString(1, advReact.getCriteria().getName());
//            if (rs.next()) {
//                ps.setInt(4, rs.getInt(1));
//            }
//
//            ps3.setString(1, advReact.getOutcome().getName());
//            if (rs2.next()) {
//                ps.setInt(5, rs2.getInt(1));
//            }
//
//            ps4.setString(1, advReact.getUser().getEmail());
//            if (rs3.next()) {
//                ps.setInt(6, rs3.getInt(1));
//            }
//
//            //Я не могу доставать Relationship and CompanyAssessment id по name, т. к. они не уникальны для каждого ADR
//            //Их можно получить только по id ADR, т.е. их нужно сразу при создании добавлять в ADR с id.
//            ps.setInt(7, advReact.getRelationship().getId());
//            ps.setInt(8, advReact.getCompanyAssessment().getId());
//
//            if (rs4.next()) {
//                id = rs4.getInt("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }

    @Override
    public List<AdverseReaction> get(String suspectedDrug) {
        List<AdverseReaction> advReactions = new ArrayList();
//        AdverseReaction newAdvReaction = new AdverseReaction();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_SUSPECTED_DRUG);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, suspectedDrug);
//            while (rs.next()) {
//                newAdvReaction.setId(rs.getInt("id"));
//                newAdvReaction.setReportDate(rs.getDate("report_date"));
//                newAdvReaction.setDescription(rs.getString("description"));
//                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
//                newAdvReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
//                newAdvReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
//                newAdvReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
//                newAdvReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
//                advReactions.add(newAdvReaction);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return advReactions;
    }

    @Override
    public List<AdverseReaction> getByFullName(String fullName) {
        List<AdverseReaction> advReactions = new ArrayList();
//        AdverseReaction newAdvReaction = new AdverseReaction();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
//             ResultSet rs = ps.executeQuery();
//             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_REPORTER);
//             ResultSet rs2 = ps2.executeQuery()) {
//
//            ps.setString(1, fullName);
//            ps2.setInt(1, rs.getInt("id"));
//            while (rs2.next()) {
//                newAdvReaction.setId(rs2.getInt("id"));
//                newAdvReaction.setReportDate(rs2.getDate("report_date"));
//                newAdvReaction.setDescription(rs2.getString("description"));
//                newAdvReaction.setSuspectedDrug(rs2.getString("suspected_drug"));
//                newAdvReaction.setOutcome(outcomeRepository.getByID(rs2.getInt("outcome_id")));
//                newAdvReaction.setCriteria(criteriaRepository.getByID(rs2.getInt("criteria_id")));
//                newAdvReaction.setFullName(reporterRepository.getByID(rs2.getInt("reporter_id")));
//                newAdvReaction.setType(reporterTypeRepository.getByID(rs2.getInt("reporter_type_id")));
//                advReactions.add(newAdvReaction);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return advReactions;
    }

    @Override
    public AdverseReaction getByName(String title) {
        AdverseReaction newAdvReaction = new AdverseReaction();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_TITLE);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, title);
//            if (rs.next()) {
//                newAdvReaction.setId(rs.getInt("id"));
//                newAdvReaction.setReportDate(rs.getDate("report_date"));
//                newAdvReaction.setDescription(rs.getString("description"));
//                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
//                newAdvReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
//                newAdvReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
//                newAdvReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
//                newAdvReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newAdvReaction;
    }
}

