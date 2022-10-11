package repository.impl;

import model.Relationship;
import model.AnswerType;
import model.RelationshipType;
import repository.RelationshipRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class RelationshipRepositoryImpl implements RelationshipRepository {

    private final DataSourceUtil pool;
    public RelationshipRepositoryImpl() {
        pool = DataSourceUtil.create();
    }

    @Override
    public Relationship getById(int id) {
        Relationship relationship = new Relationship();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_BY_RELATIONSHIPID)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    relationship.setId(rs.getInt("id"));

                    RelationshipType nameGivenByReporter = RelationshipType.getRelationshipTypeByLabel(rs.getString
                            ("name"));
                    relationship.setNameGivenByReporter(nameGivenByReporter);

                    AnswerType timeRelationship = AnswerType.getAnswerTypeByLabel(rs.getString
                            ("time_relationship"));
                    relationship.setTimeRelationship(timeRelationship);

                    AnswerType withdrawalResult = AnswerType.getAnswerTypeByLabel(rs.getString
                            ("withdrawal_result"));
                    relationship.setWithdrawalResult(withdrawalResult);

                    AnswerType reintroductionResult = AnswerType.getAnswerTypeByLabel(rs.getString
                            ("reintroduction_result"));
                    relationship.setReintroductionResult(reintroductionResult);

                    AnswerType otherExplanation = AnswerType.getAnswerTypeByLabel(rs.getString("other_explanaition"));
                    relationship.setOtherExplanation(otherExplanation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return relationship;
    }

    @Override
    public void save(Relationship relationship) {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_RELATIONSHIPS)) {

            ps.setString(1, relationship.getNameGivenByReporter().name());
            ps.setString(2, relationship.getTimeRelationship().name());
            ps.setString(3, relationship.getWithdrawalResult().name());
            ps.setString(4, relationship.getReintroductionResult().name());
            ps.setString(5, relationship.getOtherExplanation().name());
            ps.executeUpdate();
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'causal_relationships'.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public int getId(Relationship relationship) {
        int id = 0;
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_ID)) {

            ps.setString(1, relationship.getNameGivenByReporter().name());
            ps.setString(2, relationship.getTimeRelationship().name());
            ps.setString(3, relationship.getWithdrawalResult().name());
            ps.setString(4, relationship.getReintroductionResult().name());
            ps.setString(5, relationship.getOtherExplanation().name());

            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return id;
    }


}
