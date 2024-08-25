<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>${plant.commonName}</title>
	<link rel="stylesheet" href="styles.css">
</head>

<body class="bg">

	<ul class="nav">
		<li><a href="index.html">Home</a></li>
		<li><a href="about.html">About</a></li>
		<li><a href="contact.html">Contact</a></li>
	</ul>
	
	<div class ="content">
		<div class="plant-header">
			<h1><span>${plant.commonName}</span></h1>
			<div class="scientific-name">
				<span>${plant.sciName}</span>
			</div>
		</div>
		
		<div class ="img-container">
			<img class="plant-img" src="${plant.imgPath}">
		</div>
		
		<div class ="icon-container">
			<div class="sun-container">
				<div class="sun-img-container">
					<img class = "img-sun" src="Images/sun2.png">
				</div>
				<p class="para"><span>${plant.sunInfo}</span></p>				
			</div>
			
			<div class="water-container">
				<div class="water-img-container">
					<img class = "img-water" src="Images/watering_can2.png">
				</div>
				<p class="para">${plant.waterInfo}</p>
			</div>
			
		</div>
		
		<h2>Description</h2>
		<p class ="desc-container">
			<span>${plant.plantDescription}</span>
			(Wikipedia)
		</p>
		
	</div>
	
</body>

</html>