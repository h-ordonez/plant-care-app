package com.plantcareapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.plantcareapp.model.Plant;

@Repository
public class PlantDAO {

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Plant searchByName(String name) throws SQLException {
        String query = "SELECT * FROM plants WHERE LOWER(common_name) LIKE LOWER(CONCAT('%', ?, '%'))";
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

    public List<Plant> getAllPlants() throws SQLException {
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
