package pl.marko.db;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDAO {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    protected void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
