<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    import="fr.esigelec.jee.*"
    import="java.util.ArrayList"
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale1=1, shrink-to-fit=no>
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Liste des stations</title>
	
	 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans+Condensed:300&display=swap" rel="stylesheet">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/8fc4291567.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Teko:700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	
	<!-- Style sheet CSS -->
	<link rel="stylesheet" type="text/css" href="css/list.css" />
</head>

<body>
	
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-md-12 navbare">
				<!-- NavBar -->
				<div class="my-navebar">
					<nav class="my-navbar navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
						<div class="container">
					  		<a class="navbar-brand" href="#"></a>
					  		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					    	<span class="navbar-toggler-icon"></span>
					  	  </button>
					
					  		<div class="collapse navbar-collapse" id="navbarSupportedContent">
					    		<ul class="navbar-nav ml-auto">
					    			<li class="nav-item">
					        			<a class="nav-link" href="AboutUs.jsp">About us</a>
					      			</li>
					      			<li class="nav-item">
					        			<a class="nav-link" href="ApplyMoreFilter.jsp">Apply more filters</a>
					      			</li>
					      			<li class="nav-item">
					        			<a class="nav-link" href="Accueil.jsp">Home</a>
					      			</li>
					    		</ul>
					  		</div>
					  	</div>
					</nav>
				</div>
			</div>	
		</div>
		
		<div class="row">
			<div class="col-md-12 titre">
				<br /><br /><br /><br /><br /><br /><h1>FIND A GAZ STATION</h1>
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12 soustitre">
				<p>Liste des stations les plus proches de vous</p><br />
			</div>
		</div>
		
		<div class="row">
			<%DomParser a = new DomParser();%>

			<%
			
			double longitude = 0;
			double latitude = 0;
			String paramlat = request.getParameter("lat");
			String paramlong = request.getParameter("long");
			String km = request.getParameter("km");
			String param_n = request.getParameter("nbr");
			int n = Integer.parseInt(param_n);
			longitude = Double.parseDouble(paramlat);
			latitude = Double.parseDouble(paramlong);
			ArrayList<String> liste = a.stationLaNEmePlusProche(longitude,latitude,n, km);
			%>
			
			<div class="col-md-1 nothing">
			</div>
			<div class="col-md-2 station1">
				<% n=1; %>
				<br /><br />
				<%if(liste.size()>1) {%>
				<h1>Station 1 situé à <%=liste.get(1) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=1&amp;id=<%=liste.get(0)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="1">Voir</button></a></center>
				<%}%>
				
			</div>
			<div class="col-md-2 station2">
				<% n=2; %>
				<br /><br />
				<%if(liste.size()>3) {%>
				<h1>Station 2 situé à <%=liste.get(3) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=2&amp;id=<%=liste.get(2)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="2">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station3">
				<% n=3; %>
				<br /><br />
				<%if(liste.size()>5) {%>
				<h1>Station 3 situé à <%=liste.get(5) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=3&amp;id=<%=liste.get(4)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning"id="3">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station4">
				<% n=4; %>
				<br /><br />
				<%if(liste.size()>7) {%>
				<h1>Station 4 situé à <%=liste.get(7) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=4&amp;id=<%=liste.get(6)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="4">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station5">
				<% n=5; %>
				<br /><br />
				<%if(liste.size()>9) {%>
				<h1>Station 5 situé à <%=liste.get(9) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=5&amp;id=<%=liste.get(8)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="5">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-1 nothing">
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-1 nothing">
			</div>
			<div class="col-md-2 station6">
				<% n=6; %>
				<br /><br />
				<%if(liste.size()>11) {%>
				<h1>Station 6 situé à <%=liste.get(11) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=6&amp;id=<%=liste.get(10)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="6">Voir</button></a></center>
				<%}
				else{%><br /><br /><br /><br /><br /><br /><br /><%}
				%>
			</div>
			<div class="col-md-2 station7">
				<% n=7; %>
				<br /><br />
				<%if(liste.size()>13) {%>
				<h1>Station 7 situé à <%=liste.get(13) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=7&amp;id=<%=liste.get(12)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="7">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station8">
				<% n=8; %>
				<br /><br />
				<%if(liste.size()>15) {%>
				<h1>Station 8 situé à <%=liste.get(15) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=8&amp;id=<%=liste.get(14)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="8">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station9">
				<% n=9; %>
				<br /><br />
				<%if(liste.size()>17) {%>
				<h1>Station 9 situé à <%=liste.get(17) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=9&amp;id=<%=liste.get(16)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="9">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-2 station10">
				<% n=10; %>
				<br /><br />
				<%if(liste.size()>19) {%>
				<h1>Station 10 situé à <%=liste.get(19) %> km</h1>
				<br />
				<center><a href="Station.jsp?n=10&amp;id=<%=liste.get(18)%>&amp;lat=<%=latitude%>&amp;long=<%=longitude%>"><button type="button" class="btn btn-outline-warning" id="10">Voir</button></a></center>
				<%}%>
			</div>
			<div class="col-md-1 nothing">
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-12 nothing">
				<br />
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 nothing">
				<br /><br /><br />
			</div>
		</div>
		
		<!-- Footer -->
		<footer class="container-fluid">
	        <div class="row justify-content-around align-items-center">
	            <div class="col-12 col-md-4 text-center">
	                <a href="https://www.facebook.com/Page.ESIGELEC/" target="_blank">
	                    <i class="fab fa-facebook"></i>
	                </a>
	                
	                <a href="https://www.instagram.com/esigelec_officiel/?hl=fr" target="_blank">
	                    <i class="fab fa-instagram"></i>
	                </a>
	
	                <a href="https://www.youtube.com/user/ESIGELECIRSEEM" target="_blank">
	                    <i class="fab fa-youtube"></i>
	                </a>
	            </div>
	        </div>
	    </footer>
		
	</div>
	
	
</body>

</html>