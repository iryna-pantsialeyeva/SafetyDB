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

    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;
    private final ReporterRepository reporterRepository;
    private final DataSourceUtil pool;

    public AdverseReactionRepositoryImpl() {
        userRepository = new UserRepositoryImpl();
        relationshipRepository = new RelationshipRepositoryImpl();
        reporterRepository = new ReporterRepositoryImpl();
        pool = DataSourceUtil.create();
    }

    @Override
    public List<AdverseReaction> getAll() {
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
        } finally {
            pool.releaseConnection(con);
        }
        return adverseReactions;
    }

    @Override
    public void save(AdverseReaction advReact) throws SQLException {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void update(AdverseReaction advReact) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void delete(int id) {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.DELETE_FROM_ADVERSE_REACTIONS_BY_ID)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

            ResultSet rs = ps.executeQuery();
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
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return newADReaction;
    }
}

