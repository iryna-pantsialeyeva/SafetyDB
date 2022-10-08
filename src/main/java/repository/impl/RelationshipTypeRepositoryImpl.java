package repository.impl;

import model.RelationshipType;
import repository.RelationshipTypeRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelationshipTypeRepositoryImpl implements RelationshipTypeRepository {

    public RelationshipTypeRepositoryImpl() {
    }

    @Override
    public RelationshipType getById(int id) {
        RelationshipType relationshipType = RelationshipType.valueOf("");
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_RELATIONSHIPTYPE_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    relationshipType = RelationshipType.valueOf(rs.getString("criteria_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relationshipType;
    }
}
