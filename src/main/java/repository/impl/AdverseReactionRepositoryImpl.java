package repository.impl;

import model.*;
import model.enums.RelationshipType;
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

    public AdverseReactionRepositoryImpl() {
        outcomeRepository = new OutcomeRepositoryImpl();
        criteriaRepository = new CriteriaRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        relationshipRepository = new RelationshipRepositoryImpl();
        reporterRepository = new ReporterRepositoryImpl();
        companyAssessmentRepository = new CompanyAssessmentRepositoryImpl();
    }

    @Override
    public List<AdverseReaction> getAll() {
        List<AdverseReaction> adverseReactions = new ArrayList<>();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_ADVERSE_REACTIONS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AdverseReaction newADReaction = new AdverseReaction();
                newADReaction.setId(rs.getInt("id"));
                newADReaction.setReportDate(rs.getDate("report_date"));
                newADReaction.setDescription(rs.getString("description"));
                newADReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newADReaction.setCriteria(Criteria.valueOf(rs.getString("criteria_name")));
                newADReaction.setOutcome(Outcome.valueOf(rs.getString("outcome_name")));
//                newADReaction.setUser(userRepository.getById(rs.getInt("user_id")));
//                newADReaction.setReporter(reporterRepository.getById(rs.getInt("reporter_id")));
//                newADReaction.setRelationship(relationshipRepository.getById(rs.getInt("causal_relationship_reporter_id")));
                newADReaction.setRelationshipByCompany(RelationshipType.valueOf(rs.getString("causal_relationship_company")));
                adverseReactions.add(newADReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adverseReactions;
    }

    public List<Integer> getAllId() {
        List<Integer> ADRId = new ArrayList<>();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_ADR_ID);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ADRId.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ADRId;
    }

    public Date getDateById(int id) {
        Date date;
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_DATE_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    date = new Date((Date) rs.getDate("report_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    public String getDescriptionById(int id) {
        String description = "";
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_DESCRIPTION_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    description = rs.getString("report_date"); //make StringBuffer
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return description;
    }

    public String getSuspectedDrugById(int id) {
        String suspectedDrug = "";
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_SUSPECTED_DRUG_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    suspectedDrug = rs.getString("suspected_drug"); //make StringBuffer
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suspectedDrug;
    }

    public Criteria getCriteriaById(int id) {
        Criteria criteria = criteriaRepository.getById(id);
        return criteria;
    }

    public Outcome getOutcomeById(int id) {
        Outcome outcome = outcomeRepository.getById(id);
        return outcome;
    }

    @Override
    public void save(AdverseReaction advReact) throws SQLException {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS);
//             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
//             ResultSet rs = ps2.executeQuery();
//             PreparedStatement ps3 = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
//             ResultSet rs2 = ps3.executeQuery();
//             PreparedStatement ps4 = con.prepareStatement(SQLQuery.GET_USER_ID_BY_NAME);
//             ResultSet rs3 = ps4.executeQuery()) {
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
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
    public boolean delete(Date reportDate, Reporter fullName) throws SQLException {
        boolean updatedRows = false;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_ADVERSE_REACTIONS);
//             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
//             ResultSet rs = ps2.executeQuery()) {
//
//            ps.setDate(1, reportDate);
//
//            ps2.setString(1, fullName.getFullName());
//            if (rs.next()) {
//                ps.setInt(2, rs.getInt(1));
//            }
//
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public boolean update(AdverseReaction advReact) throws SQLException {
        int updatedRows = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_ADVERSE_REACTIONS);
//             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
//             ResultSet rs = ps2.executeQuery();
//             PreparedStatement ps3 = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
//             ResultSet rs2 = ps3.executeQuery()) {
//
//            ps.setString(1, advReact.getDescription());
//            ps.setString(2, advReact.getSuspectedDrug());
//
//            ps2.setString(1, advReact.getCriteria().getName());
//            ps.setInt(3, rs.getInt("id"));
//
//            ps3.setString(1, advReact.getOutcome().getName());
//            ps.setInt(4, rs2.getInt("id"));
//
//            ps.setInt(5, advReact.getId());
//            updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public AdverseReaction getById(int id) {
        AdverseReaction advReaction = new AdverseReaction();
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setInt(1, id);
//            while (rs.next()) {
//                advReaction.setId(id);
//                advReaction.setReportDate(rs.getDate("report_date"));
//                advReaction.setDescription(rs.getString("description"));
//                advReaction.setSuspectedDrug(rs.getString("suspected_drug"));
//                advReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
//                advReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
//                advReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
//                advReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return advReaction;
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

