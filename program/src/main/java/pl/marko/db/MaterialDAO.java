package pl.marko.db;

import pl.marko.model.Material;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MaterialDAO extends AbstractDAO {

    public MaterialDAO(Connection connection) {
        super(connection);
    }

    public void addMaterial(Material material) throws SQLException {
        String sql = "INSERT INTO materialy (nazwa, cena, jednostka_miary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getNazwa());
            stmt.setDouble(2, material.getCena());
            stmt.setString(3, material.getJednostkaMiary());
            stmt.executeUpdate();
        }
    }

    public List<Material> getAllMaterialy() throws SQLException {
        List<Material> materialy = new ArrayList<>();
        String sql = "SELECT * FROM materialy";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Material material = new Material();
                material.setId(rs.getLong("id"));
                material.setNazwa(rs.getString("nazwa"));
                material.setCena(rs.getDouble("cena"));
                material.setJednostkaMiary(rs.getString("jednostka_miary"));
                materialy.add(material);
            }
        }
        return materialy;
    }

    // Inne metody CRUD
}