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
             ResultSet rs = ps.executeQuery()) {

            ps.setInt(1, id);

            while (rs.next()) {
                relationship.setNameGivenByReporter.valueOf(rs.getString("name"));
                relationship.setTimeRelationship.valueOf(rs.getString("time_relationship"));
                relationship.setWithdrawalResult.valueOf(rs.getString("withdrawal_result"));
                relationship.setReintroductionResult.valueOf(rs.getString("reintroduction_result"));
                relationship.setOtherExplanation.valueOf(rs.getString("other_explanaition"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relationship;
    }
}
