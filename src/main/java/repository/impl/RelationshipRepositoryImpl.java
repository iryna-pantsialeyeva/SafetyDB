package repository.impl;

import repository.RelationshipRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.*;

public class RelationshipRepositoryImpl implements RelationshipRepository {

    @Override
    public void save(Relationship relationship) {
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_RELATIONSHIPS)) {

            ps.setString(1, relationship.getNameGivenByReporter().name());
            ps.setString(2, relationship.getTimeRelationship());
            ps.setString(3, relationship.getWithdrawalResult());
            ps.setString(4, relationship.getReintroductionResult());
            ps.setString(5, relationship.getOtherExplanation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getId(Relationship relationship) {
        int id = 0;
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_ID);
             ResultSet rs = ps.executeQuery()) {

            ps.setString(1, relationship.getNameGivenByReporter());
            ps.setString(2, relationship.getTimeRelationship());
            ps.setString(3, relationship.getWithdrawalResult());
            ps.setString(4, relationship.getReintroductionResult());
            ps.setString(5, relationship.getOtherExplanation());

            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Relationship getByID(int id) {
        Relationship relationship = new Relationship();
        try (Connection con = ConnectionToDB.connectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_BY_ID);
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    relationship.setId(rs.getInt("id"));

                    RelationshipType nameGivenByReporter = RelationshipType.valueOf(rs.getString("name"));
                    relationship.setNameGivenByReporter(nameGivenByReporter);

                    AnswerType timeRelationship = AnswerType.valueOf(rs.getString("time_relationship"));
                    relationship.setTimeRelationship(timeRelationship);

                    AnswerType withdrawalResult = AnswerType.valueOf(rs.getString("withdrawal_result"));
                    relationship.setWithdrawalResult(withdrawalResult);

                    AnswerType reintroductionResult = AnswerType.valueOf(rs.getString("reintroduction_result"));
                    relationship.setReintroductionResult(reintroductionResult);

                    AnswerType otherExplanation = AnswerType.valueOf(rs.getString("other_explanaition"));
                    relationship.setOtherExplanation(otherExplanation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relationship;
    }
}
