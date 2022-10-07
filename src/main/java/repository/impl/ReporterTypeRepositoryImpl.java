package repository.impl;

import model.Type;
import model.ReporterType;
import repository.ReporterTypeRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterTypeRepositoryImpl implements ReporterTypeRepository {

    public ReporterTypeRepositoryImpl() {
    }

    @Override
    public Type getById(int id) {
        Type newType = new Type();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_ID);
        ) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newType.setId(rs.getInt("id"));
                    ReporterType name = ReporterType.valueOf(rs.getString("name"));
                    newType.setName(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newType;
    }

    @Override
    public Type getByName(String name) {
        Type newType = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                newType = new Type(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newType;
    }

    @Override
    public Type add(Type type) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTER_TYPES, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, type.getName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//
//            if (rs.next()) {
//                type.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return type;
    }

    @Override
    public int getId(ReporterType reporterType) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTER_TYPES_BY_NAME);
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
