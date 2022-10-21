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

    private final DataSourceUtil pool;

    public AdverseReactionRepositoryImpl() {
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
                newADReaction.setRelationshipByCompany(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_company")));
                newADReaction.setNameGivenByReporter(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_reporter")));
                newADReaction.setTimeRelationship(AnswerType.getAnswerTypeByLabel(rs.getString("time_relationship")));
                newADReaction.setWithdrawalResult(AnswerType.getAnswerTypeByLabel(rs.getString("withdrawal_result")));
                newADReaction.setReintroductionResult(AnswerType.getAnswerTypeByLabel(rs.getString("reintroduction_result")));
                newADReaction.setOtherExplanation(AnswerType.getAnswerTypeByLabel(rs.getString("other_explanation")));
                adverseReactions.add(newADReaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return adverseReactions;
    }

    //TODO replace parameter 6 with User.id
    @Override
    public void save(AdverseReaction advReact) throws SQLException {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS)) {

            ps.setDate(1, Date.valueOf(advReact.getReportDate()));
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setString(4, advReact.getOutcome().name());
            ps.setString(5, advReact.getCriteria().name());
            ps.setInt(6, 0);
            ps.setString(7, advReact.getRelationshipByCompany().name());
            ps.setString(8, advReact.getNameGivenByReporter().name());
            ps.setString(9, advReact.getTimeRelationship().name());
            ps.setString(10, advReact.getWithdrawalResult().name());
            ps.setString(11, advReact.getReintroductionResult().name());
            ps.setString(12, advReact.getOtherExplanation().name());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void update(AdverseReaction advReact) throws SQLException {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_ADVERSE_REACTIONS)) {

            ps.setDate(1, Date.valueOf(advReact.getReportDate()));
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());
            ps.setString(4, advReact.getOutcome().name());
            ps.setString(5, advReact.getCriteria().name());
            ps.setInt(6, advReact.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
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
                newADReaction.setRelationshipByCompany(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_company")));
                newADReaction.setNameGivenByReporter(RelationshipType.getRelationshipTypeByLabel(rs.getString("causal_relationship_reporter")));
                newADReaction.setTimeRelationship(AnswerType.getAnswerTypeByLabel(rs.getString("time_relationship")));
                newADReaction.setWithdrawalResult(AnswerType.getAnswerTypeByLabel(rs.getString("withdrawal_result")));
                newADReaction.setReintroductionResult(AnswerType.getAnswerTypeByLabel(rs.getString("reintroduction_result")));
                newADReaction.setOtherExplanation(AnswerType.getAnswerTypeByLabel(rs.getString("other_explanation")));
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

