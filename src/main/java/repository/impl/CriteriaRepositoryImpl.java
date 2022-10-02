package repository.impl;

import model.Criteria;
import model.enums.CriteriaType;
import model.enums.RelationshipType;
import repository.CriteriaRepository;
import repository.util.ConnectionToDB;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class CriteriaRepositoryImpl implements CriteriaRepository {

    public CriteriaRepositoryImpl() {
    }

    @Override
    public Criteria getById(int id) {
        Criteria newCriteria = new Criteria();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_CRITERIAS_BY_ID);
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newCriteria.setId(rs.getInt("id"));
                    CriteriaType name = CriteriaType.valueOf(rs.getString("name"));
                    newCriteria.setName(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCriteria;
    }

    @Override
    public Criteria getByName(String name) {
        Criteria newCriteria = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_CRITERIAS_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                newCriteria = new Criteria(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newCriteria;
    }

    @Override
    public Criteria add(Criteria criteria) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_CRITERIAS, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, criteria.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//
//            if (rs.next()) {
//                criteria.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return criteria;
    }

    @Override
    public int getId(CriteriaType criteriaType) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_CRITERIAS_BY_NAME);
//             ResultSet rs = ps.executeQuery();) {
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                id = rs.getInt("id");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return id;
    }
}
