package repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSourceUtil implements ConnectionPool {

    private String url;
    private String user;
    private String password;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 10;
        private static final String URL = "jdbc:mysql://localhost:3306/adverse_reaction";
//    private static final String URL = "jdbc:mysql://127.0.0.1/adverse_reaction?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public DataSourceUtil(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

    public static DataSourceUtil create() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        int retries = 0;
        try {
            while (pool.size() < INITIAL_POOL_SIZE && retries <= 5) {
                Connection connection = createConnection(URL, USER, PASSWORD);
                if (connection == null) {
                    retries++;
                    continue;
                }
                pool.add(connection);
                retries = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DataSourceUtil(URL, USER, PASSWORD, pool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
