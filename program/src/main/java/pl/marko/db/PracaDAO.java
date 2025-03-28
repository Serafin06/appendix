package pl.marko.db;

import pl.marko.model.Praca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PracaDAO extends AbstractDAO {

    public PracaDAO(Connection connection) {
        super(connection);
    }

    public void addPraca(Praca praca) throws SQLException {
        String sql = "INSERT INTO praca (adres, data_wykonania, ilosc_godzin, dojazd, vat) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, praca.getAdres());
            stmt.setDate(2, new java.sql.Date(praca.getDataWykonania().getTime()));
            stmt.setInt(3, praca.getIloscGodzin());
            stmt.setBoolean(4, praca.isDojazd());
            stmt.setDouble(5, praca.getVat());
            stmt.executeUpdate();
        }
    }

    public List<Praca> getAllPrace() throws SQLException {
        List<Praca> prace = new ArrayList<>();
        String sql = "SELECT * FROM praca";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Praca praca = new Praca();
                praca.setId(rs.getLong("id"));
                praca.setAdres(rs.getString("adres"));
                praca.setDataWykonania(rs.getDate("data_wykonania"));
                praca.setIloscGodzin(rs.getInt("ilosc_godzin"));
                praca.setDojazd(rs.getBoolean("dojazd"));
                praca.setVat(rs.getDouble("vat"));
                prace.add(praca);
            }
        }
        return prace;
    }

    // Inne metody CRUD
}