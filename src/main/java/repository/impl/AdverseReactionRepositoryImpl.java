package repository.impl;

import model.*;
import repository.AdverseReactionRepository;
import repository.util.ConnectionToDB;
import repository.util.SQLQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class AdverseReactionRepositoryImpl implements AdverseReactionRepository {

    public void save (AdverseReaction advReact) {
        Connection con = ConnectionToDB.connectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SQLQuery.INSERT_IN_ADVERSE_REACTIONS);
            ps.setDate(1, (Date) advReact.getReportDate());
            ps.setString(2, advReact.getDescription());
            ps.setString(3, advReact.getSuspectedDrug());

            try {
                Criteria criteria = RepositorySupplier.getCriteriaRepository().setInDB(advReact.getCriteria());
                ps.setInt (4, criteria.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Outcome outcome = RepositorySupplier.getOutcomeRepository().setInDB(advReact.getOutcome());
                ps.setInt (5, outcome.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Reporter reporter = RepositorySupplier.getReporterRepository().setInDB(advReact.getFullName());
                ps.setInt (6, reporter.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                Type reporterType = RepositorySupplier.getReporterTypeRepository().setInDB(advReact.getType());
                ps.setInt (7, reporterType.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDB.connectionPool.releaseConnection(con);
        }
    }
}
