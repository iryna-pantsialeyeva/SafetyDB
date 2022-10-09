package repository.impl;

import model.Relationship;
import model.AnswerType;
import model.RelationshipType;
import repository.RelationshipRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class RelationshipRepositoryImpl implements RelationshipRepository {

    public RelationshipRepositoryImpl() {}

    @Override
    public Relationship getById(int id) {
        Relationship relationship = new Relationship();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_BY_RELATIONSHIPID);
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    relationship.setId(rs.getInt("id"));

                    RelationshipType nameGivenByReporter = RelationshipType.valueOf(rs.getString("name").toUpperCase());
                    relationship.setNameGivenByReporter(nameGivenByReporter);

                    AnswerType timeRelationship = AnswerType.valueOf(rs.getString("time_relationship").toUpperCase());
                    relationship.setTimeRelationship(timeRelationship);

                    AnswerType withdrawalResult = AnswerType.valueOf(rs.getString("withdrawal_result").toUpperCase());
                    relationship.setWithdrawalResult(withdrawalResult);

                    AnswerType reintroductionResult = AnswerType.valueOf(rs.getString("reintroduction_result").toUpperCase());
                    relationship.setReintroductionResult(reintroductionResult);

                    AnswerType otherExplanation = AnswerType.valueOf(rs.getString("other_explanaition").toUpperCase());
                    relationship.setOtherExplanation(otherExplanation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relationship;
    }

    @Override
    public void save(Relationship relationship) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_RELATIONSHIPS)) {
//
//            ps.setString(1, relationship.getNameGivenByReporter().name());
//            ps.setString(2, relationship.getTimeRelationship());
//            ps.setString(3, relationship.getWithdrawalResult());
//            ps.setString(4, relationship.getReintroductionResult());
//            ps.setString(5, relationship.getOtherExplanation());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public int getId(Relationship relationship) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIP_ID);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, relationship.getNameGivenByReporter());
//            ps.setString(2, relationship.getTimeRelationship());
//            ps.setString(3, relationship.getWithdrawalResult());
//            ps.setString(4, relationship.getReintroductionResult());
//            ps.setString(5, relationship.getOtherExplanation());
//
//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }


}
