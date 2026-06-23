package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import business.Plant;

public class PlantDAO {

    private Connection getConnection() throws SQLException, IOException {
        Properties props = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            props.load(is);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found.", e);
        }
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.username"),
                props.getProperty("db.password")
        );
    }

    public Plant searchByName(String name) throws SQLException, IOException {
        String query = "SELECT * FROM plants WHERE common_name = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        }
        return null;
    }

    public List<Plant> getAllPlants() throws SQLException, IOException {
        List<Plant> plants = new ArrayList<>();
        String query = "SELECT * FROM plants ORDER BY common_name";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                plants.add(mapRow(rs));
            }
        }
        return plants;
    }

    private Plant mapRow(ResultSet rs) throws SQLException {
        Plant plant = new Plant();
        plant.setCommonName(rs.getString("common_name"));
        plant.setSciName(rs.getString("scientific_name"));
        plant.setWaterInfo(rs.getString("watering_frequency"));
        plant.setSunInfo(rs.getString("sunlight_amount"));
        plant.setPlantDescription(rs.getString("plant_description"));
        plant.setImgFileName(rs.getString("img_file_name"));
        plant.setImgPath("Images/" + rs.getString("img_file_name"));
        return plant;
    }
}
