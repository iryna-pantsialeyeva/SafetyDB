package repository.impl;

import model.*;
import repository.AdverseReactionRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class AdverseReactionRepositoryImpl implements AdverseReactionRepository {

    private static final CriteriaRepositoryImpl CRITERIA_REPOSITORY = new CriteriaRepositoryImpl();
    private static final OutcomeRepositoryImpl OUTCOME_REPOSITORY = new OutcomeRepositoryImpl();
    private static final ReporterRepositoryImpl REPORTER_REPOSITORY = new ReporterRepositoryImpl();
    private static final ReporterTypeRepositoryImpl REPORTER_TYPE_REPOSITORY = new ReporterTypeRepositoryImpl();

    public AdverseReactionRepositoryImpl() {
    }

    public List<AdverseReaction> getAll() {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        List<AdverseReaction> adverseReactions = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ALL_ADVERSE_REACTIONS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AdverseReaction newADReaction = new AdverseReaction(rs.getInt("id"),
                        rs.getDate("report_date"),
                        rs.getString("description"),
                        rs.getString("suspected_drug"),
                        OUTCOME_REPOSITORY.getByID(rs.getInt("outcome_id")),
                        CRITERIA_REPOSITORY.getByID(rs.getInt("criteria_id")),
                        REPORTER_TYPE_REPOSITORY.getByID(rs.getInt("reporter_type_id")),
                        REPORTER_REPOSITORY.getByID(rs.getInt("reporter_id")));
                adverseReactions.add(newADReaction);
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return adverseReactions;
    }

    public void save(AdverseReaction advReact) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS);
            ps.setDate(1, (Date) advReact.getReportDate());
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setInt(4, advReact.getCriteria().getId());
            ps.setInt(5, advReact.getOutcome().getId());
            ps.setInt(6, advReact.getFullName().getId());
            ps.setInt(7, advReact.getType().getId());
            int updatedRows = ps.executeUpdate();
            closePS(ps);
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
    }

    public void update(AdverseReaction advReact) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_ADVERSE_REACTIONS);
            ps.setDate(1, (Date) advReact.getReportDate());
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setInt(4, advReact.getCriteria().getId());
            ps.setInt(5, advReact.getOutcome().getId());
            ps.setInt(6, advReact.getFullName().getId());
            ps.setInt(7, advReact.getType().getId());
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
            closePS(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
    }

    public void delete(int id) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_ADVERSE_REACTIONS);
            ps.setInt(1, id);
            int updatedRows = ps.executeUpdate();
            System.out.println(updatedRows + " rows were updated in 'adverse_reactions'.");
            closePS(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
    }

    public AdverseReaction getById(int id) {
        AdverseReaction advReaction = new AdverseReaction();
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                advReaction.setId(id);
                advReaction.setReportDate(rs.getDate("report_date"));
                advReaction.setDescription(rs.getString("description"));
                advReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                advReaction.setOutcome(OUTCOME_REPOSITORY.getByID(rs.getInt("outcome_id")));
                advReaction.setCriteria(CRITERIA_REPOSITORY.getByID(rs.getInt("criteria_id")));
                advReaction.setFullName(REPORTER_REPOSITORY.getByID(rs.getInt("reporter_id")));
                advReaction.setType(REPORTER_TYPE_REPOSITORY.getByID(rs.getInt("reporter_type_id")));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return advReaction;
    }

    public AdverseReaction getByName(String title) {
        AdverseReaction newAdvReaction = new AdverseReaction();
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_TITLE);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                newAdvReaction.setId(rs.getInt("id"));
                newAdvReaction.setReportDate(rs.getDate("report_date"));
                newAdvReaction.setDescription(rs.getString("description"));
                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newAdvReaction.setOutcome(OUTCOME_REPOSITORY.getByID(rs.getInt("outcome_id")));
                newAdvReaction.setCriteria(CRITERIA_REPOSITORY.getByID(rs.getInt("criteria_id")));
                newAdvReaction.setFullName(REPORTER_REPOSITORY.getByID(rs.getInt("reporter_id")));
                newAdvReaction.setType(REPORTER_TYPE_REPOSITORY.getByID(rs.getInt("reporter_type_id")));
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return newAdvReaction;
    }

    public int getId(AdverseReaction advReaction) {
        int id = 0;
        AdverseReaction newAdvReaction = new AdverseReaction();
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_ID_BY_PARAMETERS);
            ps.setDate(1, (Date) advReaction.getReportDate());
            ps.setString(2, advReaction.getDescription());
            ps.setString(3, advReaction.getSuspectedDrug());
            ps.setInt(4, advReaction.getCriteria().getId());
            ps.setInt(5, advReaction.getOutcome().getId());
            ps.setInt(6, advReaction.getFullName().getId());
            ps.setInt(7, advReaction.getType().getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return id;
    }

    public List<AdverseReaction> get(String suspectedDrug) {
        List<AdverseReaction> advReactions = new ArrayList();
        AdverseReaction newAdvReaction = new AdverseReaction();
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.GET_ADVERSE_REACTION_BY_SUSPECTED_DRUG);
            ps.setString(1, suspectedDrug);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                newAdvReaction.setId(rs.getInt("id"));
                newAdvReaction.setReportDate(rs.getDate("report_date"));
                newAdvReaction.setDescription(rs.getString("description"));
                newAdvReaction.setSuspectedDrug(rs.getString("suspected_drug"));
                newAdvReaction.setOutcome(OUTCOME_REPOSITORY.getByID(rs.getInt("outcome_id")));
                newAdvReaction.setCriteria(CRITERIA_REPOSITORY.getByID(rs.getInt("criteria_id")));
                newAdvReaction.setFullName(REPORTER_REPOSITORY.getByID(rs.getInt("reporter_id")));
                newAdvReaction.setType(REPORTER_TYPE_REPOSITORY.getByID(rs.getInt("reporter_type_id")));
                advReactions.add(newAdvReaction);
            }
            closePS(ps);
            closeRS(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
        return advReactions;
    }

    private static void closePS(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ignore) {

            }
        }
    }

    private static void closeRS(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ignore) {

            }
        }
    }
}
