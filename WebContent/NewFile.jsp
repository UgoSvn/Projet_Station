<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="fr.esigelec.jee.*"%>
<!DOCTYPE html>
<html>
<body>

	<form action="List.jsp" name="form">

		<button onclick="getLocation()">Avoir les coordonnées GPS</button>

		<input type="submit" id="submit" name="submit" /><input type="text"
			name="lat" id="lat" /> <input type="text" name="long" id="long" />

		<p id="demo"></p>

	</form>

	<script>
		var x = document.getElementById("demo");

		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition);
			} else {
				x.innerHTML = "Veuillez activer position .";
			}
		}

		function showPosition(position) {
			document.getElementById("long").value = position.coords.longitude;
			document.getElementById("lat").value = position.coords.latitude;
		}
	</script>
</body>
</html>