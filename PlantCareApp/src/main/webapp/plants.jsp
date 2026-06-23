<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
      <meta charset="ISO-8859-1">
      <title>Browse Plants</title>
      <link rel="stylesheet" href="styles.css">
  </head>
  <body class="bg">
      <ul class="nav">
          <li><a href="index.html">Home</a></li>
          <li><a href="plants">Browse</a></li>
          <li><a href="about.html">About</a></li>
          <li><a href="contact.html">Contact</a></li>
      </ul>

      <div class="content-wide">
          <h1>Browse All Plants</h1>
          <div class="plant-grid">
              <c:forEach var="plant" items="${plants}">
                  <c:url value="search" var="searchUrl">
                      <c:param name="search" value="${plant.commonName}"/>
                  </c:url>
                  <a class="plant-card" href="${searchUrl}">
                      <img src="${plant.imgPath}" alt="${plant.commonName}">
                      <div class="plant-card-info">
                          <h3>${plant.commonName}</h3>
                          <p>${plant.sciName}</p>
                      </div>
                  </a>
              </c:forEach>
          </div>
      </div>
  </body>
</html>