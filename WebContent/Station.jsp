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

	<title>Ma Station</title>
	
	 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans+Condensed:300&display=swap" rel="stylesheet">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/8fc4291567.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Teko:700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	
	<!-- Style sheet CSS -->
	<link rel="stylesheet" type="text/css" href="css/station.css" />
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
			<div class="col-md-3 nothing">
			</div>
			<div class="col-md-6 station">
				<%DomParser a = new DomParser();
				
				double longitude = 0;
				double latitude = 0;
				String paramlat = request.getParameter("lat");
				String paramlong = request.getParameter("long");
				longitude = Double.parseDouble(paramlat);
				latitude = Double.parseDouble(paramlong);
				
				String n_param = request.getParameter("n");
				int n = Integer.parseInt(n_param);
				String id = request.getParameter("id");
				ArrayList<String> listServ =new ArrayList<String>();
				ArrayList<String> listHoraire =new ArrayList<String>();
				ArrayList<String> listAdr =new ArrayList<String>();
				listAdr = a.stationCpTypeAdrVil(id);
				listServ = a.stationServices(id);
				listHoraire = a.stationHorairesDuJour(id);
				%>
				
				<h1>Station <%=n%> situé à <%=a.stationKm(latitude,longitude,id) %> km</h1>

				<p>Adresse : <%if(listAdr.size()>3){%>
				<%=listAdr.get(3)%>  <%=listAdr.get(2)%>  <%=listAdr.get(4)%></p>
				<%}%>
				
				<p> Horaire : <br /><%
					for(int i = 0; i < listHoraire.size(); i++){%>
						<%=listHoraire.get(i)%>h  
					<%}
				%></p>
				
				<p> Services :<br /> <%
					for(int i = 0; i < listServ.size(); i++){%>
						<%=listServ.get(i)%><br />
					<%}
				%></p>
				<p> Prix : <br /><%
					for(int i = 0; i < a.stationPrix(id).size(); i++){%>
						<%=a.stationPrix(id).get(i)%><br />
					<%}
				%></p>
				
				<p>Type : <%if(listAdr.size()>3){%><%=listAdr.get(1)%><br /><%}%>
				</p>
					
				<br />
			</div>
			<div class="col-md-3 nothing">
			</div>
		</div>
		
	
		<div class="row">
			<div class="col-md-12 nothing">
				<br />
			</div>
		</div>
		
		<div class="row">
	        <div class="col-md-12 buttonretour">
				<center><a href="Accueil.jsp"><button type="button" class="btn btn-outline-warning">RETOUR</button></center></a>
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