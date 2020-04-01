<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    import="fr.esigelec.jee.*"
%>

<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale1=1, shrink-to-fit=no>
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Apply More Filter</title>
	
	 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans+Condensed:300&display=swap" rel="stylesheet">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/8fc4291567.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Teko:700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	
	<!-- Style sheet CSS -->
	<link rel="stylesheet" type="text/css" href="css/applymorefilter.css" />
</head>

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
	
	function getChecked(){
		var checked = document.querySelector('input[type=checkbox]:checked')
		if(checked){
			return 1;
		}else{
			return 0;
		}
	}
</script>
				
<body>
<form action="List.jsp" name="form" type="hidden">
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
					      			<li class="nav-item active">
					        			<a class="nav-link" href="#">Apply more filters</a>
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
					<!-- Colonne 1 -->
					<div class="col-md-2 text1">
						<p>Distance (km)</p>
					</div>
					<!-- Colonne 2 -->
					<div class="col-md-1 choix1">
						<center>
							<select name="km" id="km">
							  <option>5</option>
							  <option>10</option>
							  <option>25</option>
							  <option>50</option>
							  <option>100</option>
							  <option>250</option>
							  <option>500</option>
							</select>
						</center>
					</div>
					<!-- Colonne 3 -->
					<div class="col-md-2 text2 ">
						<p>Num. Results</p>
					</div>
					<!-- Colonne 4 -->
					<div class="col-md-1 choix2">
						<center>
							<select name="nbr">
							  <option>10</option>
							  <option>25</option>
							  <option>50</option>
							  <option>100</option>
							</select>
						</center>
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
			<div class="col-md-2 check d-flex align-items-center">
				
			</div>
			<div class="col-md-3 check d-flex align-items-center">
				<p>
					Type de station-service :<br />
					<input type="checkbox" name="c1l1" value="Station-service autoroute" onclick= "getChecked()" />  Station-service autoroute<br />
					<input type="checkbox" name="c1l2" value="Station-service route" />  Station-service route<br />
					<input type="checkbox" name="c1l3" value="Autres stations-service" />  Autres stations-service<br />
				</p>
			</div>
			<div class="col-md-3 check d-flex align-items-center">
				<p>
					<bold>Produits :</bold><br />
					<input type="checkbox" name="c2l1" value="Gazole" />  Gazole<br />
					<input type="checkbox" name="c2l2" value="SP 95" />  SP 95<br />
					<input type="checkbox" name="c2l3" value="SP 98" />  SP 98<br />
					<input type="checkbox" name="c2l4" value="GPLc" />  GPLc<br />
					<input type="checkbox" name="c2l5" value="E10" />  E10<br />
					<input type="checkbox" name="c2l6" value="E85" />  E85<br />
				</p>
			</div>
			<div class="col-md-3 check d-flex align-items-center">
				<p>
					Services :<br />
					<input type="checkbox" name="c3l1" value="Restauration à emporter" />  Restauration à emporter<br />
					<input type="checkbox" name="c3l2" value="Toilettes publiques" />  Toilettes publiques<br />
					<input type="checkbox" name="c3l3" value="Bar" />  Bar<br />
					<input type="checkbox" name="c3l4" value="Boutique alimentaire" />  Boutique alimentaire<br />
					<input type="checkbox" name="c3l5" value="Station de gonflage" />  Station de gonflage<br />
					<input type="checkbox" name="c3l6" value="DAB(Distributeur Automatique de Billet)" />  DAB(Distributeur Automatique de Billet)<br />
					<input type="checkbox" name="c3l7" value="Lavage automatique" />  Lavage automatique<br />
				</p>
			</div>
			<div class="col-md-1 check d-flex align-items-center">
				
			</div>
		</div>
	
	
		<div class="row">
	        <div class="col-md-12 buttonfind">
				<br />
					<center><button class="btn btn-outline-warning" name="test" onclick="document.getElementById('submit').disabled=false; getLocation(); return false; ">Avoir les coordonnees GPS</button><center><br /><br />
					<input class="btn btn-outline-warning" type="submit" id="submit" name="submit" disabled="disabled"/><input type="hidden" name="lat" id="lat" /> <input type="hidden" name="long" id="long" />
					<p id="demo"></p>
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
	
</form>
</body>

</html>