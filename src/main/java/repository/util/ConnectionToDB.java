package repository.util;

import java.sql.SQLException;

public class ConnectionToDB {

    public static DataSourceUtil connectionPool;
    private static final String URL = "jdbc:mysql://localhost:3306/adverse_reaction";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            connectionPool = DataSourceUtil.create(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

