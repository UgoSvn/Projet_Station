<!DOCTYPE html>
<html lang="fr">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale1=1, shrink-to-fit=no>
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Accueil</title>
	
	 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat|Open+Sans+Condensed:300&display=swap" rel="stylesheet">

    <!-- Font awesome -->
    <script src="https://kit.fontawesome.com/8fc4291567.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Teko:700&display=swap" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
	
	<!-- Style sheet CSS -->
	<link rel="stylesheet" type="text/css" href="css/accueil.css" />
</head>

<body>
<!-- Form permettant d'ajouter en URL des infos -->
<form action="List.jsp" name="form" type="hidden">
	<div class="container-fluid">
		
		<div class="row">
			<div class="col-12 col-md-12 navbare">
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
					      			<li class="nav-item active">
					        			<a class="nav-link" href="#">Home</a>
					      			</li>
					    		</ul>
					  		</div>
					  	</div>
					</nav>
				</div>
			</div>	
		</div>
		
		<!-- Affichage du titre -->
		<div class="row">
			<div class="col-md-12 titre">
				<br /><br /><br /><br /><br /><br /><h1>FIND THE NEAREST / GAZ STATION</h1>
			</div>
		</div>
	
		<!-- Gestion des Layout -->
		<div class="row">
			<div class="col-12 col-md-1 nothing">

	        </div>
			<!-- Colonne 1 -->
			<div class="col-12 col-md-4 description d-flex align-items-center">
                <h2><br>Don't waste your time anymore and try our solution to find the nearest most efficient gas station in 
				a single click. Fast and 100% reliable, you can drive safely alll around the country without thinking of where to 
				find an opened and well equipped gas station. Try it now and you'll never regret.</h2>
            </div>
			<div class="col-12 col-md-1 nothing">

	        </div>
	        <!-- Colonne 2 -->
	        <div class="col-12 col-md-6 try">
				<h3><br><br>TRY IT OUT NOW</h3>
				<center><img src="css/images/arrow.png" alt="Fleche" widht="50"/></center> <!-- Ajout de l'image de fleche -->
	        </div>
	        
		</div>
	
	
		
		<div class="row">
			<!-- Colonne 1 -->
			<div class="col-12 col-md-6 test d-flex align-items-center">
				<h2 style="
				padding-left: 50px;
				padding-right: 50px;
				">...</h2>
			</div>
			
			<!-- Colonne 2 -->
			<div class="col-12 col-md-6 choix d-flex align-items-center">
					<!-- Colonne 2.1 -->
					<div class="col-md-3 text1 d-flex align-items-center">
						<p class="ml-auto">Distance (km)</p>
					</div>
					<!-- Colonne 2.2 -->
					<div class="col-md-3 choix1 d-flex align-items-center">
						<center><select name="km" id="km"> <!-- Ajout du menu déroulant -->
						  <option>5</option>
						  <option>10</option>
						  <option>25</option>
						  <option>50</option>
						  <option>100</option>
						  <option>250</option>
						  <option>500</option>
						</select></center>
					</div>
					<!-- Colonne 2.3 -->
					<div class="col-md-3 text2 d-flex align-items-center">
						<p class="ml-auto">Num. Results</p>
					</div>
					<!-- Colonne 2.4 -->
					<div class="col-md-3 choix2 d-flex align-items-center">
						<center><select name="nbr"> <!-- Ajout du menu déroulant -->
						  <option>10</option>
						  <option>25</option>
						  <option>50</option>
						  <option>100</option>
						</select></center>
					</div>
				</div>
		</div>
	
	
		<div class="row">
			<!-- Colonne 1 -->
			<div class="col-12 col-md-6 nothing d-flex align-items-center"></div>


			<!-- Colonne 2 -->
			<div class="col-12 col-md-6 buttonfind">
				<br />
					<!-- Ajout du bouton pour ajouter les coordonnées GPS de l'utilisateur qui désactive le bouton de validation tant que celui-ci n'est pas utilisé -->
					<!-- Avec deux champs cachées contenant la longitude et la latitude -->
					<center><button class="btn btn-outline-warning" name="test" onclick="document.getElementById('submit').disabled=false; getLocation(); return false; ">Avoir les coordonnees GPS</button><center><br /><br />
					<input class="btn btn-outline-warning" type="submit" id="submit" name="submit" disabled="disabled"/><input type="hidden" name="lat" id="lat" /> <input type="hidden" name="long" id="long" />
					
				</form>

				<!-- Script qui permet de recuperer les coordonnees GPS de l'utilisateur -->
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
			</div>

		</div>
		
		<div class="row">
			<div class="col-md-12 nothing">
				<br /> <br />
			</div>
		</div>
		
		<!-- Footer -->
		<footer class="container-fluid">
	        <div class="row justify-content-around align-items-center">
	            <div class="col-12 col-md-4 text-center">
	                <a href="https://www.facebook.com/Page.ESIGELEC/" target="_blank"> <!-- Lien avec les réseaux sociaux --> 
	                    <i class="fab fa-facebook"></i>
	                </a>
	                
	                <a href="https://www.instagram.com/esigelec_officiel/?hl=fr" target="_blank"> <!-- Lien avec les réseaux sociaux -->
	                    <i class="fab fa-instagram"></i>
	                </a>
	                
	                <a href="https://www.youtube.com/user/ESIGELECIRSEEM" target="_blank"> <!-- Lien avec les réseaux sociaux -->
	                    <i class="fab fa-youtube"></i>
	                </a>
	            </div>
	        </div>
	    </footer>
		
	</div>
	
</form>	
</body>

</html>