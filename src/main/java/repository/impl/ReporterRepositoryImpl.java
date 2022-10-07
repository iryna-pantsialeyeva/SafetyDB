package repository.impl;

import model.Reporter;
import model.ReporterType;
import repository.ReporterRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    private final ReporterTypeRepositoryImpl reporterTypeRepository;

    public ReporterRepositoryImpl() {
        this.reporterTypeRepository = new ReporterTypeRepositoryImpl();
    }

    @Override
    public Reporter getById(int id) {
        Reporter newReporter = new Reporter();
        try (Connection con = DataSourceUtil.create().getConnection();
             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_BY_REPORTERID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newReporter = new Reporter(rs.getInt("id"), rs.getString("full_name"),
                            ReporterType.valueOf(rs.getString("reporter_type_name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newReporter;
    }

    @Override
    public Reporter getByName(String name) {
        Reporter newReporter = null;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
//
//            ps.setString(1, name);
//            if (rs.next()) {
//                newReporter = new Reporter(rs.getInt("id"), rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return newReporter;
    }

    @Override
    public Reporter add(Reporter reporter) {
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS, Statement.RETURN_GENERATED_KEYS);
//             ResultSet rs = ps.getGeneratedKeys()) {
//
//            ps.setString(1, reporter.getFullName());
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'authors'.");
//
//            if (rs.next()) {
//                reporter.setId(rs.getInt(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return reporter;
    }

    @Override
    public int getId(String name) {
        int id = 0;
//        try (Connection con = ConnectionToDB.connectionPool.getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLQuery.GET_FROM_REPORTERS_BY_NAME);
//             ResultSet rs = ps.executeQuery()) {
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
