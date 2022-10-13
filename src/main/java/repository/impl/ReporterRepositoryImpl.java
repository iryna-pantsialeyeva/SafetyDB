package repository.impl;

import model.Reporter;
import model.ReporterType;
import repository.ReporterRepository;
import repository.util.DataSourceUtil;
import repository.util.SQLQuery;

import java.sql.*;

public class ReporterRepositoryImpl implements ReporterRepository {

    private final ReporterTypeRepositoryImpl reporterTypeRepository;
    private final DataSourceUtil pool;

    public ReporterRepositoryImpl() {
        this.reporterTypeRepository = new ReporterTypeRepositoryImpl();
        pool = DataSourceUtil.create();
    }

    @Override
    public void add(Reporter reporter) {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_REPORTERS)) {

            ps.setString(1, reporter.getFullName());
            ps.setString(2, reporter.getType().name());
            ps.executeUpdate();
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'reporters'.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public void update(Reporter reporter) {
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.UPDATE_IN_REPORTERS)) {

            ps.setString(1, reporter.getFullName());
            ps.setString(2, reporter.getType().name());
            ps.setInt(3, reporter.getId());
            ps.executeUpdate();
//            int updatedRows = ps.executeUpdate();
//            System.out.println(updatedRows + " rows were updated in 'reporters'.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
    }

    @Override
    public Reporter getById(int id) {
        Reporter newReporter = new Reporter();
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_BY_REPORTERID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newReporter = new Reporter(rs.getInt("id"), rs.getString("full_name"),
                            ReporterType.getReporterTypeByLabel(rs.getString("reporter_type_name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return newReporter;
    }

    @Override
    public int getId(String fullName) {
        int id = 0;
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_ID_BY_NAME)) {

            ps.setString(1, fullName);
            try (ResultSet rs = ps.executeQuery()) {
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

    @Override
    public Reporter getByName(String fullName) {
        Reporter newReporter = null;
        Connection con = pool.getConnection();
        try (PreparedStatement ps = con.prepareStatement(SQLQuery.GET_REPORTER_BY_NAME)) {

            ps.setString(1, fullName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    newReporter = new Reporter(rs.getInt("id"), rs.getString("full_name"),
                            ReporterType.getReporterTypeByLabel(rs.getString("reporter_type_name")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.releaseConnection(con);
        }
        return newReporter;
    }
}
