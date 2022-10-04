package repository.util;

public class ConnectionProperties {

    public static DataSourceUtil connectionPool;
    public static final String URL = "jdbc:mysql://localhost:3306/adverse_reaction";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

//    static {
//        try {
//            connectionPool = DataSourceUtil.create(URL, USER, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}

