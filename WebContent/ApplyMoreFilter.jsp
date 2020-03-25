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
							<select name="select">
							  <option>5</option>
							  <option>1	0</option>
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
							<select name="select">
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
					<input type="checkbox" name="colors" value="Station-service autoroute" />  Station-service autoroute<br />
					<input type="checkbox" name="colors" value="Station-service route" />  Station-service route<br />
					<input type="checkbox" name="colors" value="Autres stations-service" />  Autres stations-service<br />
				</p>
			</div>
			<div class="col-md-3 check d-flex align-items-center">
				<p>
					<bold>Produits :</bold><br />
					<input type="checkbox" name="colors" value="Gazole" />  Gazole<br />
					<input type="checkbox" name="colors" value="SP 95" />  SP 95<br />
					<input type="checkbox" name="colors" value="SP 98" />  SP 98<br />
					<input type="checkbox" name="colors" value="GPLc" />  GPLc<br />
					<input type="checkbox" name="colors" value="E10" />  E10<br />
					<input type="checkbox" name="colors" value="E85" />  E85<br />
				</p>
			</div>
			<div class="col-md-3 check d-flex align-items-center">
				<p>
					Services :<br />
					<input type="checkbox" name="colors" value="Restauration � emporter" />  Restauration � emporter<br />
					<input type="checkbox" name="colors" value="Toilettes publiques" />  Toilettes publiques<br />
					<input type="checkbox" name="colors" value="Bar" />  Bar<br />
					<input type="checkbox" name="colors" value="Boutique alimentaire" />  Boutique alimentaire<br />
					<input type="checkbox" name="colors" value="Station de gonflage" />  Station de gonflage<br />
					<input type="checkbox" name="colors" value="DAB(Distributeur Automatique de Billet)" />  DAB(Distributeur Automatique de Billet)<br />
					<input type="checkbox" name="colors" value="Lavage automatique" />  Lavage automatique<br />
				</p>
			</div>
			<div class="col-md-1 check d-flex align-items-center">
				
			</div>
		</div>
	
	
		<div class="row">
	        <div class="col-md-12 buttonfind">
				<center><a href="List.jsp"><button type="button" class="btn btn-outline-warning">FIND</button></a></center>
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