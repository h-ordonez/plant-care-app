package com.plantcareapp.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "plants")
public class Plant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plant_id")
	private int id;

	@Column(name = "common_name")
	private String commonName;

	@Column(name = "scientific_name")
	private String sciName;

	@Column(name = "watering_frequency")
	private String waterInfo;

	@Column(name = "sunlight_amount")
	private String sunInfo;

	@Column(name = "plant_description")
	private String plantDescription;

	@Column(name = "img_file_name")
	private String imgFileName;

	public Plant() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getSciName() {
		return sciName;
	}

	public void setSciName(String sciName) {
		this.sciName = sciName;
	}

	public String getWaterInfo() {
		return waterInfo;
	}

	public void setWaterInfo(String waterInfo) {
		this.waterInfo = waterInfo;
	}

	public String getSunInfo() {
		return sunInfo;
	}

	public void setSunInfo(String sunInfo) {
		this.sunInfo = sunInfo;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgPath() {
		return "Images/" + imgFileName;
	}
}
