package repository.impl;

import model.*;
import repository.AdverseReactionRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class AdverseReactionRepositoryImpl implements AdverseReactionRepository {

    private final OutcomeRepositoryImpl outcomeRepository;
    private final CriteriaRepositoryImpl criteriaRepository;
    private final ReporterRepositoryImpl reporterRepository;
    private final ReporterTypeRepositoryImpl reporterTypeRepository;

    public AdverseReactionRepositoryImpl(OutcomeRepositoryImpl outcomeRepository,
                                         CriteriaRepositoryImpl criteriaRepository,
                                         ReporterRepositoryImpl reporterRepository,
                                         ReporterTypeRepositoryImpl reporterTypeRepository) {
        this.outcomeRepository = outcomeRepository;
        this.criteriaRepository = criteriaRepository;
        this.reporterRepository = reporterRepository;
        this.reporterTypeRepository = reporterTypeRepository;

    }

    public List<AdverseReaction> getAll() {
        List<AdverseReaction> adverseReactions = new ArrayList<>();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_ADVERSE_REACTIONS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AdverseReaction newADReaction = new AdverseReaction(rs.getInt("id"),
                        rs.getDate("report_date"),
                        rs.getString("description"),
                        rs.getString("suspected_drug"),
                        outcomeRepository.getByID(rs.getInt("outcome_id")),
                        criteriaRepository.getByID(rs.getInt("criteria_id")),
                        reporterTypeRepository.getByID(rs.getInt("reporter_type_id")),
                        reporterRepository.getByID(rs.getInt("reporter_id")));
                adverseReactions.add(newADReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adverseReactions;
    }

    public void save(AdverseReaction advReact) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS)) {

            ps.setDate(1, (Date) advReact.getReportDate());
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setInt(4, advReact.getCriteria().getId());
            ps.setInt(5, advReact.getOutcome().getId());
            ps.setInt(6, advReact.getFullName().getId());
            ps.setInt(7, advReact.getType().getId());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId(AdverseReaction advReaction) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_ID_BY_PARAMETERS);
             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
             ResultSet rs = ps2.executeQuery();
             PreparedStatement ps3 = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
             ResultSet rs2 = ps3.executeQuery();
             PreparedStatement ps4 = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
             ResultSet rs3 = ps4.executeQuery();
             PreparedStatement ps5 = con.prepareStatement(SQLQuery.GET_REPORTER_TYPE_ID_BY_NAME);
             ResultSet rs4 = ps5.executeQuery(); ResultSet rs5 = ps.executeQuery()) {

            ps.setDate(1, (Date) advReaction.getReportDate());
            ps.setString(2, advReaction.getDescription());
            ps.setString(3, advReaction.getSuspectedDrug());

            ps2.setString(1, advReaction.getCriteria().getName());
            if (rs.next()) {
                ps.setInt(4, rs.getInt(1));
            }

            ps3.setString(1, advReaction.getOutcome().getName());
            if (rs2.next()) {
                ps.setInt(5, rs2.getInt(1));
            }

            ps4.setString(1, advReaction.getFullName().getFullName());
            if (rs3.next()) {
                ps.setInt(6, rs3.getInt(1));
            }

            ps5.setString(1, advReaction.getType().getName());
            if (rs4.next()) {
                ps.setInt(7, rs4.getInt(1));
            }

            if (rs5.next()) {
                id = rs5.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<AdverseReaction> get(String suspectedDrug) {
        List<AdverseReaction> advReactions = new ArrayList();
        AdverseReaction newAdvReaction = new AdverseReaction();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_SUSPECTED_DRUG);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, suspectedDrug);
            while (rs.next()) {
                newAdvReaction.setId(rs.getInt("id"));
                newAdvReaction.setReportDate(rs.getDate("report_date"));
                newAdvReaction.setDescription(rs.getString("description"));
                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newAdvReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
                newAdvReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
                newAdvReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
                newAdvReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
                advReactions.add(newAdvReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advReactions;
    }

    public List<AdverseReaction> getByFullName(String fullName) {
        List<AdverseReaction> advReactions = new ArrayList();
        AdverseReaction newAdvReaction = new AdverseReaction();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
             ResultSet rs = ps.executeQuery();
             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_REPORTER);
             ResultSet rs2 = ps2.executeQuery()) {

            ps.setString(1, fullName);
            ps2.setInt(1, rs.getInt("id"));
            while (rs2.next()) {
                newAdvReaction.setId(rs2.getInt("id"));
                newAdvReaction.setReportDate(rs2.getDate("report_date"));
                newAdvReaction.setDescription(rs2.getString("description"));
                newAdvReaction.setSuspectedDrug(rs2.getString("suspected_drug"));
                newAdvReaction.setOutcome(outcomeRepository.getByID(rs2.getInt("outcome_id")));
                newAdvReaction.setCriteria(criteriaRepository.getByID(rs2.getInt("criteria_id")));
                newAdvReaction.setFullName(reporterRepository.getByID(rs2.getInt("reporter_id")));
                newAdvReaction.setType(reporterTypeRepository.getByID(rs2.getInt("reporter_type_id")));
                advReactions.add(newAdvReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advReactions;
    }

    public int delete(Date reportDate, Reporter fullName) {
        int updatedRows = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_ADVERSE_REACTIONS);
             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME);
             ResultSet rs = ps2.executeQuery()) {

            ps.setDate(1, reportDate);

            ps2.setString(1, fullName.getFullName());
            if (rs.next()) {
                ps.setInt(2, rs.getInt(1));
            }

            updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    public int update(AdverseReaction advReact) {
        int updatedRows = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_ADVERSE_REACTIONS);
             PreparedStatement ps2 = con.prepareStatement(SQLQuery.GET_CRITERIA_ID_BY_NAME);
             ResultSet rs = ps2.executeQuery();
             PreparedStatement ps3 = con.prepareStatement(SQLQuery.GET_OUTCOME_ID_BY_NAME);
             ResultSet rs2 = ps3.executeQuery()) {

            ps.setString(1, advReact.getDescription());
            ps.setString(2, advReact.getSuspectedDrug());

            ps2.setString(1, advReact.getCriteria().getName());
            ps.setInt(3, rs.getInt("id"));

            ps3.setString(1, advReact.getOutcome().getName());
            ps.setInt(4, rs2.getInt("id"));

            ps.setInt(5, advReact.getId());
            updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRows;
    }

    public AdverseReaction getById(int id) {
        AdverseReaction advReaction = new AdverseReaction();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);
            while (rs.next()) {
                advReaction.setId(id);
                advReaction.setReportDate(rs.getDate("report_date"));
                advReaction.setDescription(rs.getString("description"));
                advReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                advReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
                advReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
                advReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
                advReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return advReaction;
    }

    public AdverseReaction getByName(String title) {
        AdverseReaction newAdvReaction = new AdverseReaction();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_TITLE);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, title);
            if (rs.next()) {
                newAdvReaction.setId(rs.getInt("id"));
                newAdvReaction.setReportDate(rs.getDate("report_date"));
                newAdvReaction.setDescription(rs.getString("description"));
                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newAdvReaction.setOutcome(outcomeRepository.getByID(rs.getInt("outcome_id")));
                newAdvReaction.setCriteria(criteriaRepository.getByID(rs.getInt("criteria_id")));
                newAdvReaction.setFullName(reporterRepository.getByID(rs.getInt("reporter_id")));
                newAdvReaction.setType(reporterTypeRepository.getByID(rs.getInt("reporter_type_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newAdvReaction;
    }
}
