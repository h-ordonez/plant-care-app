package business;

import java.io.Serializable;

public class Plant implements Serializable {
	
	private String commonName = "";
	private String sciName = "";
	private String waterInfo = "";
	private String sunInfo = "";
	private String plantDescription = "";
	private String imgFolder = "Images/";
	private String imgFileName = "";
	private String imgPath = "";
	
	// Constructors:
	public Plant() {
		String commonName = "";
		String sciName = "";
		String waterInfo = "";
		String sunInfo = "";
		String plantDescription = "";
		String imgFolder = "Images/";
		String imgFileName = "";
		String imgPath = "";
	}
	
	public Plant(String commonName, String sciName, String waterInfo,
						String sunInfo, String plantDescription,
						String imgFileName, String imgPath) {
		
		this.commonName = commonName;
		this.sciName = sciName;
		this.waterInfo = waterInfo;
		this.sunInfo = sunInfo;
		this.plantDescription = plantDescription;
		this.imgFolder = "Images/";
		this.imgFileName = imgFileName;
		this.imgPath = imgPath;
	}
	
	// Getters:
	public String getCommonName() {return commonName;}
	public String getSciName() {return sciName;}
	public String getWaterInfo() {return waterInfo;}
	public String getSunInfo() {return sunInfo;}
	public String getPlantDescription() {return plantDescription;}
	public String getImgFolder() {return imgFolder;}
	public String getImgFileName() {return imgFileName;}
	public String getImgPath() {return imgPath;}
	
	// Setters:
	public void setCommonName(String commonName) {this.commonName = commonName;}
	public void setSciName(String sciName) {this.sciName = sciName;}
	public void setWaterInfo(String waterInfo) {this.waterInfo = waterInfo;}
	public void setSunInfo(String sunInfo) {this.sunInfo = sunInfo;}
	public void setPlantDescription(String plantDescription) {this.plantDescription = plantDescription;}
	public void setImgFolder(String imgFolder) {this.imgFolder = imgFolder;}
	public void setImgFileName(String imgFileName) {this.imgFileName = imgFileName;}
	public void setImgPath(String imgPath) {this.imgPath = imgPath;}

} // end of class Plant
