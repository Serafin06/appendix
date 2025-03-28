package pl.marko.db;

import pl.marko.model.Budynek;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BudynekDAO {
    private Connection connection;

    public BudynekDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBudynek(Budynek budynek) throws SQLException {
        String sql = "INSERT INTO budynki (adres) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, budynek.getAdres());
            stmt.executeUpdate();
        }
    }

    public List<Budynek> getAllBudynki() throws SQLException {
        List<Budynek> budynki = new ArrayList<>();
        String sql = "SELECT * FROM budynki";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Budynek budynek = new Budynek();
                budynek.setId(rs.getLong("id"));
                budynek.setAdres(rs.getString("adres"));
                budynki.add(budynek);
            }
        }
        return budynki;
    }

    // Inne metody CRUD
}